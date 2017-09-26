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

import com.cairo.web.entity.Categoria;
import com.cairo.web.entity.Produto;
import com.cairo.web.service.CategoriaService;

@CrossOrigin
@RestController
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return new ResponseEntity<List<Categoria>>(this.categoriaService.listar(), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable("id") long id) {
        return new ResponseEntity<Categoria>(this.categoriaService.buscarPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Categoria categoria) {
        categoriaService.salvar(categoria);
        return new ResponseEntity<Object>(null, HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<?> altualizar(@RequestBody Categoria categoria, @PathVariable("id") long id) {
        categoria.setId(id);
        categoriaService.salvar(categoria);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
        this.categoriaService.deletar(id);
        return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
    }
    
    @GetMapping(value = "{id}/produto")
    public ResponseEntity<?> getProdutosPorCategoria(@PathVariable("id") long id) {
    	List<Produto> produtos = this.categoriaService.buscarProdutosPorCategoria(id);
    	return new ResponseEntity<Object>(produtos, HttpStatus.OK);
    }

}
