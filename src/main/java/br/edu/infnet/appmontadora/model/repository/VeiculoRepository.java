package br.edu.infnet.appmontadora.model.repository;

import java.util.List;

import br.edu.infnet.appmontadora.model.domain.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, Integer> {
}