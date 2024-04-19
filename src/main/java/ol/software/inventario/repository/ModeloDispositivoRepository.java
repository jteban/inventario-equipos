package ol.software.inventario.repository;
import ol.software.inventario.entity.ModeloDispositivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloDispositivoRepository extends JpaRepository<ModeloDispositivoEntity, Long> {
}
