package br.anhembi.spring02.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.anhembi.spring02.model.Produto;
import br.anhembi.spring02.repository.produtoRepo;
import br.anhembi.spring02.service.produtoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/produto")
public class ProdutoController { //requisição externa

    @Autowired //ligação ao service
    private produtoService service;


    @GetMapping("/{cod}") //tipo get 
    public ResponseEntity<Produto> getProduto(@PathVariable long cod){ //variavel especificada no path
        Optional<Produto> getProduto = service.getProduto(cod);
        if(getProduto.isPresent()){
            return ResponseEntity.ok(getProduto.get());
        }
        return ResponseEntity.notFound().build();
    }  

    @GetMapping//pode varios gets desde tenham parametros diferentes 
    public ResponseEntity<List<Produto>> getAllProduto(){ //variavel especificada no path
        List<Produto> produto = service.getAll();
        if(produto.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produto);
    }    

    @GetMapping("/name/{name}") //tipo get 
    public ResponseEntity<List<Produto>> getProdutoByName(@PathVariable String name){ //variavel especificada no path
        List<Produto> produto = service.findByName(name);

        return ResponseEntity.ok(produto);
    }  
  

    

    //response entity: modelo de resposta http
    //@request body indica que o parametro vira no corpop da requisição (json?)
    @PostMapping
    public ResponseEntity<Produto> create(@RequestBody Produto newProduto){
        if(newProduto.getCod() != null){
            return ResponseEntity.badRequest().build();
        }
     Produto produtoInserido = service.create(newProduto);
     return  ResponseEntity.ok(produtoInserido);

    }






    
    @PutMapping //atualização do bd
    public ResponseEntity<Produto> update(@RequestBody Produto newProduto){
        if(newProduto.getCod() == null){
            return ResponseEntity.badRequest().build();
        }
        Optional<Produto> optionalProduto = service.getProduto(newProduto.getCod());
        if(optionalProduto.isEmpty()){
            return ResponseEntity.notFound().build();
        }

     Produto produtoInserido = service.update(newProduto);
     return  ResponseEntity.ok(produtoInserido);

    }
    @DeleteMapping("/{cod}") //tipo get 
    public ResponseEntity<Produto> deleteProduto(@PathVariable long cod){ //variavel especificada no path
        boolean apagado = service.delete(cod);
        if(apagado){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }    




}
