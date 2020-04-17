package pe.upc.soaservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pe.upc.soaservices.entidades.Artefacto;
import pe.upc.soaservices.servicios.ServicioSMARTArtefacto;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ServicioSMARRest {
    @Autowired
    private ServicioSMARTArtefacto servicioSMARTArtefacto;

    @PostMapping("/producto")
    public Artefacto registrar(@RequestBody Artefacto artefacto){
        Artefacto a;
        try {
            a = servicioSMARTArtefacto.registrar(artefacto);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo registrar", e);
        }
        return a;
    }

    @GetMapping("/productos")
    public List<Artefacto> listado(){
        List<Artefacto> l;
        try {
            l = servicioSMARTArtefacto.listado();
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo obtener listado", e);
        }
        return l;
    }

    @GetMapping("/producto/{codigo}")
    public Artefacto obtenerArtefacto(@PathVariable(value = "codigo")Long codigo){
        Artefacto a;
        try{
           a = servicioSMARTArtefacto.obtenerArtefacto(codigo);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No existe producto", e);
        }
        return a;
    }
    @PostMapping("/producto/descuento")
    public double calcularDescuento(@RequestBody Artefacto artefacto){
        return servicioSMARTArtefacto.calcularDescuento(artefacto);
    }

    @GetMapping("/productos/{monto}")
    public List<Artefacto> obtenerProductos(@PathVariable("monto") double monto){
        try{
             return servicioSMARTArtefacto.obtenerProductos(monto);
        }catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se pudo obtener", e);
    }
    }

}
