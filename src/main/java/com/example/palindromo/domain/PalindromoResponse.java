package com.example.palindromo.domain;

public class PalindromoResponse {
    private int lengthCadena;
    private boolean isPalindromo;
    private int lengthCaracteresEspeciales;

    public PalindromoResponse(int lengthCadena, boolean isPalindromo, int lengthCaracteresEspeciales) {
        this.lengthCadena = lengthCadena;
        this.isPalindromo = isPalindromo;
        this.lengthCaracteresEspeciales = lengthCaracteresEspeciales;
    }

    public int getLengthCadena() {
        return lengthCadena;
    }

    public boolean getIsPalindromo() {
        return isPalindromo;
    }

    public int getLengthCaracteresEspeciales() {
        return lengthCaracteresEspeciales;
    }
}
