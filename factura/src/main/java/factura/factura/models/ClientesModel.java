package factura.factura.models;

import lombok.Data;

import java.time.LocalDate;

import javax.persistence.*;

@Data
@Entity
@Table(name = "clientes")
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

    @Column (name= "fecha_nacimiento")
    private LocalDate fechaNacimiento;

}
