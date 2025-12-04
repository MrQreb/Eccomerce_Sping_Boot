package com.modular.modular;

import com.modular.modules.Carrito.CarritoModule;
import com.modular.modules.Direccion.DireccionModule;
import com.modular.modules.MovimientoInventario.MovimientoInventarioModule;
import com.modular.modules.Producto.ProductoModule;
import com.modular.modules.Provedor.ProvedorModule;
import com.modular.modules.TipoPago.TipoPagoModule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.modular.modules.Categoria.CategoriaModule;
import com.modular.modules.RolUsuario.RolUsuarioModule;
import com.modular.modules.Usuario.UsuarioModule;


@SpringBootApplication()
@Import({
        UsuarioModule.class,
        RolUsuarioModule.class,
        CategoriaModule.class,
        ProductoModule.class,
        ProvedorModule.class,
        MovimientoInventarioModule.class,
        DireccionModule.class,
        CarritoModule.class,
        TipoPagoModule.class
})

public class ModularApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModularApplication.class, args);
    }
}