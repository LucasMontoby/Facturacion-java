package factura.factura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import factura.factura.models.DetalleVentaModel; 

public interface DetalleVentaRepository extends JpaRepository<DetalleVentaModel, Long>{
    
}