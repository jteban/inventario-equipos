package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.EquiposComputoEntity;
import ol.software.inventario.service.EquiposComputoService;
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
    public EquiposComputoEntity crearEquipo(@RequestBody EquiposComputoEntity equipos){
        return equiposComputoService.crearEquipo(equipos);
    }

    @PutMapping("/actualizar/{id}")
    public EquiposComputoEntity actualizarEquipo(@PathVariable Long id, @RequestBody EquiposComputoEntity equipos) {
        return equiposComputoService.actualizarEquipo(id, equipos);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminarEquipo(@PathVariable Long id) {
        equiposComputoService.eliminarEquipo(id);
    }

}