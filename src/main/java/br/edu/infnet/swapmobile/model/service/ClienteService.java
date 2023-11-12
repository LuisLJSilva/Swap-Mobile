package br.edu.infnet.swapmobile.model.service;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Cliente;
import br.edu.infnet.swapmobile.model.domain.Usuario;
import br.edu.infnet.swapmobile.model.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Collection<Cliente> obterLista(){

        return (Collection<Cliente>) clienteRepository.findAll();

    }

    public Collection<Cliente> obterLista(Usuario usuario){

        return (Collection<Cliente>) clienteRepository.obterLista(usuario.getId());

    }

    public void incluir(Cliente cliente) {

        clienteRepository.save(cliente);
    }

    public void excluir(Integer id) {

        clienteRepository.deleteById(id);
    }

    public Cliente obterPorId(Integer id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.orElse(null);
    }

    public void atualizar(Cliente cliente) {
        clienteRepository.save(cliente);
    }

}
