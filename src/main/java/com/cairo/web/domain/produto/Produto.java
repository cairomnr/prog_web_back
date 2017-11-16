package com.cairo.web.domain.produto;

import com.cairo.web.domain.categoria.Categoria;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 5485765242599656645L;

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_produto_id_seq")
    @SequenceGenerator(name = "tb_produto_id_seq", sequenceName = "tb_produto_id_seq", allocationSize = 1)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private double preco;
    
    @Column(name = "is_destaque", columnDefinition = "boolean default true")
    private boolean isDestaque;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
