package factura.factura.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detalle_venta")
public class DetalleVentaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int detalle;

    @Column
    private int cantidad;

    @Column
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name = "venta_id")
    private VentaModel VentaModel;
    
    @ManyToOne
    @JoinColumn(name = "productos_id")
    private ProductosModel ProductosModel;

    }

