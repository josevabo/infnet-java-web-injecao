package br.edu.infnet.appmontadora.model.repository;

import br.edu.infnet.appmontadora.model.domain.Fabrica;
import br.edu.infnet.appmontadora.model.domain.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {

	@Query("from Funcionario f where f.fabrica.id = :idFabrica ")
	public List<Funcionario> listByFabrica(int idFabrica);

	Funcionario findByEmail(String email);
}