package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.entity.EquiposComputoEntity;
import ol.software.inventario.service.EquiposComputoService;
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
@RequestMapping("equipo")
public class EquiposComputoController {

    private final EquiposComputoService equiposComputoService;

    public EquiposComputoController(EquiposComputoService equiposComputoService) {
        this.equiposComputoService = equiposComputoService;
    }


    @GetMapping("/equipos")
    public  List<EquiposComputoEntity> obtenerTodosLosEquipos(){
        return equiposComputoService.obtenerTodosLosEquipos();
    }
    @GetMapping("/equiposPorId/{id}")
    public  EquiposComputoEntity obtenerEquipoPorId(@PathVariable Long id){
        return equiposComputoService.obtenerEquipoPorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<EquiposComputoEntity> crearEquipo(@RequestBody EquiposComputoEntity equipos) {
        EquiposComputoEntity nuevaEquipo = equiposComputoService.crearEquipo(equipos);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaEquipo);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<EquiposComputoEntity> actualizarEquipo(@PathVariable Long id, @RequestBody EquiposComputoEntity area) {
        EquiposComputoEntity actualizarEquipo = equiposComputoService.actualizarEquipo(id, area);
        return ResponseEntity.status(HttpStatus.OK).body(actualizarEquipo);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarEquipo(@PathVariable Long id) {
        equiposComputoService.eliminarEquipo(id);
        return ResponseEntity.noContent().build();
    }
}