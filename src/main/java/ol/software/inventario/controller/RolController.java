package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.entity.RolEntity;
import ol.software.inventario.service.RolService;
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
    public ResponseEntity<RolEntity> crearRol(@RequestBody RolEntity rol) {
        RolEntity nuevoRol = rolService.crearRol(rol);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoRol);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<RolEntity> actualizarRol(@PathVariable Long id, @RequestBody RolEntity rol) {
        RolEntity actualizarRol = rolService.actualizarRol(id, rol);
        return ResponseEntity.status(HttpStatus.OK).body(actualizarRol);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarRol(@PathVariable Long id) {
        rolService.eliminarRol(id);
        return ResponseEntity.noContent().build();
    }

}