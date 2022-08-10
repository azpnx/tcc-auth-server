package com.tcc.psiauth.client;

import com.tcc.psiauth.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "psi-user", path = "/api/usuarios")
public interface UserClient {

    @GetMapping
    ResponseEntity<Usuario> findByEmail(@RequestParam String email);

}