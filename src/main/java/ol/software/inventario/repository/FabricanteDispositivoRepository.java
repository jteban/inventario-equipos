package ol.software.inventario.repository;
import ol.software.inventario.entity.FabricanteDispositivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteDispositivoRepository extends JpaRepository<FabricanteDispositivoEntity, Long> {
}
