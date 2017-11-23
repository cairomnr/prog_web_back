package com.cairo.web.domain.dashboard;

import com.cairo.web.core.controller.RestAbstractController;
import com.cairo.web.domain.dto.DashboardDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("dashboard")
@CrossOrigin(origins = "*")
public class DashboardController extends RestAbstractController {

    @Autowired
    private DashboardService dashboardService;

    /**
     * Recupera a lista os dados para popular o dashboard do sistema.
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<?> listar() {
        DashboardDTO dashboardDTO = this.dashboardService.getDadosDashboard();
        return jsonResponse(dashboardDTO);
    }
}

