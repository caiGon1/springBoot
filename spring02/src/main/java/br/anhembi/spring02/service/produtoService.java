package br.anhembi.spring02.service;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.spring02.model.produto;
import br.anhembi.spring02.repository.produtoRepo;

@Service
public class produtoService {
    
    @Autowired
    private produtoRepo repo;

    public java.util.Optional<produto> getProduto(long cod){
        return repo.findById(cod);

    }

    

}
