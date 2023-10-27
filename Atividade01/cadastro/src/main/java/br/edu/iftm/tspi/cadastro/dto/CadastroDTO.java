package br.edu.iftm.tspi.cadastro.dto;

import lombok.Data;

@Data
public class CadastroDTO {

        public int id;
        private String inputNome;
        private String inputEmail;
        private String inputTelefone;

    public CadastroDTO(int id, String inputNome, String inputEmail, String inputTelefone){
        this.id = id;
        this.inputNome = inputNome;
        this.inputEmail = inputEmail;
        this.inputTelefone = inputTelefone;
    }

    public CadastroDTO(){
    }
}
