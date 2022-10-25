package factura.factura.models;

import lombok.Data;

import java.time.LocalDate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "productos")
public class ProductosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String sku;

    @Column
    private String descripcion;

    @Column
    private Double precio_compra;

    @Column
    private Double precio_venta;

    @Column
    private int stock;

    @Column
    private LocalDate fecha_alta;

}