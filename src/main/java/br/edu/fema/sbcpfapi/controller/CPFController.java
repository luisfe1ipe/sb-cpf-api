package br.edu.fema.sbcpfapi.controller;

import br.edu.fema.sbcpfapi.domain.cpf.model.CPFResponse;
import br.edu.fema.sbcpfapi.domain.cpf.service.CPFService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cpf")
public class CPFController {

    @Autowired
    private CPFService cpfService;

    @GetMapping("/{cpf}")
    public ResponseEntity cpf(@PathVariable("cpf") String cpf) {
        CPFResponse resultCpf =  cpfService.validate(cpf);
        if (resultCpf.isValid()) {
            return ResponseEntity.ok(resultCpf);
        }else {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(resultCpf);
        }
    }

}
