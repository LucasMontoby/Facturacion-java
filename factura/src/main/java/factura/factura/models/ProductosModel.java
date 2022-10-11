package factura.factura.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "productosModel")
public class ProductosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sku;

    @Column
    private String descripcion;

    @Column
    private Double preciCompra;

    @Column
    private Double precioVenta;

    @Column
    private int stock;

    @Column
    private Data fecha_alta;
    
    public ProductosModel() {
    }

    public ProductosModel(Long id, String sku, String descripcion, Double preciCompra, Double precioVenta, final int stock,
            Data fecha_alta) {
        this.id = id;
        this.sku = sku;
        this.descripcion = descripcion;
        this.preciCompra = preciCompra;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.fecha_alta = fecha_alta;
    }
}