package br.edu.iftm.tspi.cadastro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iftm.tspi.cadastro.dto.CadastroDTO;
import dao.CadastroDao;

@Controller
public class CadastroController {

    @Autowired
    private CadastroDao dao;

    @RequestMapping("cadastros")
    public String getCadastros(Model model) {
        model.addAttribute("cadastro",new CadastroDTO());
        model.addAttribute("cadastros",dao.getCadastro());
        model.addAttribute("edit",false);
        return "listagem";
    }
    @PostMapping("cadastros")
public String postCadastro(CadastroDTO cadastro, Model model) {
    CadastroDTO cadastroDb = dao.getCadastro(cadastro.getId());
    if(cadastroDb == null){
        dao.addCadastro(cadastro);
    }else{
        dao.updateCadastro(cadastro);
    }
    return "redirect:/cadastros";
}

    @RequestMapping("cadastrosParametro")
        public String getCadastro(@RequestParam(value = "inputNome", required = true) String inputNome, Model model) {
            model.addAttribute("cadastro",new CadastroDTO());
            model.addAttribute("cadastros",dao.getCadastro(inputNome));
            model.addAttribute("edit",false);
            return "listagem";
        }

    @RequestMapping("deleteCadastro")
    public String deleteCadastro(@RequestParam(value = "id") int id, Model model) {
        dao.deleteCadastro(id);
        return "redirect:/cadastros";
    }

    @RequestMapping("editCadastro")
    public String editarCadastro(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("cadastro",dao.getCadastro(id));
        model.addAttribute("cadastros",dao.getCadastro());
        model.addAttribute("edit",true);
        return "listagem";
    }
    

    List<CadastroDTO> cadastros = new ArrayList<>();

    @PostMapping("cadastroResourcePost")
    public String doPost(CadastroDTO dto, Model model) {

        dto.setId((int) (cadastros.size() + 1));
        cadastros.add(dto);
        return doGet(model);

    }

    @RequestMapping("cadastroResourceGet")
    public String doGet(Model model) {
        model.addAttribute("cadastros", cadastros);
        return "listagem";
    }
}