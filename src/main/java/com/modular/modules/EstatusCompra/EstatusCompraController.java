package com.modular.modules.EstatusCompra;

import com.modular.modules.EstatusCompra.Entity.EstatusCompraEntity;
import com.modular.modules.TipoPago.Entity.TipoPagoEntity;
import com.modular.modules.TipoPago.TipoPagoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/estatus-compra")
public class EstatusCompraController {

    private EstatusCompraService estatusCompraService;

    public EstatusCompraController(EstatusCompraService estatusCompraService) {
        this.estatusCompraService = estatusCompraService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<EstatusCompraEntity> tipoPagos = estatusCompraService.findAllEstatusCompra();
        model.addAttribute("tipoPagos", tipoPagos);
        return "tipo-pago/list";
    }

    @PostMapping("/crear")
    public String create(@ModelAttribute EstatusCompraEntity tipoPago) {
        estatusCompraService.createEstatusCompra(tipoPago);
        return "redirect:/estatus-compra/crear";
    }



    @GetMapping("/crear")
    public String createForm(Model model) {
        model.addAttribute("tipoPago", new EstatusCompraEntity());
        return "estatus-compra/crear-estatus-compra-form";
    }
}
