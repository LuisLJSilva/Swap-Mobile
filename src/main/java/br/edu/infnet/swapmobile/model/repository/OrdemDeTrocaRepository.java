package br.edu.infnet.swapmobile.model.repository;

import br.edu.infnet.swapmobile.model.domain.OrdemDeTroca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdemDeTrocaRepository extends CrudRepository<OrdemDeTroca, Integer> {

    @Query("from OrdemDeTroca ot where ot.usuario.id =:userid")
    public List<OrdemDeTroca> obterLista(Integer userid);

}
