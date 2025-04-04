package br.anhembi.spring02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import br.anhembi.spring02.model.produto;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping
    public ResponseEntity<produto> getProduto(){
        return ResponseEntity.ok(new produto());
    }

}
