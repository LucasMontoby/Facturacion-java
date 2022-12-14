package factura.factura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import factura.factura.exceptions.ResourceAlreadyExistsException;
import factura.factura.exceptions.ResourceNotFoundException;
import factura.factura.models.ProductosModel;
import factura.factura.repository.ProductosRepository;
import factura.factura.validator.ProductosValidator;

@Service
public class ProductosService {
    @Autowired
    private ProductosRepository productosRepository;
    private Optional<ProductosModel> ProductosBD;
   

    // public ProductosModel create (ProductosModel newProductosModel){
    //     return this.productosRepository.save(newProductosModel);
    // }

    @Autowired
    private ProductosValidator productosValidator;


    public ProductosModel create (ProductosModel newProducto) throws ResourceAlreadyExistsException {
        this.productosValidator.validate(newProducto);

        Optional<ProductosModel> productosDB = this.productosRepository.findBySku(newProducto.getSku());
        if (productosDB.isPresent()){
            throw new ResourceAlreadyExistsException("Ya existe un producto. Verificar");
        }else{
            return this.productosRepository.save(newProducto);
        }
    }

    public List<ProductosModel> findAll(){
        return this.productosRepository.findAll();
    }

    public ProductosModel update(ProductosModel ProductosUpdate, Long id) throws ResourceNotFoundException {
        if (ProductosService.isPresent()){
            ProductosModel c = ProductosBD.get();
            c.setSku(ProductosUpdate.getSku());
            c.setDescripcion(ProductosUpdate.getDescripcion());
            c.setPrecio_compra(ProductosUpdate.getPrecio_compra());
            c.setPrecio_compra(ProductosUpdate.getPrecio_compra());
            c.setStock(ProductosUpdate.getStock());
            c.setFecha_alta(ProductosUpdate.getFecha_alta());
            return this.productosRepository.save(c);
        }else{
            throw new ResourceNotFoundException("El producto no existe");
        }

    }

    private static boolean isPresent() {
        return false;
    }

    // Metodo para Eliminar.
    public String delete(Long id) throws ResourceNotFoundException {
        if (ProductosBD.isPresent()) {
            ProductosBD.get();
            this.productosRepository.deleteById(id);
            return "El producto fue eliminado";
        }
        throw new ResourceNotFoundException("El producto no existe");
    }
    
    public ProductosModel findById(Long id) throws ResourceNotFoundException {
        return this.productosRepository.findById(id).get(); 
    }
}
