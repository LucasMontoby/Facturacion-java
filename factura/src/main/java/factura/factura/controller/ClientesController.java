package factura.factura.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import factura.factura.models.ClientesModel;
import factura.factura.service.ClientesService;

@RequestMapping(path = "api/clientes")
@RestController

public class ClientesController {
    @Autowired
    private ClientesService clientesService;

    @PostMapping("/")
    public ResponseEntity<ClientesModel> create(@RequestBody ClientesModel clientes){
        return new ResponseEntity<>(this.clientesService.create(clientes), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientesModel>> findAll(){
        return new ResponseEntity<>(this.clientesService.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientesModel> update(@RequestBody final ClientesModel clientes, @PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.clientesService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientesModel> one(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(this.clientesService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
	 public ResponseEntity<String> delete (@PathVariable Long id) throws ResourceNotFoundException{
		 return new ResponseEntity<>(this.clientesService.delete(id), HttpStatus.OK);
		}
}
