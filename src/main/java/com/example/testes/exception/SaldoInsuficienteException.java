package com.example.testes.exception;

public class SaldoInsuficienteException extends RuntimeException{
    public SaldoInsuficienteException(String errorMessage){
        super(errorMessage);
    }
}
