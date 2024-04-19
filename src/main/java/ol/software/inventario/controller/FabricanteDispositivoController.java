package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.entity.FabricanteDispositivoEntity;
import ol.software.inventario.service.FabricanteDispositivoService;
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
@RequestMapping("fabricante")
public class FabricanteDispositivoController {

    private final FabricanteDispositivoService fabricanteDispositivoService;

    public FabricanteDispositivoController(FabricanteDispositivoService fabricanteDispositivoService) {
        this.fabricanteDispositivoService = fabricanteDispositivoService;
    }

    @GetMapping("/fabricantes")
    public  List<FabricanteDispositivoEntity> obtenerTodosLosFabricantes(){
        return fabricanteDispositivoService.obtenerTodosLosFabricantes();
    }
    @GetMapping("/fabricantesPorId/{id}")
    public  FabricanteDispositivoEntity obtenerFabricantePorId(@PathVariable Long id){
        return fabricanteDispositivoService.obtenerFabricantePorId(id);
    }

    @PostMapping("/crear")
    public ResponseEntity<FabricanteDispositivoEntity> crearFabricante(@RequestBody FabricanteDispositivoEntity fabricante) {
        FabricanteDispositivoEntity nuevoFabricante = fabricanteDispositivoService.crearFabricante(fabricante);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoFabricante);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<FabricanteDispositivoEntity> actualizarFabricante(@PathVariable Long id, @RequestBody FabricanteDispositivoEntity fabricante) {
        FabricanteDispositivoEntity actualizarFabricante = fabricanteDispositivoService.actualizarFabricante(id, fabricante);
        return ResponseEntity.status(HttpStatus.OK).body(actualizarFabricante);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarFabricante(@PathVariable Long id) {
        fabricanteDispositivoService.eliminarFabricante(id);
        return ResponseEntity.noContent().build();
    }

}