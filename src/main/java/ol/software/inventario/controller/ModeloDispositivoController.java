package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.ModeloDispositivoEntity;
import ol.software.inventario.service.ModeloDispositivoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModeloDispositivoEntity crearModelo(@RequestBody ModeloDispositivoEntity modeloDispositivo){
        return modeloService.crearModelo(modeloDispositivo);
    }

    @PutMapping("/actualizar/{id}")
    public ModeloDispositivoEntity actualizarModelo(@PathVariable Long id, @RequestBody ModeloDispositivoEntity modeloDispositivo) {
        return modeloService.actualizarModelo(id, modeloDispositivo);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminarModelo(@PathVariable Long id) {
        modeloService.eliminarModelo(id);
    }

}