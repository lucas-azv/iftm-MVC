package br.edu.iftm.tspi.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iftm.tspi.cadastro.dto.CadastroDTO;

@Controller
public class CadastroController {

    List<CadastroDTO> cadastros = new ArrayList<>();

    @PostMapping("cadastroResourcePost")
    public String doPost(CadastroDTO dto, Model model) {

        dto.setId((long) (cadastros.size() + 1));
        cadastros.add(dto);
        return doGet(model);

    }

    @RequestMapping("cadastroResourceGet")
    public String doGet(Model model) {
        model.addAttribute("cadastros", cadastros);
        return "listagem";
    }

    @GetMapping("/edit/{id}")
public String edit(@PathVariable("id") Long id, Model model) {
    CadastroDTO cadastroParaEditar = encontrarCadastroPorId(id);

    if (cadastroParaEditar != null) {
        model.addAttribute("cadastro", cadastroParaEditar);

        return "editar";
    } else {
        return "redirect:/cadastroResourceGet";
    }
}

@PostMapping("/editarCadastro")
public String atualizarCadastro(CadastroDTO dto, Model model) {
    CadastroDTO cadastroOriginal = encontrarCadastroPorId(dto.getId());

    if (cadastroOriginal != null) {
        cadastroOriginal.setInputNome(dto.getInputNome());
        cadastroOriginal.setInputEmail(dto.getInputEmail());
        cadastroOriginal.setInputTelefone(dto.getInputTelefone());

        return "redirect:/cadastroResourceGet";
    } else {
        return "redirect:/cadastroResourceGet";
    }
}


    @GetMapping("/excluirCadastro/{id}")
    public String excluirCadastro(@PathVariable("id") Long id) {
        CadastroDTO cadastro = encontrarCadastroPorId(id);

        if (cadastro != null) {
            cadastros.remove(cadastro);
        }

        return "redirect:/cadastroResourceGet";
    }

    private CadastroDTO encontrarCadastroPorId(Long id) {
        for (CadastroDTO cadastro : cadastros) {
            if (cadastro.getId().equals(id)) {
                return cadastro;
            }
        }
        return null;
    }
}

