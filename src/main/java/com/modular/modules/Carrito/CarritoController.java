package com.modular.modules.Carrito;

import com.modular.modules.Carrito.Entity.CarritoEntity;
import com.modular.modules.Carrito.Entity.CarritoProductoEntity;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("carrito")
public class CarritoController {

    private CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @PostMapping("/agregar")
    public String addToCart(@RequestParam Long productoId, @RequestParam int cantidad, HttpSession session, RedirectAttributes redirectAttributes) {
        Long usuarioId = (Long) session.getAttribute("idUsuario");

        if (usuarioId == null) {
            redirectAttributes.addFlashAttribute("mensaje", "Usuario no autenticado. Por favor, inicie sesión.");
            return "redirect:/producto/buscar";
        }

        carritoService.addToCart(usuarioId, productoId, cantidad);
        redirectAttributes.addFlashAttribute("mensaje", "Producto agregado al carrito exitosamente.");
        return "redirect:/producto/buscar";
    }


    @GetMapping("/productos")
    public ResponseEntity<List<CarritoProductoEntity>> getProductosInCarrito(@RequestParam Long usuarioId) {
        List<CarritoProductoEntity> productos = carritoService.getProductosInCarrito(usuarioId);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/ver-carrito")
    public String mostrarCarrito(HttpSession session, Model model) {

        // Obtener id del usuario desde la sesion
        Long usuarioId = (Long) session.getAttribute("idUsuario");

        //Checo que tenga id de la sesion
        if (usuarioId == null) {
            model.addAttribute("error", "Usuario no autenticado. Por favor, inicie sesión.");
            return "usuario/login"; // Redirect to the login page if no user ID is found
        }

        //Obtener productos en el carrito
        List<CarritoProductoEntity> productos = carritoService.getProductosInCarrito(usuarioId);
        model.addAttribute("productos", productos);

        //Calculo de la suma total
        double total = productos.stream()
                .mapToDouble(producto -> producto.getCantidad() * producto.getProducto().getPrecio())
                .sum();
        model.addAttribute("total", total);

        return "carrito"; //Mandar a la vista del carrito
    }

    @DeleteMapping("/eliminar-carrito")
    public String deleteCart(HttpSession session, RedirectAttributes redirectAttributes) {
        Long usuarioId = (Long) session.getAttribute("idUsuario");

        if (usuarioId == null) {
            redirectAttributes.addFlashAttribute("mensaje", "Usuario no autenticado. Por favor, inicie sesión.");
            return "redirect:/usuario/login";
        }

        carritoService.deleteCartByUsuarioId(usuarioId);
        redirectAttributes.addFlashAttribute("mensaje", "Carrito eliminado con éxito.");
        return "redirect:/producto/buscar";
    }

}
