package br.edu.infnet.swapmobile.model.repository;

import br.edu.infnet.swapmobile.model.domain.Entrega;
import br.edu.infnet.swapmobile.model.domain.NovoTelefone;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NovoTelefoneRepository extends CrudRepository<NovoTelefone, Integer> {

    @Query("from NovoTelefone nt where nt.usuario.id =:userid")
    public List<NovoTelefone> obterLista(Integer userid);

}