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
    @JoinColumn(name = "detalle_id")
    private Detalle_ventaModel Detalle_ventaModel;
    
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Detalle_ventaModel detalle_ventaModel;

    public Detalle_ventaModel() {
    }

    public Detalle_ventaModel(Long id, int cantidad, Double subtototal, Detalle_ventaModel detalle_ventaModel) {
        this.id = id;
        this.cantidad = cantidad;
        this.subtototal = subtototal;
        this.detalle_ventaModel = detalle_ventaModel;
    }

}