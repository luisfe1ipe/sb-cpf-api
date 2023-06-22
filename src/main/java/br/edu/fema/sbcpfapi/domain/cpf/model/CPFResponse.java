package br.edu.fema.sbcpfapi.domain.cpf.model;

import lombok.Data;

@Data
public class CPFResponse {
    private String cpf;
    private String status;
    private boolean valid;
    private String digits;

    public CPFResponse(String cpf, String status, boolean valid) {
        this.cpf = cpf;
        this.status = status;
        this.valid = valid;
    }

    public CPFResponse(String cpf, String status, boolean valid, String digits) {
        this.cpf = cpf;
        this.status = status;
        this.valid = valid;
        this.digits = digits;
    }

    public boolean isValid() {
        return valid;
    }

    @Override
    public String toString() {
        return "CPFResponse{" +
                "cpf='" + cpf + '\'' +
                ", status='" + status + '\'' +
                ", valid=" + valid +
                ", digits='" + digits + '\'' +
                '}';
    }
}
