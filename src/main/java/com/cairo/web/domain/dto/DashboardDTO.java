package com.cairo.web.domain.dto;

/**
 * Classe responsavel por mapear a tranferencia de dados para o DASHBOARD.
 */
public class DashboardDTO {

    private int nuProdutos;

    private int nuCategorias;


    public int getNuProdutos() {
        return nuProdutos;
    }

    public void setNuProdutos(int nuProdutos) {
        this.nuProdutos = nuProdutos;
    }

    public int getNuCategorias() {
        return nuCategorias;
    }

    public void setNuCategorias(int nuCategorias) {
        this.nuCategorias = nuCategorias;
    }
}
