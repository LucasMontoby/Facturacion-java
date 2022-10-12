package factura.factura.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detalle_ventaModel")
public class Detalle_ventaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int cantidad;

    @Column
    private Double subtototal;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private VentaModel VentaModel;
    
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductosModel ProductosModel;

    public Detalle_ventaModel() {
    }

    public Detalle_ventaModel(Long id, int cantidad, Double subtototal, factura.factura.models.VentaModel ventaModel,
            factura.factura.models.ProductosModel productosModel) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtototal = subtototal;
        VentaModel = ventaModel;
        ProductosModel = productosModel;
    }

}