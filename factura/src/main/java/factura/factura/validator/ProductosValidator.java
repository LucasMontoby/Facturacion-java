package factura.factura.validator;

import org.springframework.stereotype.Component;

import factura.factura.models.ProductosModel;

@Component
public class ProductosValidator {

    public void validate(ProductosModel newProductos) {
        if(newProductos.getSku().isBlank() || (Integer.parseInt(newProductos.getSku()))  <= 0) {
            throw new IllegalArgumentException("Sku invalido");
        }
    }
    
}