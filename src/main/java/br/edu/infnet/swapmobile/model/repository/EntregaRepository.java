package br.edu.infnet.swapmobile.model.repository;

import br.edu.infnet.swapmobile.model.domain.Entrega;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntregaRepository extends CrudRepository<Entrega, Integer> {

    @Query("from Entrega e where e.usuario.id =:userid")
    public List<Entrega> obterLista(Integer userid);

}