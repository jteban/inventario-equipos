package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.RolEntity;
import ol.software.inventario.service.RolService;
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
@RequestMapping("rol")
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping("/roles")
    public  List<RolEntity> obtenerTodosLosRoles(){
        return rolService.obtenerTodosLosRoles();
    }
    @GetMapping("/rolesPorId/{id}")
    public  RolEntity obtenerRolPorId(@PathVariable Long id){
        return rolService.obtenerRolPorId(id);
    }

    @PostMapping("/crear")
    public RolEntity crearRol(@RequestBody RolEntity rol){

        return rolService.crearRol(rol);
    }

    @PutMapping("/actualizar/{id}")
    public RolEntity actualizarRol(@PathVariable Long id, @RequestBody RolEntity rol) {
        return rolService.actualizarRol(id, rol);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
    }

}