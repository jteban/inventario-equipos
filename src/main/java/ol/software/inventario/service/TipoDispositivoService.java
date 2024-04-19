package ol.software.inventario.service;

import java.util.List;
import java.util.Optional;
import ol.software.inventario.entity.TipoDispositivoEntity;
import ol.software.inventario.repository.TipoDispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDispositivoService {

  private final TipoDispositivoRepository tipoDispositivoRepository;

  @Autowired
  public TipoDispositivoService(TipoDispositivoRepository tipoDispositivoRepository) {
    this.tipoDispositivoRepository = tipoDispositivoRepository;
  }

  public List<TipoDispositivoEntity> obtenerTodosLosTiposDispositivos() {
    return tipoDispositivoRepository.findAll();
  }

  public TipoDispositivoEntity obtenerTiposDispositivosPorId(Long id) {
    Optional<TipoDispositivoEntity> tipoDispositivoEntityOptional = tipoDispositivoRepository.findById(id);
    return tipoDispositivoEntityOptional.orElse(null);

  }

  public TipoDispositivoEntity crearTiposDispositivos(TipoDispositivoEntity tipoDispositivo) {
    return tipoDispositivoRepository.save(tipoDispositivo);
  }

  public TipoDispositivoEntity actualizarTiposDispositivos(Long id, TipoDispositivoEntity tipoDispositivo) {
    if(tipoDispositivoRepository.existsById(id)){
      tipoDispositivo.setId(id);
      return tipoDispositivoRepository.save(tipoDispositivo);
    }
    return null;
  }

  public void eliminarTiposDispositivos(Long id) {
    tipoDispositivoRepository.deleteById(id);
  }
}
