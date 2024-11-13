package com.example.palindromo.service;

import com.example.palindromo.domain.Palindromo;
import com.example.palindromo.domain.PalindromoResponse;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class PalindromoService {
    public static final Logger logger= Logger.getLogger(PalindromoService.class);
    public PalindromoResponse analizarPalindromo(Palindromo palindromo) {
        String cadena = palindromo.getTexto();
        int lengthCadena = cadena.length();

        logger.info("Analizando la cadena: " +  cadena);
        logger.debug("Longitud total de la cadena: " + lengthCadena);

        int lengthCaracteresEspeciales = contarCaracteresEspeciales(cadena);
        logger.debug("Número de caracteres especiales: " + lengthCaracteresEspeciales);

        boolean isPalindromo = esPalindromo(cadena);
        logger.info("Resultado de la verificación de palíndromo: " + isPalindromo);

        return new PalindromoResponse(lengthCadena, isPalindromo, lengthCaracteresEspeciales);
    }

    private int contarCaracteresEspeciales(String cadena) {
        Pattern pattern = Pattern.compile("[^a-zA-Z0-9 ]");
        Matcher matcher = pattern.matcher(cadena);
        int contador = 0;
        while (matcher.find()) {
            contador++;
        }
        logger.debug("Contador de caracteres especiales final: " + contador);
        return contador;
    }

    private boolean esPalindromo(String cadena) {
        String soloLetrasYNumeros = cadena.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String inverso = new StringBuilder(soloLetrasYNumeros).reverse().toString();
        boolean resultado = soloLetrasYNumeros.equals(inverso);

        logger.debug("Cadena solo con letras y números: " + soloLetrasYNumeros);
        logger.debug("Cadena invertida: " + inverso);
        logger.info("¿Es palíndromo? " + resultado);

        return resultado;
    }
}
