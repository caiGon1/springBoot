package br.anhembi.spring02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import br.anhembi.spring02.model.produto;
import br.anhembi.spring02.service.produtoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private produtoService service;


    @GetMapping("/{cod}")
    public ResponseEntity<produto> getProduto(@PathVariable long cod){ //variavel especificada no path
        Optional<produto> getProduto = service.getProduto(cod);
        if(getProduto.isPresent()){
            return ResponseEntity.ok(getProduto.get());
        }
        return ResponseEntity.notFound().build();

        
    }

}
