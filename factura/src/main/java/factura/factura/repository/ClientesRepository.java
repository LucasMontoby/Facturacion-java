package factura.factura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import factura.factura.models.ClientesModel;

public interface ClientesRepository extends JpaRepository<ClientesModel, Long>{


}

