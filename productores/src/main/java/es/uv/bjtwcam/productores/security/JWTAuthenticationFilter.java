package es.uv.bjtwcam.productores.security;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
        
        AuthCredentials authCredentials = new AuthCredentials();

        try{
        authCredentials=new ObjectMapper().readValue(request.getReader(),AuthCredentials.class);
        }
        catch (IOException e){

        }

        UsernamePasswordAuthenticationToken usernamePAT= new UsernamePasswordAuthenticationToken(
            authCredentials.getEmail(),
            authCredentials.getPassword(),
            Collections.emptyList()
            );
            //log.info("El mail es: "+authCredentials.getEmail() + " el password es : "+authCredentials.getPassword());
        return getAuthenticationManager().authenticate(usernamePAT);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException
    {
       UserDetailsImpl userDetails= (UserDetailsImpl) authResult.getPrincipal(); 
       Map<String, String> mapa=new HashMap<>();
       
       String token = TokenUtils.createToken(userDetails.getNombre(), userDetails.getUsername() );
       mapa.put("El token es: ",token);

       response.addHeader("Authorization","Bearer "+token);
       response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");
       response.getWriter().write(new ObjectMapper().writeValueAsString(mapa));
       response.getWriter().flush();

       super.successfulAuthentication(request, response, chain, authResult);
    }
    
}
