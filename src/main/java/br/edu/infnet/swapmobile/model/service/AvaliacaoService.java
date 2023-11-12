package br.edu.infnet.swapmobile.model.service;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.NovoTelefone;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.repository.AvaliacaoRepository;
import br.edu.infnet.swapmobile.model.repository.NovoTelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    public Collection<Avaliacao> obterLista() {

        return (Collection<Avaliacao>) avaliacaoRepository.findAll();

    }

    public Collection<Avaliacao> obterLista(Usuario usuario) {

        return (Collection<Avaliacao>) avaliacaoRepository.obterLista(usuario.getId());

    }

    public void incluir(Avaliacao avaliacao) {

        avaliacaoRepository.save(avaliacao);
    }

    public void excluir(Integer id) {
        avaliacaoRepository.deleteById(id);
    }

    public Avaliacao obterPorId(Integer id) {
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);
        return avaliacao.orElse(null);
    }

    public void atualizar(Avaliacao avaliacao) {
        avaliacaoRepository.save(avaliacao);
    }
}
