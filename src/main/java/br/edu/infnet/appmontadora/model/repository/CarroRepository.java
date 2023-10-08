package br.edu.infnet.appmontadora.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appmontadora.model.domain.Carro;

@Repository
public interface CarroRepository extends CrudRepository<Carro, Integer> {
}