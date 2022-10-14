package com.tcc.psiauth.client;

import com.tcc.psiauth.model.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "psi-user", path = "")
public interface UserClient {


    @GetMapping("/findByEmail")
    ResponseEntity<Usuario> findByEmail(@RequestParam String email);

}