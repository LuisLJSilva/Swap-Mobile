package br.edu.infnet.swapmobile.controller;

import br.edu.infnet.swapmobile.model.domain.Troca;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.TrocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class TrocaController {

    @Autowired
    private  TrocaService trocaService;


    @GetMapping(value = "/troca/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaTroca", trocaService.obterLista(usuario));

        return "troca/lista";
    }

    @GetMapping(value = "/troca/cadastro")
    public String telaCadastro () {

        return "troca/cadastro";
    }

    @PostMapping(value = "/troca/incluir")
    public String incluir(Troca troca) {

        trocaService.incluir(troca);

        return "redirect:/troca/lista";
    }

    public void excluir(Integer id) {
        trocaService.excluir(id);
    }

    @GetMapping(value = "/troca/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {

        trocaService.excluir(id);

        return "redirect:/troca/lista";
    }




}
