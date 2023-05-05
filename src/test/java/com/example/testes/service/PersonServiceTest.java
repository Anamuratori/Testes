package com.example.testes.service;

import com.example.testes.domain.Person;
import com.example.testes.domain.VotoEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {
    PersonService service = new PersonService();
    @Test
    public void checkAgeOver18 () {
        Person person = new Person(15);
        Boolean result = service.isAdult(person);
        Assertions.assertFalse(result);
    }

    @Test
    public void checkNonCompulsoryVoteOver70() {
        Person person = new Person(70);
        String result = service.canVote(person);
        Assertions.assertEquals("Voto opcional", result);
    }

    @Test
    public void checkNonCompulsoryVoteUnder18() {
        Person person = new Person(17);
        String result = service.canVote(person);
        Assertions.assertEquals("Voto opcional", result);
    }

    @Test
    public void checkCompulsoryVote() {
        Person person = new Person(18);
        String result = service.canVote(person);
        Assertions.assertEquals("Voto obrigatorio", result);
    }
    @Test
    public void checkCasesCompulsoryVote () {
        for (int i = 18; i < 70 ; i++) {
            Assertions
                    .assertEquals(VotoEnum.OBRIGATORIO,
                    service.canVoteEnum(new Person(i)));
        }
    }
    @Test
    public void checkCasesIneligibleVote () {
        for (int i = 0; i < 16; i++) {
            Assertions
                    .assertEquals(VotoEnum.INELEGIVEL,
                            service.canVoteEnum(new Person(i)));
        }
    }
/*    @Test
    public void checkCasesNonCompulsoryVote () {
        for (int i = 16; i < 18; i++) {
            Assertions
                    .assertEquals(VotoEnum.OPCIONAL,
                            service.canVoteEnum(new Person(i)));
        }

        for (int i = 70; i < 100; i++) {
            Assertions
                    .assertEquals(VotoEnum.OPCIONAL,
                            service.canVoteEnum(new Person(i)));
        }
    }*/

    @Test
    public void checkCasesNonCompulsoryVote2 () {
        for (int i = 16; i < 100; i++) {
            Assertions
                    .assertEquals(VotoEnum.OPCIONAL,
                            service.canVoteEnum(new Person(i)));
            if (i == 17) {
                i = 69;
            }
        }
    }
}
