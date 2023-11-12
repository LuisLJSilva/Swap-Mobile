package br.edu.infnet.swapmobile.model.service;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.NovoTelefone;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.repository.NovoTelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class NovoTelefoneService {

    @Autowired
    private NovoTelefoneRepository novoTelefoneRepository;

    public Collection<NovoTelefone> obterLista() {

        return (Collection<NovoTelefone>) novoTelefoneRepository.findAll();

    }

    public Collection<NovoTelefone> obterLista(Usuario usuario) {

        return (Collection<NovoTelefone>) novoTelefoneRepository.obterLista(usuario.getId());

    }

    public void incluir(NovoTelefone novoTelefone) {

        novoTelefoneRepository.save(novoTelefone);
    }

    public void excluir(Integer id) {
        novoTelefoneRepository.deleteById(id);
    }

    public NovoTelefone obterPorId(Integer id) {
        Optional<NovoTelefone> novoTelefone = novoTelefoneRepository.findById(id);
        return novoTelefone.orElse(null);
    }

    public void atualizar(NovoTelefone novoTelefone) {
        novoTelefoneRepository.save(novoTelefone);
    }
}
