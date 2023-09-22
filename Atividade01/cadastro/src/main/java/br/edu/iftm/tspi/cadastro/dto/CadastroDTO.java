package br.edu.iftm.tspi.cadastro.dto;

import lombok.Data;

@Data
public class CadastroDTO {

    public CadastroDTO(Long id, String inputNome, String inputEmail, String inputTelefone){
        this.id = id;
        this.inputNome = inputNome;
        this.inputEmail = inputEmail;
        this.inputTelefone = inputTelefone;
    }

    public CadastroDTO(){
    }

    public Long id;
    private String inputNome;
    private String inputEmail;
    private String inputTelefone;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setNome(String inputNome){
        this.inputNome = inputNome;
    }
    public String getNome(){
        return inputNome;
    }

    public void setEmail(String inputEmail){
        this.inputEmail = inputEmail;
    }
    public String getEmail(){
        return inputEmail;
    }

    public void setTelefone(String inputTelefone){
        this.inputTelefone = inputTelefone;
    }
    public String getTelefone(){
        return inputTelefone;
    }
}
