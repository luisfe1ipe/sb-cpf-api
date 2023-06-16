package br.edu.fema.sbcpfapi.controller;

import br.edu.fema.sbcpfapi.domain.cpf.service.CPFService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cpf")
public class CPFController {

    private CPFService cpfService;

    @GetMapping("/{cpf}")
    public String cpf(@PathVariable("cpf") String cpf) {
        final String message = cpfService.validar(cpf);
        return message;
    }

}
