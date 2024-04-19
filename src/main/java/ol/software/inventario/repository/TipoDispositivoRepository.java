package ol.software.inventario.repository;
import ol.software.inventario.entity.TipoDispositivoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDispositivoRepository extends JpaRepository<TipoDispositivoEntity, Long> {
}
