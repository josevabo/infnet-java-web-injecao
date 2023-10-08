package br.edu.infnet.appmontadora.model.repository;

import java.util.List;

import br.edu.infnet.appmontadora.model.domain.Lote;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends CrudRepository<Lote, Integer> {

	@Query("from Lote l where l.responsavel.id = :userid")
	public List<Lote> obterLista(Integer userid);
}