package br.edu.infnet.swapmobile.model.repository;

import br.edu.infnet.swapmobile.model.domain.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    @Query("from Cliente c where c.usuario.id = :userid")
    public List<Cliente> obterLista(Integer userid);

}