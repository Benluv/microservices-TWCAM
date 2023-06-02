package es.uv.bjtwcam.productores.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import es.uv.bjtwcam.productores.domain.Productor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UserDetailsImpl implements UserDetails {

    private final Productor productor;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return productor.getPassword();
    }

    @Override
    public String getUsername() {
       return productor.getEmail();
    }



    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNombre(){
        return productor.getName();
    }
    
}
