package com.cairo.web.domain.produto;

import com.cairo.web.domain.categoria.Categoria;
import com.cairo.web.domain.produto.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p FROM Produto p WHERE p.categoria = :categoria")
    public List<Produto> buscarProdutosPorCategoria(@Param("categoria") Categoria categoria);

    /**
     * Recupera o produto a partir do nome informado.
     *
     * @param nome
     * @return
     */
    public Produto findByNome(String nome);
    
    /**
     * Recupera o produto a partir do nome informado.
     *
     * @param isDestaque
     * @return
     */
    public List<Produto> findByIsDestaque(boolean isDestaque);

}
