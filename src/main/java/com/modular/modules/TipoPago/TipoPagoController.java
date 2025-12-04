package com.modular.modules.TipoPago;

import com.modular.modules.TipoPago.Entity.TipoPagoEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tipo-pago")
public class TipoPagoController {

    private TipoPagoService tipoPagoService;

    public TipoPagoController(TipoPagoService tipoPagoService) {
        this.tipoPagoService = tipoPagoService;
    }

    @GetMapping
    public String findAll(Model model) {
        List<TipoPagoEntity> tipoPagos = tipoPagoService.findAllTipoPago();
        model.addAttribute("tipoPagos", tipoPagos);
        return "tipo-pago/list";
    }

    @PostMapping("/crear")
    public String create(@ModelAttribute TipoPagoEntity tipoPago) {
        tipoPagoService.createTipoPago(tipoPago);
        return "redirect:/tipo-pago/crear";
    }


    @GetMapping("/crear")
    public String createForm(Model model) {
        model.addAttribute("tipoPago", new TipoPagoEntity());
        return "tipo-pago/crear-tipo-pago-form";
    }
}
