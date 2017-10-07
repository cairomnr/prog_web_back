package com.cairo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairo.web.entity.Produto;
import com.cairo.web.service.ProdutoService;

@CrossOrigin
@RestController
@RequestMapping("produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping()
    public ResponseEntity<List<Produto>> listar() {
        return new ResponseEntity<List<Produto>>(this.produtoService.listar(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable("id") long id) {
        return new ResponseEntity<Produto>(this.produtoService.buscarPorId(id), HttpStatus.OK);
    }

    @GetMapping(value = "categoria/{categoria_id}")
    public ResponseEntity<List<Produto>> getProdutosPorCategoria(@PathVariable("categoria_id") long categoria_id) {
        return new ResponseEntity<List<Produto>>(this.produtoService.buscarProdutosPorCategoria(categoria_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Produto produto) {
        produtoService.salvar(produto);
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> altualizar(@RequestBody Produto produto, @PathVariable("id") long id) {
        produto.setId(id);
        produtoService.salvar(produto);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
        this.produtoService.deletar(id);
        return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
    }

}