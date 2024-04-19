package ol.software.inventario.service;

import java.util.List;
import java.util.Optional;
import ol.software.inventario.entity.ModeloDispositivoEntity;
import ol.software.inventario.repository.ModeloDispositivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModeloDispositivoService {

  private final ModeloDispositivoRepository modeloDispositivoRepository;

  @Autowired
  public ModeloDispositivoService(ModeloDispositivoRepository modeloDispositivoRepository) {
    this.modeloDispositivoRepository = modeloDispositivoRepository;
  }

  public List<ModeloDispositivoEntity> obtenerTodosLasModelos() {
    return modeloDispositivoRepository.findAll();
  }

  public ModeloDispositivoEntity obtenerModeloPorId(Long id) {
    Optional<ModeloDispositivoEntity> modeloEntityOptional = modeloDispositivoRepository.findById(id);
    return modeloEntityOptional.orElse(null);

  }

  public ModeloDispositivoEntity crearModelo(ModeloDispositivoEntity modeloDispositivo) {
    return modeloDispositivoRepository.save(modeloDispositivo);
  }

  public ModeloDispositivoEntity actualizarModelo(Long id, ModeloDispositivoEntity modeloDispositivo) {
    if(modeloDispositivoRepository.existsById(id)){
      modeloDispositivo.setId(id);
      return modeloDispositivoRepository.save(modeloDispositivo);
    }
    return null;
  }

  public void eliminarModelo(Long id) {
    modeloDispositivoRepository.deleteById(id);
  }
}
