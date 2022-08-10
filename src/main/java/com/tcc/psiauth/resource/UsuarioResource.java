package com.tcc.psiauth.resource;

import com.tcc.psiauth.model.Usuario;
import com.tcc.psiauth.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
@RequiredArgsConstructor
public class UsuarioResource {
    private final UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<Usuario> findByEmail(@RequestParam String email){
        try {
            Usuario usuario = usuarioService.findByEmail(email);
            return ResponseEntity.ok(usuario);
        }catch (IllegalArgumentException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
