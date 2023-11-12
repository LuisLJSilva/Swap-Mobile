package br.edu.infnet.swapmobile.model.service;

import br.edu.infnet.swapmobile.model.domain.Troca;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.repository.TrocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TrocaService {

    @Autowired
    private TrocaRepository trocaRepository;

    public Collection<Troca> obterLista(){

        return (Collection<Troca>) trocaRepository.findAll();

    }

    public Collection<Troca> obterLista(Usuario usuario) {

        return (Collection<Troca>) trocaRepository.obterLista(usuario.getId());

    }

    public void incluir(Troca servico) {

        trocaRepository.save(servico);

    }

    public void excluir(Integer id) {

        trocaRepository.deleteById(id);
    }


}
