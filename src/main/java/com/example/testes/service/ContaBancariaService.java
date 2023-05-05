package com.example.testes.service;

import com.example.testes.domain.ContaBancaria;
import com.example.testes.exception.SaldoInsuficienteException;

public class ContaBancariaService {
    public void depositar(ContaBancaria conta, Double valor) {
        conta.setSaldo(conta.getSaldo() + valor);
    }
    public void sacar(ContaBancaria conta, Double valor) {
        if (conta.getSaldo() < valor ){
            throw new SaldoInsuficienteException("Sem saldo suficiente");
        }
        conta.setSaldo(conta.getSaldo() - valor);
    }

    public void transferir(ContaBancaria contaTransferindo, ContaBancaria contaRecebendo, Double valor) {
        sacar(contaTransferindo, valor);
        depositar(contaRecebendo, valor);
    }

}
