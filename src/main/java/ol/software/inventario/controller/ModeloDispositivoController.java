package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.entity.ModeloDispositivoEntity;
import ol.software.inventario.service.ModeloDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("modelo")
public class ModeloDispositivoController {

    private final ModeloDispositivoService modeloService;

    @Autowired
    public ModeloDispositivoController(ModeloDispositivoService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping("/modelos")
    public  List<ModeloDispositivoEntity> obtenerTodosLasModelos(){
        return modeloService.obtenerTodosLasModelos();
    }
    @GetMapping("/modelosPorId/{id}")
    public  ModeloDispositivoEntity obtenerModeloPorId(@PathVariable Long id){
        return modeloService.obtenerModeloPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<ModeloDispositivoEntity> crearModelo(@RequestBody ModeloDispositivoEntity modeloDispositivo) {
        ModeloDispositivoEntity nuevaModelo = modeloService.crearModelo(modeloDispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaModelo);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<ModeloDispositivoEntity> actualizarModelo(@PathVariable Long id, @RequestBody ModeloDispositivoEntity modeloDispositivo) {
        ModeloDispositivoEntity actualizarArea = modeloService.actualizarModelo(id, modeloDispositivo);
        return ResponseEntity.status(HttpStatus.OK).body(actualizarArea);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarModelo(@PathVariable Long id) {
        modeloService.eliminarModelo(id);
        return ResponseEntity.noContent().build();
    }
}