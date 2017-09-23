package com.cairo.web.service;

import com.cairo.web.entity.Categoria;
import com.cairo.web.exceptions.UnprocessableEntityException;
import com.cairo.web.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Classe de 'CategoriaService'.
 */
@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * Recupera a lista de categorias cadastradas no sistema.
     *
     * @return List<Categoria>
     */
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }

    /**
     * Salva um novo registro ou atualiza um registro ja existente no banco de dados.
     *
     * @param categoria
     */
    public void salvar(Categoria categoria) {
        this.validarCamposObrigatorios(categoria);
        categoriaRepository.save(categoria);
    }

    /**
     * Remove uma categoria de acordo com o id informado.
     *
     * @param id
     */
    public void deletar(long id) {
        Categoria categoria = categoriaRepository.findOne(id);

        if (categoria != null) {
            categoriaRepository.delete(id);
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
    public Categoria buscarPorId(long id) {
        return categoriaRepository.findOne(id);
    }

    private void validarCamposObrigatorios(Categoria categoria) {
        boolean existeErros = false;

        if (categoria.getNome() == null) {
            existeErros = true;
        }

        if (existeErros) {
            throw new UnprocessableEntityException();
        }
    }

}
