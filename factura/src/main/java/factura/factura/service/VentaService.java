package factura.factura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import factura.factura.controller.ResourceNotFoundException;
import factura.factura.models.VentaModel;
import factura.factura.repository.VentaRepository;

@Service
public class VentaService {
    
    @Autowired
    private VentaRepository ventaRepository;
   
    public VentaModel create (VentaModel newVenta){
        return this.ventaRepository.save(newVenta);
    }

    public List<VentaModel> findAll(){
        return this.ventaRepository.findAll();
    }

    public VentaModel update(VentaModel ventaUpdate, Long id) throws ResourceNotFoundException {
        Optional<VentaModel> ventaBD = this.ventaRepository.findById(id);
        if (VentaService.isPresent()){
            VentaModel c =  ventaBD.get();
            c.setFecha_alta(((VentaModel) ventaUpdate).getFecha_alta());
            c.setTotal(((VentaModel) ventaUpdate).getTotal());
            // cliente_id?????
            return this.ventaRepository.save(c);
        }else{
            throw new ResourceNotFoundException("La venta no existe");
        }
    }

    private static boolean isPresent() {
        return false;
    }

    // Metodo para Eliminar.
    public String delete(Long id) throws ResourceNotFoundException {
        Optional<VentaModel> ventaBD = this.ventaRepository.findById(id);
        if (ventaBD.isPresent()) {
            ventaBD.get();
            this.ventaRepository.deleteById(id);
            return "La venta fue eliminada";
        }
        throw new ResourceNotFoundException("La venta no existe");
    }
    
    public VentaModel findById(Long id) throws ResourceNotFoundException {
        return this.ventaRepository.findById(id).get(); 
    }
}