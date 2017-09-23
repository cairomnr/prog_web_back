package com.cairo.web.repository;

import com.cairo.web.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    public Categoria findByNome(String nome);

}
