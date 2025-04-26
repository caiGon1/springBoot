package br.anhembi.spring02.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.anhembi.spring02.model.Produto;
import br.anhembi.spring02.repository.produtoRepo;

@Service //ele é um serviço, gera um objeto e deixa ele salvo na memória
public class produtoService {
    
    @Autowired //injeção de dependencia - dentro da variavel, a ref do objeto é o repository
    private produtoRepo repo;

    public Optional<Produto> getProduto(long cod){
        return repo.findById(cod); //chama método para procurar o produto a partir do   ID
    }

    
    public Produto create(Produto produto){
        return repo.save(produto); //método save (salvar) - SEM ID


    }
    public Produto update(Produto produto){
        return repo.save(produto); //método save (salvar) - SEM ID


    }
    public boolean delete(long cod){
       Optional<Produto> optional = repo.findById(cod);
       if(optional.isPresent()){
        repo.deleteById(cod);
        return true;
       }
  return false;

    }

    public List<Produto> getAll(){
        return (List<Produto>)repo.findAll();
    }

    public List<Produto> findByName(String name){
        return repo.findByNameContains(name);
    }
    

}
