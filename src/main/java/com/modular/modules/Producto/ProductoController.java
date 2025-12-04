package com.modular.modules.Producto;

import com.modular.modules.Categoria.Entity.CategoriaEntity;
import com.modular.modules.Categoria.CategoriaService;
import com.modular.modules.Producto.Entity.ProductoEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductoController {
    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    public ProductoController(ProductoService productoService, CategoriaService categoriaService) {
        this.productoService = productoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/producto/form")
    public String showProductoForm(Model model) {
        List<CategoriaEntity> categorias = categoriaService.getCategorias();

        model.addAttribute("categorias", categorias);
        model.addAttribute("producto", new ProductoEntity());
        return "producto/crear-producto-form";
    }


    @PostMapping("/producto/create")
    public String createProducto(@RequestParam("categoriaId") long categoriaId, ProductoEntity producto) {
        productoService.createProducto(producto, categoriaId);
        return "redirect:/producto/form";
    }


    @GetMapping("/producto/buscar")
    public String buscarProductos(
            @RequestParam(required = false) Long categoriaId,
            Model model
    ){
        List<ProductoEntity> productos = productoService.getProductos(categoriaId);
        List<CategoriaEntity> categorias = categoriaService.getCategorias();

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoriaId", categoriaId);
        return "producto/buscar-productos";
    }

    @GetMapping("/producto/editar")
    public String showEditProductoForm(@RequestParam("id") long id, Model model) {
        ProductoEntity producto = productoService.getProductoById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        List<CategoriaEntity> categorias = categoriaService.getCategorias();

        model.addAttribute("producto", producto);
        model.addAttribute("categorias", categorias);
        return "producto/editar-producto-form";
    }


    // Metodos para admin

    @GetMapping("/producto/buscar-admin")
    public String buscarProductosAdmin(
            @RequestParam(required = false) Long categoriaId,
            Model model
    ){
        List<ProductoEntity> productos = productoService.getProductos(categoriaId);
        List<CategoriaEntity> categorias = categoriaService.getCategorias();

        model.addAttribute("productos", productos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("categoriaId", categoriaId);
        return "producto/buscar-productos-admin";
    }


    @PostMapping("/producto/update")
    public String updateProducto(
            @RequestParam("id") long id,
            @RequestParam("categoriaId") long categoriaId,
            ProductoEntity producto
    ) {
        productoService.updateProducto(id, producto, categoriaId);
        return "redirect:/producto/buscar-admin";
    }

    @PostMapping("/producto/delete")
    public String deleteProducto(@RequestParam("id") long id) {
        productoService.deleteProducto(id);
        return "redirect:/producto/buscar-admin";
    }

}
