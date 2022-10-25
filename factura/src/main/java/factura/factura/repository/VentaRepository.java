package factura.factura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import factura.factura.models.VentaModel;

public interface VentaRepository extends JpaRepository<VentaModel, Long>{
    
}
