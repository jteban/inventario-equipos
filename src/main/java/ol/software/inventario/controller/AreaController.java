package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.service.AreaService;
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
@RequestMapping("area")
public class AreaController {

    private final AreaService areaService;

    @Autowired
    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("/areas")
    public  List<AreaEntity> obtenerTodasLasAreas(){
        return areaService.obtenerTodasLasAreas();
    }
    @GetMapping("/areasPorId/{id}")
    public  AreaEntity obtenerAreaPorId(@PathVariable Long id){
        return areaService.obtenerAreaPorId(id);
    }

    @PostMapping("/crear")
    public AreaEntity crearArea(@RequestBody AreaEntity area){
        return areaService.crearArea(area);
    }

    @PutMapping("/actualizar/{id}")
    public AreaEntity actualizarArea(@PathVariable Long id, @RequestBody AreaEntity area) {
        return areaService.actualizarArea(id, area);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminarArea(@PathVariable Long id) {
        areaService.eliminarArea(id);
    }

}