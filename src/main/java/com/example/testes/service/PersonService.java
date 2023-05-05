package com.example.testes.service;

import com.example.testes.domain.Person;
import com.example.testes.domain.VotoEnum;

public class PersonService {

    public Boolean isAdult(Person person){
        if (person.getAge() > 18) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    public String canVote (Person person) {
        if (person.getAge() < 16) {
            return "Nao pode votar";
        } else if ((person.getAge() >= 16 && person.getAge() < 18) || person.getAge() >= 70) {
            return "Voto opcional";
        } else {
            return "Voto obrigatorio";
        }
    }

    public VotoEnum canVoteEnum (Person person) {
        if (person.getAge() < 16) {
            return VotoEnum.INELEGIVEL;
        } else if ((person.getAge() >= 16 && person.getAge() < 18) || person.getAge() >= 70) {
            return VotoEnum.OPCIONAL;
        } else {
            return VotoEnum.OBRIGATORIO;
        }
    }


}
