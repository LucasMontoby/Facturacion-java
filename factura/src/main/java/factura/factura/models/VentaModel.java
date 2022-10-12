package factura.factura.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ventaModel")
public class VentaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Data fecha_alta;

    @Column
    private Double total;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private ClientesModel clienteModel;

    public VentaModel() {
    }

    public VentaModel(Long id, Data fecha_alta, Double total) {
        this.id = id;
        this.fecha_alta = fecha_alta;
        this.total = total;
    }

}