package br.edu.infnet.appmontadora.model.repository;

import br.edu.infnet.appmontadora.model.domain.Cargo;
import br.edu.infnet.appmontadora.model.domain.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}