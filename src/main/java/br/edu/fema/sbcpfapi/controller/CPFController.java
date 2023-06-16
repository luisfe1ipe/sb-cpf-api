package br.edu.fema.sbcpfapi.controller;

import br.edu.fema.sbcpfapi.domain.cpf.service.CPFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cpf")
public class CPFController {

    @Autowired
    private CPFService cpfService;

    @GetMapping("/{cpf}")
    public Boolean cpf(@PathVariable("cpf") String cpf) {
        final Boolean message = cpfService.validate(cpf);
        return message;
    }

}
