package pe.upc.soaservices.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.upc.soaservices.entidades.Artefacto;
import pe.upc.soaservices.repositorio.RepositorioArtefacto;

import java.util.List;

@Service
public class ServicioSMARTArtefacto {
    @Autowired
    private RepositorioArtefacto repositorioArtefacto;

    public Artefacto registrar(Artefacto artefacto) throws Exception{
        Artefacto a = repositorioArtefacto.save(artefacto);
        if (artefacto.getCodigo()==a.getCodigo()) {
            System.out.println("ERRORRRR");
            throw new Exception();
        }
        return a;
    }
    public List<Artefacto> listado(){
        return repositorioArtefacto.findAll();
    }
    public Artefacto obtenerArtefacto(Long codigo){
        return repositorioArtefacto.findById(codigo).get();
    }
    public double calcularDescuento(Artefacto artefacto){
        Artefacto a;
        a = repositorioArtefacto.findById(artefacto.getCodigo()).get();
        double descuento=0;
        if (a!=null){
            descuento = a.getCosto()*0.18;
        }
        return descuento;
    }
    public List<Artefacto> obtenerProductos(double monto){
        return repositorioArtefacto.obtenerProductos(monto);
    }
    public Artefacto actualizar(Artefacto artefacto){
        Artefacto a;
        a = repositorioArtefacto.findById(artefacto.getCodigo()).get();
        if (a!=null) {
            a = repositorioArtefacto.save(artefacto);
        }
        return a;
    }
}
