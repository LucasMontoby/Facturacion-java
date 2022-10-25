package factura.factura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import factura.factura.models.ProductosModel;

public interface ProductosRepository extends JpaRepository<ProductosModel, Long>{
    
}