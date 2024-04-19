package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.EstadoEntity;
import ol.software.inventario.service.EstadoService;
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
@RequestMapping("estado")
public class EstadoController {

    private final EstadoService estadoService;

    @Autowired
    public EstadoController(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("/estados")
    public  List<EstadoEntity> obtenerTodosLosEstados(){
        return estadoService.obtenerTodosLosEstados();
    }
    @GetMapping("/estadosPorId/{id}")
    public  EstadoEntity obtenerEstadosPorId(@PathVariable Long id){
        return estadoService.obtenerEstadosPorId(id);
    }

    @PostMapping("/crear")
    public EstadoEntity crearEstado(@RequestBody EstadoEntity estado){
        return estadoService.crearEstado(estado);
    }

    @PutMapping("/actualizar/{id}")
    public EstadoEntity actualizarEstado(@PathVariable Long id, @RequestBody EstadoEntity estado) {
        return estadoService.actualizarEstado(id, estado);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarEstados(@PathVariable Long id) {
        estadoService.eliminarEstados(id);
    }

}