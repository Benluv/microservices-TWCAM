package es.uv.bjtwcam.productores.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import es.uv.bjtwcam.productores.domain.Productor;
import es.uv.bjtwcam.productores.repositories.ProductorRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private ProductorRepository pr;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
    Productor p =  pr
        .findByEmail(email)
        .orElseThrow(()-> new UsernameNotFoundException("El usuario "+email+" no existe"));

        return new UserDetailsImpl(p);
    }
    
}
