package com.example.testes.service;

import com.example.testes.domain.ContaBancaria;

public class ContaBancariaService {
    public void depositar(ContaBancaria conta, Double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }
}
