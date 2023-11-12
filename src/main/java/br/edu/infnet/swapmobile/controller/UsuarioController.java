package br.edu.infnet.swapmobile.controller;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Cliente;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.service.ClienteService;
import br.edu.infnet.swapmobile.model.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@SessionAttributes("user")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/valida")
    public String validar(Model model, @RequestParam String email, @RequestParam String senha) {

        Usuario user = usuarioService.validar(email, senha);

        if (user != null) {

            model.addAttribute("user", user);

            return "home";
        }
        return "redirect:/login";
    }

    @GetMapping(value = "/usuario/lista")
    public String telaLista(Model model) {

        model.addAttribute("listaUsuario", usuarioService.obterLista());

        return "usuario/lista";
    }

    @GetMapping(value = "/usuario/{id}/editar")
    public String telaEdicao(@PathVariable Integer id, Model model) {
        Usuario usuario = usuarioService.obterPorId(id);
        model.addAttribute("usuario", usuario);
        return "usuario/edicao";
    }

    @PostMapping(value = "/usuario/{id}/editar")
    public String editar(@PathVariable Integer id, Usuario usuario) {
        usuarioService.atualizar(usuario);
        return "redirect:/usuario/lista";
    }



    @GetMapping(value = "/usuario/cadastro")
    public String telaCadastro() {

        return "usuario/cadastro";
    }

    @PostMapping(value = "/usuario/incluir")
    public String incluir(Usuario usuario) {

        usuarioService.incluir(usuario);

        return "redirect:/";
    }

    @GetMapping(value = "/usuario/{id}/excluir")
    public String exclusao(@PathVariable Integer id) {

        usuarioService.excluir(id);

        return "redirect:/usuario/lista";
    }


}
