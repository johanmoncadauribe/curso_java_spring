package com.platzi.springboot.supermercado.domain.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="controller-holaMundo")
public class holaMundo {

    @GetMapping(path="/saludar")
    public String saludar(){
        return "nunca pares de aprender!";
    }

}
