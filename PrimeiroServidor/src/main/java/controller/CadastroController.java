package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class CadastroController {
    List<CadastroDTO> login = new ArrayList<>();

    @PostMapping("CadastroResourcePost")
    public String doPost(CadastroDTO dto, Model model){
        cadastros.add(dto);
        model.addAttribute(attributeName:"cadastros",cadastros);
        return "listagem";
    }
}
