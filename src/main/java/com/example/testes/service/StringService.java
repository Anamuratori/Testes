package com.example.testes.service;

public class StringService {
    public String replaceLetter(String letra, String palavra) {
        return palavra.toUpperCase().replaceFirst(letra.toUpperCase(), "");
    }
}
