package br.edu.infnet.appLocacao.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appLocacao.model.negocio.Picape;

@Repository
public interface IPicapeRepository extends CrudRepository<Picape, Integer> {
	List<Picape> findAll(Sort by);

}
