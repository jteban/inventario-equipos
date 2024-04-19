package ol.software.inventario.service;

import java.util.List;
import java.util.Optional;
import ol.software.inventario.entity.EquiposComputoEntity;
import ol.software.inventario.repository.EquiposComputoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquiposComputoService {

  private final EquiposComputoRepository equiposComputoRepository;

  @Autowired
  public EquiposComputoService(EquiposComputoRepository equiposComputoRepository) {
    this.equiposComputoRepository = equiposComputoRepository;
  }

  public List<EquiposComputoEntity> obtenerTodosLosEquipos() {
    return equiposComputoRepository.findAll();
  }

  public EquiposComputoEntity obtenerEquipoPorId(Long id) {
    Optional<EquiposComputoEntity> equiposComputoEntityOptional = equiposComputoRepository.findById(id);
    return equiposComputoEntityOptional.orElse(null);
  }

  public EquiposComputoEntity crearEquipo(EquiposComputoEntity equipos) {
    return equiposComputoRepository.save(equipos);
  }

  public EquiposComputoEntity actualizarEquipo(Long id, EquiposComputoEntity equipos) {
    if(equiposComputoRepository.existsById(id)){
      equipos.setId(id);
      return equiposComputoRepository.save(equipos);
    }
    return null;
  }

  public void eliminarEquipo(Long id) {
    equiposComputoRepository.deleteById(id);
  }
}
