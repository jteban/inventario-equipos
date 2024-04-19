package ol.software.inventario.service;

import java.util.List;
import java.util.Optional;
import ol.software.inventario.entity.EstadoEntity;
import ol.software.inventario.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadoService {

  private final EstadoRepository estadoRepository;

  @Autowired
  public EstadoService(EstadoRepository estadoRepository) {
    this.estadoRepository = estadoRepository;
  }

  public List<EstadoEntity> obtenerTodosLosEstados() {
    return estadoRepository.findAll();
  }

  public EstadoEntity obtenerEstadosPorId(Long id) {
    Optional<EstadoEntity> estadoEntityOptional = estadoRepository.findById(id);
    return estadoEntityOptional.orElse(null);

  }

  public EstadoEntity crearEstado(EstadoEntity estado) {
    return estadoRepository.save(estado);
  }

  public EstadoEntity actualizarEstado(Long id, EstadoEntity estado) {
    if(estadoRepository.existsById(id)){
      estado.setId(id);
      return estadoRepository.save(estado);
    }
    return null;
  }

  public void eliminarEstados(Long id) {
    estadoRepository.deleteById(id);
  }
}
