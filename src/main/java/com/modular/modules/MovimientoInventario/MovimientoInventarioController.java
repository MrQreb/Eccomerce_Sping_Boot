package com.modular.modules.MovimientoInventario;

import com.modular.modules.MovimientoInventario.Entity.MovimientoInventarioEntitiy;
import com.modular.modules.Producto.Entity.ProductoEntity;
import com.modular.modules.Producto.Repository.ProductoRepository;
import com.modular.modules.Provedor.Entity.ProvedorEntity;
import com.modular.modules.Provedor.Repository.ProvedorRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller
public class MovimientoInventarioController {

    private final MovimientoInventarioService movimientoInventarioService;
    private final ProductoRepository productoRepository;
    private final ProvedorRepository provedorRepository;

    public MovimientoInventarioController(
            MovimientoInventarioService movimientoInventarioService,
            ProductoRepository productoRepository,
            ProvedorRepository provedorRepository
    ) {
        this.movimientoInventarioService = movimientoInventarioService;
        this.productoRepository = productoRepository;
        this.provedorRepository = provedorRepository;
    }

    @GetMapping("/movimiento/sutir")
    public String showMovimientoForm(Model model) {
        List<ProductoEntity> productos = productoRepository.findAll();
        List<ProvedorEntity> provedores = provedorRepository.findAll();

        model.addAttribute("productos", productos);
        model.addAttribute("provedores", provedores);
        return "movimiento/crear-movimiento-form";
    }

    @PostMapping("/movimiento/create")
    public String createMovimiento(
            @RequestParam("productoId") Long productoId,
            @RequestParam("provedorId") Long provedorId,
            @RequestParam("cantidadAnadida") int cantidadAnadida
    ) {

        ProductoEntity producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado"));
        ProvedorEntity provedor = provedorRepository.findById(provedorId)
                .orElseThrow(() -> new IllegalArgumentException("Proveedor no encontrado"));

        MovimientoInventarioEntitiy movimiento = new MovimientoInventarioEntitiy();
        movimiento.setCantidadAnadida(cantidadAnadida);
        movimiento.setProducto(producto);
        movimiento.setProvedor(provedor);

        movimientoInventarioService.guardarMovimiento(movimiento);
        return "redirect:/movimiento/sutir";
    }

    @GetMapping("/movimiento/ver")
    public String listMovimientos(Model model) {
        List<MovimientoInventarioEntitiy> movimientos = movimientoInventarioService.findAll();
        model.addAttribute("movimientos", movimientos);
        return "movimiento/ver-movimiento-form";
    }

    @GetMapping("/movimiento/pdf")
    public void exportMovimientosToPdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=movimientos.pdf");

        List<MovimientoInventarioEntitiy> movimientos = movimientoInventarioService.findAll();

        com.lowagie.text.Document document = new com.lowagie.text.Document();
        com.lowagie.text.pdf.PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        document.add(new com.lowagie.text.Paragraph("Movimientos de Inventario"));
        com.lowagie.text.pdf.PdfPTable table = new com.lowagie.text.pdf.PdfPTable(6);
        table.addCell("Producto");
        table.addCell("Proveedor");
        table.addCell("Cantidad");
        table.addCell("Stock Anterior");
        table.addCell("Stock Nuevo");
        table.addCell("Total");

        for (MovimientoInventarioEntitiy m : movimientos) {
            table.addCell(m.getProducto() != null ? m.getProducto().getNombre() : "N/A");
            table.addCell(m.getProvedor() != null ? m.getProvedor().getNombre() : "N/A");
            table.addCell(String.valueOf(m.getCantidadAnadida()));
            table.addCell(String.valueOf(m.getStockAnterior()));
            table.addCell(String.valueOf(m.getStockNuevo()));
            table.addCell(String.valueOf(m.getTotalMovimiento()));
        }

        document.add(table);
        document.close();
    }

}
