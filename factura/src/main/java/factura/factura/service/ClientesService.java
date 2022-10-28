package factura.factura.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.stereotype.Service;

import factura.factura.exceptions.ResourceAlreadyExistsException;
import factura.factura.exceptions.ResourceNotFoundException;
import factura.factura.models.ClientesModel;
import factura.factura.repository.ClientesRepository;
import factura.factura.validator.ClientesValidator;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository clientesRepository;
   
    // Sin validación--------------------------------------------
    // public ClientesModel create (ClientesModel newCliente) {
    //     return this.clientesRepository.save(newCliente);
    // }
    
    @Autowired
    private ClientesValidator clientesValidator;

    @Transient private Integer edad;

    public ClientesModel create (ClientesModel newCliente) throws ResourceAlreadyExistsException {
        this.clientesValidator.validate(newCliente);

        Optional<ClientesModel> clientesDB = this.clientesRepository.findByDni(newCliente.getDni());
        if (clientesDB.isPresent()){
            throw new ResourceAlreadyExistsException("Ya existe un cliente con el DNI brindado. Verificar");
        }else{
            return this.clientesRepository.save(newCliente);
        }
    }

    public List<ClientesModel> findAll(){
        return this.clientesRepository.findAll();
    }

    public ClientesModel update(ClientesModel clientesUpdate, Long id) throws ResourceNotFoundException {
        Optional<ClientesModel> clientesBD = this.clientesRepository.findById(id);
        if (ClientesService.isPresent()){
            ClientesModel c =  clientesBD.get();
            c.setDni(clientesUpdate.getDni());
            c.setNombre(clientesUpdate.getNombre());
            c.setApellido(clientesUpdate.getApellido());
            c.setFechaNacimiento(clientesUpdate.getFechaNacimiento());
            return this.clientesRepository.save(c);
        }else{
            throw new ResourceNotFoundException("El cliente no existe");
        }
    }
    
    private static boolean isPresent() {
        return false;
    }

    // Metodo para Eliminar.
    public String delete(Long id) throws ResourceNotFoundException {
        Optional<ClientesModel> clienteBD = this.clientesRepository.findById(id);
        if (clienteBD.isPresent()) {
            clienteBD.get();
            this.clientesRepository.deleteById(id);
            return "El cliente fue eliminado";
        }
        throw new ResourceNotFoundException("El cliente no existe");
    }

    public ClientesModel findById(Long id) throws ResourceNotFoundException {
        return this.clientesRepository.findById(id).get(); 
    }
    public long getEdad() { return Period.between(this.getFechaNacimiento(), LocalDate.now()).get(null); }

    private LocalDate getFechaNacimiento() {
        return null;
    }

}