package br.edu.iftm.tspi.formulario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.iftm.tspi.formulario.dto.CadastroDTO;

@Controller
public class Cadastro {

    @PostMapping("/loginResource")
    public String trataPost(CadastroDTO CadastroDTO,
                            Model model) {
        System.out.println("que felicidade, estou no servidor, "+
        "e você digitou o email "+CadastroDTO.inputEmail());
        System.out.println("nome "+CadastroDTO.inputName());
        
        model.addAttribute(CadastroDTO);

        return "output";
    }
    
}
