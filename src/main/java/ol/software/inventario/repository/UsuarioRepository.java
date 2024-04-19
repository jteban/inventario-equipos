package ol.software.inventario.repository;
import ol.software.inventario.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

  UsuarioEntity findByUsuarioAndPassword(String usuario, String password);

}
