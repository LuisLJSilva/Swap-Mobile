package br.edu.infnet.swapmobile.controller;

import br.edu.infnet.swapmobile.model.domain.Cliente;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping(value = "/cliente/lista")
    public String telaLista(Model model, @SessionAttribute("user") Usuario usuario) {

        model.addAttribute("listaCliente", clienteService.obterLista(usuario));

        return "cliente/lista";
    }

    @GetMapping(value = "/cliente/{id}/editar")
    public String telaEdicao(@PathVariable Integer id, Model model) {
        Cliente cliente = clienteService.obterPorId(id);
        if(cliente != null) {
            model.addAttribute("cliente", cliente);
            return "cliente/edicao";
        }
        return "redirect:/cliente/lista";
    }

    @PostMapping(value = "/cliente/{id}/editar")
    public String editar(@PathVariable Integer id, Cliente clienteForm, @SessionAttribute("user") Usuario usuarioLogado) {
        Cliente cliente = clienteService.obterPorId(id);
        if (cliente != null && cliente.getUsuario().equals(usuarioLogado)) {
            cliente.setNome(clienteForm.getNome());
            cliente.setCpf(clienteForm.getCpf());
            cliente.setEmail(clienteForm.getEmail());
            clienteService.atualizar(cliente);
            return "redirect:/cliente/lista";
        }
        return "redirect:/";
    }

    @GetMapping(value = "/cliente/cadastro")
    public String telaCadastro () {

        return "cliente/cadastro";
    }

    @PostMapping(value = "/cliente/incluir")
    public String incluir(Cliente cliente, @SessionAttribute("user") Usuario usuario) {

        cliente.setUsuario(usuario);

        clienteService.incluir(cliente);

        return "redirect:/cliente/lista";
    }

    @GetMapping(value = "/cliente/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {

        clienteService.excluir(id);

        return "redirect:/cliente/lista";
    }


}
