package factura.factura.validator;

import org.springframework.stereotype.Component;

import factura.factura.models.VentaModel;

@Component
public class ventaValidator {

    public void validate(VentaModel newVenta) {
        if((newVenta.getId())  == null) {
            throw new IllegalArgumentException("Debes colocar el total de ventas");
        }
    }
    
}