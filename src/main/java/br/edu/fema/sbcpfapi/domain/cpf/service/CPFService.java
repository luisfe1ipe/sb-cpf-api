package br.edu.fema.sbcpfapi.domain.cpf.service;

import br.edu.fema.sbcpfapi.domain.cpf.model.CPFResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CPFService {

    public CPFResponse validate(String cpf) {
        int somaUm = 0;
        int somaDois = 0;
        int numeroDez = Integer.parseInt(cpf.substring(9, 10));
        int numeroOnze = Integer.parseInt(cpf.substring(10, 11));
        System.out.println(numeroDez);
        System.out.println(numeroOnze);

        //Soma 10° digito
        for (int i = 0; i < 9; i++) {
            int numero = Integer.parseInt(cpf.substring(i, i + 1));
            somaUm = somaUm + numero * (10 - i);
        }

        System.out.println(somaUm);
        double restoUm = (somaUm * 10.0) % 11;
        if (restoUm == 10) {
            restoUm = 0;
        }
        System.out.println(restoUm);

        //Soma 11° digito
        for (int i = 0; i < 10; i++) {
            int numero = Integer.parseInt(cpf.substring(i, i + 1));
            somaDois = somaDois + numero * (11 - i);
        }

        double restoDois = (somaDois * 10.0) % 11;
        if (restoDois == 10) {
            restoDois = 0;
        }

        if (restoUm == numeroDez && restoDois == numeroOnze) {
            CPFResponse resultCpf = new  CPFResponse(cpf,"CPF Valido", true);
            System.out.println(resultCpf);
            return resultCpf;
        } else {
            String digits = String.valueOf(restoUm) + String.valueOf(restoDois);
            CPFResponse resultCpf = new CPFResponse(cpf, "CPF Invalido", false, digits);
            System.out.println(resultCpf);
            return resultCpf;
        }
    }

    public static void main(String[] args) {
        new CPFService().validate("42225443882");
    }
}
