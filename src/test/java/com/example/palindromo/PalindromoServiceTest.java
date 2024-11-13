package com.example.palindromo;


import com.example.palindromo.domain.Palindromo;
import com.example.palindromo.domain.PalindromoResponse;
import com.example.palindromo.service.PalindromoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PalindromoServiceTest {

    private PalindromoService palindromoService;

    @BeforeEach
    public void setUp() {
        palindromoService = new PalindromoService();  // Crear la instancia del servicio antes de cada prueba
    }

    @Test
    public void testAnalizarPalindromo_CadenaPalindromo() {
        // Dado
        Palindromo palindromo = new Palindromo("anita lava la tina");

        // Cuando
        PalindromoResponse response = palindromoService.analizarPalindromo(palindromo);

        // Entonces
        assertEquals(18, response.getLengthCadena(), "La longitud de la cadena debe ser 18");
        assertEquals(true, response.getIsPalindromo(), "Debe ser un palíndromo");
        assertEquals(0, response.getLengthCaracteresEspeciales(), "No debe haber caracteres especiales");
    }

    @Test
    public void testAnalizarPalindromo_CadenaConCaracterEspecial() {
        // Dado
        Palindromo palindromo = new Palindromo("anita lava la *tina");

        // Cuando
        PalindromoResponse response = palindromoService.analizarPalindromo(palindromo);

        // Entonces
        assertEquals(19, response.getLengthCadena(), "La longitud de la cadena debe ser 18");
        assertEquals(true, response.getIsPalindromo(), "Debe ser un palíndromo");
        assertEquals(1, response.getLengthCaracteresEspeciales(), "Debe haber 1 carácter especial");
    }

    @Test
    public void testAnalizarPalindromo_CadenaNoPalindromo() {
        // Dado
        Palindromo palindromo = new Palindromo("hola mundo");

        // Cuando
        PalindromoResponse response = palindromoService.analizarPalindromo(palindromo);

        // Entonces
        assertEquals(10, response.getLengthCadena(), "La longitud de la cadena debe ser 10");
        assertEquals(false, response.getIsPalindromo(), "No debe ser un palíndromo");
        assertEquals(0, response.getLengthCaracteresEspeciales(), "No debe haber caracteres especiales");
    }
}
