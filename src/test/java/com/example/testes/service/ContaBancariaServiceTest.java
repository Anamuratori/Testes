package com.example.testes.service;

import com.example.testes.domain.ContaBancaria;
import com.example.testes.exception.SaldoInsuficienteException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContaBancariaServiceTest {

    ContaBancariaService service = new ContaBancariaService();
    @Test
    public void depositarTest () {
        ContaBancaria conta = new ContaBancaria ();
        service.depositar(conta, 100.00);
        Assertions.assertEquals(100.00, conta.getSaldo());

        service.depositar(conta, 100.00);
        Assertions.assertEquals(200.00, conta.getSaldo());
        System.out.println("funcionou");
    }
    @Test
    public void sacarTest(){
        ContaBancaria conta = new ContaBancaria();
        service.depositar(conta, 100.00);
        service.sacar(conta, 100.00);
        Assertions.assertEquals(0, conta.getSaldo());

        service.depositar(conta, 100.00);
        service.sacar(conta, 50.00);
        Assertions.assertEquals(50.00, conta.getSaldo());

        service.sacar(conta, 20.00);
        service.sacar(conta, 30.00);
        Assertions.assertEquals(0, conta.getSaldo());

        Assertions.assertThrows(SaldoInsuficienteException.class, () -> service.sacar(conta,100.00));
/*
        Assertions.assertEquals(SaldoInsuficienteException.getMessage().contentEquals(0));*/

    }

    @Test
    public void transferirTest() {
        ContaBancaria contaTransferindo = new ContaBancaria();
        ContaBancaria contaRecebendo = new ContaBancaria();

        service.depositar(contaTransferindo, 100.00);
        service.transferir(contaTransferindo, contaRecebendo, 60.00);
        Assertions.assertEquals(40.00, contaTransferindo.getSaldo());
        Assertions.assertEquals(60.00, contaRecebendo.getSaldo());

        Assertions.assertThrows(SaldoInsuficienteException.class, () -> service
                .transferir(contaTransferindo, contaRecebendo, 40.02));

        Assertions.assertEquals(40.00, contaTransferindo.getSaldo());
        Assertions.assertEquals(60.00, contaRecebendo.getSaldo());

    }
}
