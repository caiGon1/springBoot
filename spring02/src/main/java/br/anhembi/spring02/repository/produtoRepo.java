package br.anhembi.spring02.repository;

import org.springframework.data.repository.CrudRepository;

import br.anhembi.spring02.model.produto;

//create, read, update, delete...

public interface produtoRepo extends CrudRepository<produto, Long> {
    
}
