package factura.factura;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import factura.factura.models.ClientesModel;
import factura.factura.models.Detalle_ventaModel;
import factura.factura.models.ProductosModel;
import factura.factura.models.VentaModel;

@SpringBootApplication
public class FacturaApplication {

	@Autowired
	ClientesModel clientesModelReposotory;

	@Autowired
	Detalle_ventaModel Detalle_ventaModelRepository;

	@Autowired
	ProductosModel ProductosModelRepository;

	@Autowired
	VentaModel VentaModelRepository;


    public static void main(String[] args) {
    	SpringApplication.run(FacturaApplication.class, args);
    }
}
