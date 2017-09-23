package com.cairo.web.repository;

import com.cairo.web.entity.Categoria;
import com.cairo.web.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.categoria = :categoria")
    public List<Produto> buscarProdutosPorCategoria(@Param("categoria") Categoria categoria);

}
