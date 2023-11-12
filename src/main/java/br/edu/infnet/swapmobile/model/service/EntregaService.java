package br.edu.infnet.swapmobile.model.service;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Entrega;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository entregaRepository;

    public Collection<Entrega> obterLista(){

        return (Collection<Entrega>) entregaRepository.findAll();

    }

    public Collection<Entrega> obterLista(Usuario usuario) {

        return (Collection<Entrega>) entregaRepository.obterLista(usuario.getId());

    }

    public void incluir(Entrega entrega) {

        entregaRepository.save(entrega);

    }

    public void excluir(Integer id) {

        entregaRepository.deleteById(id);
    }

    public Entrega obterPorId(Integer id) {
        Optional<Entrega> entrega = entregaRepository.findById(id);
        return entrega.orElse(null);
    }

    public void atualizar(Entrega entrega) {
        entregaRepository.save(entrega);
    }
}
