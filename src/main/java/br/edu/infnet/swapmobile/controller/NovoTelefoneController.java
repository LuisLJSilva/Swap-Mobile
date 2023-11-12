package br.edu.infnet.swapmobile.controller;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.NovoTelefone;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.NovoTelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class NovoTelefoneController {

    @Autowired
    private NovoTelefoneService novoTelefoneService;


    @GetMapping(value = "/novoTelefone/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaNovoTelefone", novoTelefoneService.obterLista(usuario));

        return "novoTelefone/lista";
    }

    @GetMapping(value = "/novoTelefone/{id}/editar")
    public String telaEdicao(@PathVariable Integer id, Model model) {
        NovoTelefone novoTelefone = novoTelefoneService.obterPorId(id);
        model.addAttribute("novoTelefone", novoTelefone);
        return "novoTelefone/edicao";
    }

    @PostMapping(value = "/novoTelefone/{id}/editar")
    public String editar(@PathVariable Integer id, NovoTelefone novoTelefoneForm, @SessionAttribute("user") Usuario usuario) {
        NovoTelefone novoTelefone = novoTelefoneService.obterPorId(id);
        if (novoTelefone != null && novoTelefone.getUsuario().equals(usuario)) {
            novoTelefone.setModelo(novoTelefoneForm.getModelo());
            novoTelefone.setPreco(novoTelefoneForm.getPreco());
            novoTelefone.setGarantia(novoTelefoneForm.getGarantia());
            novoTelefoneService.atualizar(novoTelefone);
        }
        return "redirect:/novoTelefone/lista";
    }

    @GetMapping(value = "/novoTelefone/cadastro")
    public String telaCadastro () {

        return "novoTelefone/cadastro";
    }

    @PostMapping(value = "/novoTelefone/incluir")
    public String incluir(NovoTelefone novoTelefone, @SessionAttribute("user") Usuario usuario) {

        novoTelefone.setUsuario(usuario);

        novoTelefoneService.incluir(novoTelefone);

        return "redirect:/novoTelefone/lista";
    }

    @GetMapping(value = "/novoTelefone/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {

        novoTelefoneService.excluir(id);

        return "redirect:/novoTelefone/lista";
    }
}
