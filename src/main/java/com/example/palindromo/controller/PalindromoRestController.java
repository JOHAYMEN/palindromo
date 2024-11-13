package com.example.palindromo.controller;

import com.example.palindromo.domain.Palindromo;
import com.example.palindromo.domain.PalindromoResponse;
import com.example.palindromo.service.PalindromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PalindromoRestController {

    private final PalindromoService palindromoService;

    @Autowired
    public PalindromoRestController(PalindromoService palindromoService) {
        this.palindromoService = palindromoService;
    }

    @PostMapping("/verificar-palindromo")
    public PalindromoResponse verificarPalindromo(@RequestBody Palindromo request) {
        return palindromoService.analizarPalindromo(request);
    }
}
