package ol.software.inventario.service;

import java.util.List;
import java.util.Optional;
import ol.software.inventario.entity.RolEntity;
import ol.software.inventario.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolService {

  private final RolRepository rolRepository;

  @Autowired
  public RolService(RolRepository rolRepository) {
    this.rolRepository = rolRepository;
  }

  public List<RolEntity> obtenerTodosLosRoles() {
    return rolRepository.findAll();
  }

  public RolEntity obtenerRolPorId(Long id) {
    Optional<RolEntity> rolEntityOptional = rolRepository.findById(id);
    return rolEntityOptional.orElse(null);

  }

  public RolEntity crearRol(RolEntity area) {
    return rolRepository.save(area);
  }

  public RolEntity actualizarRol(Long id, RolEntity area) {
    if(rolRepository.existsById(id)){
      area.setId(id);
      return rolRepository.save(area);
    }
    return null;
  }

  public void eliminarRol(Long id) {
    rolRepository.deleteById(id);
  }
}
