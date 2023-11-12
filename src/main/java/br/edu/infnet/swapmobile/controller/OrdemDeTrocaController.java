package br.edu.infnet.swapmobile.controller;

import br.edu.infnet.swapmobile.model.domain.OrdemDeTroca;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.ClienteService;
import br.edu.infnet.swapmobile.model.service.OrdemDeTrocaService;
import br.edu.infnet.swapmobile.model.service.TrocaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class OrdemDeTrocaController {

    @Autowired
    private OrdemDeTrocaService ordemDeTrocaService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TrocaService trocaService;


    @GetMapping(value = "/ordemdetroca/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaOrdemDeTroca", ordemDeTrocaService.obterLista(usuario));

        return "ordemdetroca/lista";
    }

    @GetMapping(value = "/ordemdetroca")
    public String telaCadastro(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("clientes", clienteService.obterLista(usuario));

        model.addAttribute("trocas", trocaService.obterLista(usuario));

        return "ordemdetroca/cadastro";
    }

    @PostMapping(value = "/ordemdetroca/incluir")
    public String incluir(OrdemDeTroca ordemDeTroca, @SessionAttribute("user") Usuario usuario) {

        ordemDeTroca.setUsuario(usuario);
        ordemDeTrocaService.incluir(ordemDeTroca);

        return "redirect:/ordemdetroca/lista";
    }

    @GetMapping(value = "/ordemdetroca/{id}/excluir")
    public String excluir(@PathVariable Integer id) {

        ordemDeTrocaService.excluir(id);

        return "redirect:/ordemdetroca/lista";
    }



}
