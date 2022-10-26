package factura.factura.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import factura.factura.models.ProductosModel;
import factura.factura.service.ProductosService;

@RequestMapping(path = "api/productos")
@RestController

public class ProductosController {
    @Autowired
    private ProductosService productosService;

    @PostMapping("/")
    public ResponseEntity<ProductosModel> create(@RequestBody ProductosModel productosModel){
        return new ResponseEntity<>(this.productosService.create(productosModel), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductosModel>> findAll(){
        return new ResponseEntity<>(this.productosService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductosModel> update(@RequestBody ProductosModel productosUpdate, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.productosService.update(productosUpdate, id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductosModel> one(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.productosService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
	 public ResponseEntity<String> delete (@PathVariable Long id) throws ResourceNotFoundException{
		 return new ResponseEntity<>(this.productosService.delete(id), HttpStatus.OK);
		}
}