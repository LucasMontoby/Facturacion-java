package factura.factura.models;

import lombok.Data;

import java.time.LocalDate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "venta")
public class VentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDate fecha_alta;

    @Column
    private Double total;

    @ManyToOne
    @JoinColumn(name = "clientes_id")
    private ClientesModel clientesModel;

}