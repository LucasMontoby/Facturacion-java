package factura.factura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import factura.factura.repository.ClientesRepository;
import factura.factura.repository.DetalleVentaRepository;
import factura.factura.repository.ProductosRepository;
import factura.factura.repository.VentaRepository;

@SpringBootApplication
public class FacturaApplication {

	@Autowired
	ClientesRepository clientesModelRepository;

	@Autowired
	DetalleVentaRepository DetalleVentaModelRepository;

	@Autowired
	ProductosRepository ProductosModelRepository;

	@Autowired
	VentaRepository VentaModelRepository;


    public static void main(String[] args) {
    	SpringApplication.run(FacturaApplication.class, args);
    }
}
