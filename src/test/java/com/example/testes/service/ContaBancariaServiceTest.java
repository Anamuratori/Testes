package com.example.testes.service;

import com.example.testes.domain.ContaBancaria;
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
    }
}
