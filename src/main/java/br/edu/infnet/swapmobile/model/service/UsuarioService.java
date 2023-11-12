package br.edu.infnet.swapmobile.model.service;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void incluir(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void excluir(Integer id) {

        usuarioRepository.deleteById(id);
    }

    public List<Usuario> obterLista() {

        return (List<Usuario>) usuarioRepository.findAll();
    }

    public Usuario validar(String email, String senha) {

        Usuario usuario = usuarioRepository.findByEmail(email);

        if (usuario != null && senha.equals(usuario.getSenha())) {
            return usuario;
        }

        return null;
    }

    public Usuario obterPorId(Integer id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElse(null);
    }

    public void atualizar(Usuario usuario) {
            usuarioRepository.save(usuario);
        }
    }
