package com.modular.modules.Producto;

public class MovimientoDto {
    private String productoNombre;
    private String provedorNombre;
    private Integer cantidadAnadida;
    private Integer stockAnterior;
    private Integer stockNuevo;
    private Float totalMovimiento;

    public MovimientoDto(String productoNombre, String provedorNombre,
                         Integer cantidadAnadida, Integer stockAnterior,
                         Integer stockNuevo, Float totalMovimiento) {
        this.productoNombre = productoNombre;
        this.provedorNombre = provedorNombre;
        this.cantidadAnadida = cantidadAnadida;
        this.stockAnterior = stockAnterior;
        this.stockNuevo = stockNuevo;
        this.totalMovimiento = totalMovimiento;
    }

    public String getProductoNombre() { return productoNombre; }
    public String getProvedorNombre() { return provedorNombre; }
    public Integer getCantidadAnadida() { return cantidadAnadida; }
    public Integer getStockAnterior() { return stockAnterior; }
    public Integer getStockNuevo() { return stockNuevo; }
    public Float getTotalMovimiento() { return totalMovimiento; }
}
