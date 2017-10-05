package com.cairo.web.controller;

import com.cairo.web.entity.Categoria;
import com.cairo.web.entity.Produto;
import com.cairo.web.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<?> atualizar(@RequestBody Categoria categoria, @PathVariable("id") long id) {
        categoria.setId(id);
        categoriaService.salvar(categoria);
        return new ResponseEntity<Object>(null, HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") long id) {
        this.categoriaService.deletar(id);
        return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(value = "{id}/produto")
    public ResponseEntity<?> deletarProdutosVinculados(@PathVariable("id") long id) {
        this.categoriaService.deletarProdutosVinculados(id);
        return new ResponseEntity<Object>(null, HttpStatus.NO_CONTENT);
    }

}
