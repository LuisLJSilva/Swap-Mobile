package br.edu.infnet.swapmobile.controller;

import br.edu.infnet.swapmobile.model.domain.Entrega;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class EntregaController {

    @Autowired
    private EntregaService entregaService;


    @GetMapping(value = "/entrega/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaEntrega", entregaService.obterLista(usuario));

        return "entrega/lista";
    }

    @GetMapping(value = "/entrega/{id}/editar")
    public String telaEdicao(@PathVariable Integer id, Model model) {
        Entrega entrega = entregaService.obterPorId(id);
        model.addAttribute("entrega", entrega);
        return "entrega/edicao";
    }

    @PostMapping(value = "/entrega/{id}/editar")
    public String editar(@PathVariable Integer id, Entrega entregaForm, @SessionAttribute("user") Usuario usuario) {
        Entrega entrega = entregaService.obterPorId(id);
        if (entrega != null && entrega.getUsuario().equals(usuario)) {
            entrega.setSedex(entregaForm.getSedex());
            entrega.setEnderecoEntrega(entregaForm.getEnderecoEntrega());
            entrega.setStatusEntrega(entregaForm.getStatusEntrega());
            entregaService.atualizar(entrega);
        }
        return "redirect:/entrega/lista";
    }

    @GetMapping(value = "/entrega/cadastro")
    public String telaCadastro () {

        return "entrega/cadastro";
    }

    @PostMapping(value = "/entrega/incluir")
    public String incluir(Entrega entrega, @SessionAttribute("user") Usuario usuario) {

        entrega.setUsuario(usuario);

        entregaService.incluir(entrega);

        return "redirect:/entrega/lista";
    }

    @GetMapping(value = "/entrega/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {

        entregaService.excluir(id);

        return "redirect:/entrega/lista";
    }

}
