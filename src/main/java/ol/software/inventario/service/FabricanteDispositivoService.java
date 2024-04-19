package ol.software.inventario.service;

import java.util.List;
import java.util.Optional;
import ol.software.inventario.entity.FabricanteDispositivoEntity;
import ol.software.inventario.repository.FabricanteDispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FabricanteDispositivoService {

  private final FabricanteDispositivoRepository fabricanteDispositivoRepository;

  @Autowired
  public FabricanteDispositivoService(FabricanteDispositivoRepository fabricanteDispositivoRepository) {
    this.fabricanteDispositivoRepository = fabricanteDispositivoRepository;
  }

  public List<FabricanteDispositivoEntity> obtenerTodosLosFabricantes() {
    return fabricanteDispositivoRepository.findAll();
  }

  public FabricanteDispositivoEntity obtenerFabricantePorId(Long id) {
    Optional<FabricanteDispositivoEntity> equiposComputoEntityOptional = fabricanteDispositivoRepository.findById(id);
    return equiposComputoEntityOptional.orElse(null);
  }

  public FabricanteDispositivoEntity crearFabricante(FabricanteDispositivoEntity equipos) {
    return fabricanteDispositivoRepository.save(equipos);
  }

  public FabricanteDispositivoEntity actualizarFabricante(Long id, FabricanteDispositivoEntity equipos) {
    if(fabricanteDispositivoRepository.existsById(id)){
      equipos.setId(id);
      return fabricanteDispositivoRepository.save(equipos);
    }
    return null;
  }

  public void eliminarFabricante(Long id) {
    fabricanteDispositivoRepository.deleteById(id);
  }
}
