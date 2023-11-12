package br.edu.infnet.swapmobile.model.service;

import br.edu.infnet.swapmobile.model.domain.OrdemDeTroca;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.repository.OrdemDeTrocaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class OrdemDeTrocaService {

    @Autowired
    OrdemDeTrocaRepository ordemDeTrocaRepository;

    public Collection<OrdemDeTroca> obterLista(){


        return (Collection<OrdemDeTroca>) ordemDeTrocaRepository.findAll();

    }

    public Collection<OrdemDeTroca> obterLista(Usuario usuario) {

        return (Collection<OrdemDeTroca>) ordemDeTrocaRepository.obterLista(usuario.getId());

    }

    public void incluir(OrdemDeTroca ordemDeTroca) {

        ordemDeTrocaRepository.save(ordemDeTroca);
    }

    public void excluir(Integer id) {

        ordemDeTrocaRepository.deleteById(id);
    }

}
