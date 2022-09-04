package com.tcc.psiauth.service;

import com.tcc.psiauth.client.UserClient;
import com.tcc.psiauth.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.UserDeniedAuthorizationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private static Logger logger = LoggerFactory.getLogger(UsuarioService.class);
    private final UserClient userClient;

    public Usuario findByEmail(String email){
        Usuario usuario = userClient.findByEmail(email).getBody();
        if (usuario == null){
            logger.error("Usuário não encontrado!");
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        if (!usuario.isEnabled()) throw new UserDeniedAuthorizationException("Confirme o seu e-mail para prosseguir!");
        logger.info("Usuario encontrado! ");
        return usuario;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userClient.findByEmail(username).getBody();
        if (usuario == null){
            logger.error("Usuário não encontrado!");
            throw new UsernameNotFoundException("Email not found");
        }
        if (!usuario.isEnabled()) throw new UserDeniedAuthorizationException("Confirme o seu e-mail para prosseguir!");
        logger.info("Usuario encontrado! ");
        return usuario;
    }
}
