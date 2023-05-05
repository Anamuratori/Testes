package com.example.testes.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringServiceTest {

    StringService service = new StringService();

    //input A, ABCD => BCD
    @Test
    public void test () {
        String retorno = service.replaceLetter("A", "ABCD");
        Assertions.assertEquals("BCD", retorno);

        retorno = service.replaceLetter("A", "AABCD");
        Assertions.assertEquals("ABCD", retorno);

        retorno = service.replaceLetter("A", "BABC");
        Assertions.assertEquals("BBC", retorno);

        retorno = service.replaceLetter("A", "BCDE");
        Assertions.assertEquals("BCDE", retorno);

        retorno = service.replaceLetter("a", "ABCD");
        Assertions.assertEquals("BCD", retorno);
    }
}
