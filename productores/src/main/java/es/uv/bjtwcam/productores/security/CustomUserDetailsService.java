package es.uv.bjtwcam.productores.security;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.uv.bjtwcam.productores.domain.Productor;
import es.uv.bjtwcam.productores.repositories.ProductorRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired 
	ProductorRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String nif) throws UsernameNotFoundException {
		Productor user = repo.findByNif(nif).orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return new org.springframework.security.core.userdetails.User(user.getNif(), 
														              user.getPassword(),
														              getAuthorities(user));
    }

	private static Collection<? extends GrantedAuthority> getAuthorities(Productor user) {
        Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
        return authorities;
    }

}
