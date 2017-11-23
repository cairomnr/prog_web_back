package com.cairo.web.domain.dashboard;

import com.cairo.web.domain.categoria.CategoriaService;
import com.cairo.web.domain.dto.DashboardDTO;
import com.cairo.web.domain.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private ProdutoService produtoService;

    /**
     * Recupera os dados do dashboard do sistema.
     *
     * @return
     */
    public DashboardDTO getDadosDashboard() {
        DashboardDTO dashboardDTO = new DashboardDTO();
        dashboardDTO.setNuProdutos(this.produtoService.listar().size());
        dashboardDTO.setNuCategorias(this.categoriaService.listar().size());
        return dashboardDTO;
    }
}
