package pe.upc.soaservices.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.upc.soaservices.entidades.Artefacto;

import java.util.List;

public interface RepositorioArtefacto extends JpaRepository<Artefacto, Long> {
    @Query("select a from Artefacto a where a.costo>:  monto")
    public List<Artefacto> obtenerProductos(@Param("monto") double monto);
}
