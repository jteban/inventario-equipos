package ol.software.inventario.service;

import java.util.List;
import java.util.Optional;
import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaService {

  private final AreaRepository areaRepository;

  @Autowired
  public AreaService(AreaRepository areaRepository) {
    this.areaRepository = areaRepository;
  }

  public List<AreaEntity> obtenerTodasLasAreas() {
    return areaRepository.findAll();
  }

  public AreaEntity obtenerAreaPorId(Long id) {
    Optional<AreaEntity> areaEntityOptional = areaRepository.findById(id);
    return areaEntityOptional.orElse(null);

  }

  public AreaEntity crearArea(AreaEntity area) {
    return areaRepository.save(area);
  }

  public AreaEntity actualizarArea(Long id, AreaEntity area) {
    if(areaRepository.existsById(id)){
      area.setId(id);
      return areaRepository.save(area);
    }
    return null;
  }

  public void eliminarArea(Long id) {
    areaRepository.deleteById(id);
  }
}
