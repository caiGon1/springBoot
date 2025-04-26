package br.anhembi.spring02.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring02.model.Produto;
import java.util.List;


//create, read, update, delete...

public interface produtoRepo extends CrudRepository<Produto, Long> { //declarou que é extends de crudrepository(repositotrio crud)
    List<Produto> findByNameContains(String name); //JPA QUERY METHODS
}
