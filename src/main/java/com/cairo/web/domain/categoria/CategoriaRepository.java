package com.cairo.web.domain.categoria;

import com.cairo.web.domain.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    public Categoria findByNome(String nome);

}
