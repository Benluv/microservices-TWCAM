package es.uv.bjtwcam.mysql.security;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.AuthorityUtils;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.uv.bjtwcam.mysql.domain.Productor;
import es.uv.bjtwcam.mysql.repositories.ProductorRepository;
import jakarta.transaction.Transactional;


@Service
@Transactional
public class CustomUserDetailsService {
// public class CustomUserDetailsService implements UserDetailsService {

// 	@Autowired 
// 	ProductorRepository repo;
	
// 	@Override
// 	public UserDetails loadUserByUsername(String nif) throws UsernameNotFoundException {
// 		Productor user = repo.findByNif(nif).orElseThrow(() -> new UsernameNotFoundException("User not found"));
// 		return new org.springframework.security.core.userdetails.User(user.getNif(), 
// 														              user.getPassword(),
// 														              getAuthorities());
//     }

// 	private static Collection<? extends GrantedAuthority> getAuthorities() {
// 		return new HashSet<GrantedAuthority>();
//         // Collection<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
//         // return authorities;
//     }

}
