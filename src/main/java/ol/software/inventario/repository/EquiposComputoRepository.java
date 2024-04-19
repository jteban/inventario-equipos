package ol.software.inventario.repository;

import ol.software.inventario.entity.EquiposComputoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquiposComputoRepository extends JpaRepository<EquiposComputoEntity, Long> {
}
