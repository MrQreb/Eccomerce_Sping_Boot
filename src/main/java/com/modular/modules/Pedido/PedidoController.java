package com.modular.modules.Pedido;

import com.modular.modules.Pedido.Entity.PedidoEntity;
import com.modular.modules.TipoPago.Entity.TipoPagoEntity;
import com.modular.modules.TipoPago.TipoPagoService;
import com.modular.modules.Usuario.Entity.UsuarioEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoService pedidoService;
    private final TipoPagoService tipoPagoService;

    public PedidoController(PedidoService pedidoService, TipoPagoService tipoPagoService) {
        this.pedidoService = pedidoService;
        this.tipoPagoService = tipoPagoService;
    }

    @GetMapping("/crear")
    public String createForm(Model model, HttpSession session) {
        UsuarioEntity usuario = (UsuarioEntity) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        Long usuarioId = usuario.getId();
        List<TipoPagoEntity> tiposPago = tipoPagoService.findAllTipoPago();
        model.addAttribute("tiposPago", tiposPago);
        model.addAttribute("usuarioId", usuarioId);
        model.addAttribute("pedido", new PedidoEntity());
        return "crear-pedido-form";
    }

    @PostMapping("/crear")
    public String create(@ModelAttribute PedidoEntity pedido, HttpSession session, Model model) {
        UsuarioEntity usuario = (UsuarioEntity) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        Long usuarioId = usuario.getId();
        pedidoService.crearPedidoPorUsuarioId(usuarioId, pedido.getTipoPago());
        return "redirect:/usuario/home";
    }

    @GetMapping("/exito")
    public String success() {
        return "usuario/home";
    }


    @GetMapping("/listar")
    public String listPedidos(Model model, HttpSession session) {
        UsuarioEntity usuario = (UsuarioEntity) session.getAttribute("usuario");
        if (usuario == null) {
            return "redirect:/usuario/login";
        }

        Long usuarioId = usuario.getId();

        List<PedidoEntity> pedidos = pedidoService.findByUsuarioId(usuarioId);
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("usuario", usuario);
        return "pedido/listar-pedidos";
    }

}