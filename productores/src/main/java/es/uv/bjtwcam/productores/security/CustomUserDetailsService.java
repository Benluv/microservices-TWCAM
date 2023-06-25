package es.uv.bjtwcam.productores.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import es.uv.bjtwcam.productores.domain.Productor;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
    private RestTemplate template;

	
	@Override
	public UserDetails loadUserByUsername(String nif) throws UsernameNotFoundException {
		
	
		ResponseEntity<Productor> response;
		String url = "http://localhost:3307/api/v1/productor";
		try {
			response = template.getForEntity(url + "?id=" + nif, Productor.class);
		} catch (Exception e) {
			throw new UsernameNotFoundException("User not found");
		}

		return new org.springframework.security.core.userdetails.User(response.getBody().getNif(), 
														              response.getBody().getPassword(),
														              getAuthorities());
    }

	private static Collection<? extends GrantedAuthority> getAuthorities() {
		return new HashSet<GrantedAuthority>();
        // Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
        // return authorities;
    }

}
