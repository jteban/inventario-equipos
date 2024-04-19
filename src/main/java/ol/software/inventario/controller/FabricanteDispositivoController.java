package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.FabricanteDispositivoEntity;
import ol.software.inventario.service.FabricanteDispositivoService;
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
    @GetMapping("/equiposPorId/{id}")
    public  FabricanteDispositivoEntity obtenerFabricantePorId(@PathVariable Long id){
        return fabricanteDispositivoService.obtenerFabricantePorId(id);
    }

    @PostMapping("/crear")
    public FabricanteDispositivoEntity crearFabricante(@RequestBody FabricanteDispositivoEntity fabricante){
        return fabricanteDispositivoService.crearFabricante(fabricante);
    }

    @PutMapping("/actualizar/{id}")
    public FabricanteDispositivoEntity actualizarFabricante(@PathVariable Long id, @RequestBody FabricanteDispositivoEntity fabricante) {
        return fabricanteDispositivoService.actualizarFabricante(id, fabricante);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminarFabricante(@PathVariable Long id) {
        fabricanteDispositivoService.eliminarFabricante(id);
    }

}