package factura.factura.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clientesModel")
public class ClientesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String dni;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private Data fecha_nacimiento;

    public ClientesModel() {
    }

    public ClientesModel(Long id, String dni, String nombre, String apellido, Data fecha_nacimiento) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fecha_nacimiento = fecha_nacimiento;
    }

}
