package br.edu.infnet.swapmobile.controller;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService avaliacaoService;


    @GetMapping(value = "/avaliacao/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaAvaliacao", avaliacaoService.obterLista(usuario));

        return "avaliacao/lista";
    }

    @GetMapping(value = "/avaliacao/{id}/editar")
    public String telaEdicao(@PathVariable Integer id, Model model) {
        Avaliacao avaliacao = avaliacaoService.obterPorId(id);
        model.addAttribute("avaliacao", avaliacao);
        return "avaliacao/edicao";
    }

    @PostMapping(value = "/avaliacao/{id}/editar")
    public String editar(@PathVariable Integer id, Avaliacao avaliacaoForm, @SessionAttribute("user") Usuario usuario) {
        Avaliacao avaliacao = avaliacaoService.obterPorId(id);
        if (avaliacao != null && avaliacao.getUsuario().equals(usuario)) {
            avaliacao.setCondicaoAparelho(avaliacaoForm.getCondicaoAparelho());
            avaliacao.setValorAvaliado(avaliacaoForm.getValorAvaliado());
            avaliacao.setObservacoes(avaliacaoForm.getObservacoes());
            avaliacaoService.atualizar(avaliacao);
        }
        return "redirect:/avaliacao/lista";
    }

    @GetMapping(value = "/avaliacao/cadastro")
    public String telaCadastro () {

        return "avaliacao/cadastro";
    }

    @PostMapping(value = "/avaliacao/incluir")
    public String incluir(Avaliacao avaliacao, @SessionAttribute("user") Usuario usuario) {

        avaliacao.setUsuario(usuario);

        avaliacaoService.incluir(avaliacao);

        return "redirect:/avaliacao/lista";
    }

    @GetMapping(value = "/avaliacao/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {

        avaliacaoService.excluir(id);

        return "redirect:/avaliacao/lista";
    }

}
