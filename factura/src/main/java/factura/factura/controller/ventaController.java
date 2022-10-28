package factura.factura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import factura.factura.exceptions.ResourceAlreadyExistsException;
import factura.factura.exceptions.ResourceNotFoundException;
import factura.factura.models.VentaModel;
import factura.factura.service.VentaService;

@RequestMapping(path = "api/venta")
@RestController

public class ventaController {
    @Autowired
    private VentaService ventaService;

    @PostMapping("/")
    public ResponseEntity<VentaModel> create(@RequestBody VentaModel venta) throws ResourceAlreadyExistsException{
        return new ResponseEntity<>(this.ventaService.create(venta), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<VentaModel>> findAll(){
        return new ResponseEntity<>(this.ventaService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VentaModel> update(@RequestBody final VentaModel venta, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ventaService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaModel> one(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.ventaService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
	 public ResponseEntity<String> delete (@PathVariable Long id) throws ResourceNotFoundException{
		 return new ResponseEntity<>(this.ventaService.delete(id), HttpStatus.OK);
		}
}
