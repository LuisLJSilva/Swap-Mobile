package br.edu.infnet.swapmobile.model.repository;

import br.edu.infnet.swapmobile.model.domain.Troca;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrocaRepository extends CrudRepository<Troca, Integer> {

    @Query("from Troca t where t.usuario.id =:userid")
    public List<Troca> obterLista(Integer userid);
}
