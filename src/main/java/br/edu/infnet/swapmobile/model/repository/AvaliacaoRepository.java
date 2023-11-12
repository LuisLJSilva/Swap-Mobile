package br.edu.infnet.swapmobile.model.repository;

import br.edu.infnet.swapmobile.model.domain.Avaliacao;
import br.edu.infnet.swapmobile.model.domain.Entrega;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvaliacaoRepository extends CrudRepository<Avaliacao, Integer> {

    @Query("from Avaliacao a where a.usuario.id =:userid")
    public List<Avaliacao> obterLista(Integer userid);

}