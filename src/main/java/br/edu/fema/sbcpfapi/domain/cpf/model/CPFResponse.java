package br.edu.fema.sbcpfapi.domain.cpf.model;

public class CPFResponse {
    private String cpf;
    private String status;
    private boolean valid;
    private int digits;

    public CPFResponse(String cpf, String status, boolean valid, int digits) {
        this.cpf = cpf;
        this.status = status;
        this.valid = valid;
        this.digits = digits;
    }
}
