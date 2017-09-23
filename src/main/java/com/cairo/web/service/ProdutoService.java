package com.cairo.web.service;

import com.cairo.web.entity.Categoria;
import com.cairo.web.entity.Produto;
import com.cairo.web.exceptions.UnprocessableEntityException;
import com.cairo.web.repository.CategoriaRepository;
import com.cairo.web.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * Recupera a lista de produtos cadastradas no sistema.
     *
     * @return List<Categoria>
     */
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    /**
     * Salva um novo registro ou atualiza um registro ja existente no banco de dados.
     *
     * @param produto
     */
    public void salvar(Produto produto) {
        this.validaCamposObrigatorios(produto);

        if(produto.getId() != 0) {
            Produto p = produtoRepository.findOne(produto.getId());

            if(p != null) {
                produtoRepository.save(produto);
            } else {
                // Lançar exception
            }
        } else {
            produtoRepository.save(produto);
        }
    }

    /**
     * Remove um produto de acordo com o id informado.
     *
     * @param id
     */
    public void deletar(long id) {
        Produto categoria = produtoRepository.findOne(id);

        if (categoria != null) {
            produtoRepository.delete(id);
        } else {
            // lançar exception
        }
    }

    /**
     * Recupera os dados de uma categoria de acordo com o id informado.
     *
     * @param id
     * @return Categoria
     */
    public Produto buscarPorId(long id) {
        return produtoRepository.findOne(id);
    }

    /**
     * Recupera a lista de produtos de acordo com a categoria informada.
     *
     * @param id
     * @return List<Produto>
     */
    public List<Produto> buscarProdutosPorCategoria(long id) {
        Categoria categoria = this.categoriaRepository.findOne(id);
        return this.produtoRepository.buscarProdutosPorCategoria(categoria);
    }

    /**
     * Valida se os campos obrigatorios foram informados corretamente.
     *
     * @param produto
     * @return
     */
    private void validaCamposObrigatorios(Produto produto) {
        boolean existeErros = false;

        if (produto.getNome() == null) {
            existeErros = true;
        }

        if (produto.getDescricao() == null) {
            existeErros = true;
        }

        if (Double.isNaN(produto.getPreco())) {
            existeErros = true;
        }

        if (existeErros) {
            throw new UnprocessableEntityException();
        }
    }
}
