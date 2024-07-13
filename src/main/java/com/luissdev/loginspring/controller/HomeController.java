package com.luissdev.loginspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/home")
    public String home(){
        return "De vuelta a casa";
    }

    @GetMapping("/admin")
    /*Antest PreAuthorize("hasRole('admin)"), pero como estamos ahora usando authorities se debe usar hasAuthority
     y agregar en SecurityConfig la anotación  @EnableMethodSecurity
    * */
    @PreAuthorize("hasAuthority('admin')")
    public String admin(){
        return "Ruta solo para admin";
    }
}
