package factura.factura.validator;

import org.springframework.stereotype.Component;

import factura.factura.models.ClientesModel;

@Component
public class ClientesValidator {

    public void validate(ClientesModel newCliente) {
        if(newCliente.getDni().isBlank() || (Integer.parseInt(newCliente.getDni()))  <= 0) {
            throw new IllegalArgumentException("DNI invalido");
        }
    }
    
}

