package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.TipoDispositivoEntity;
import ol.software.inventario.service.TipoDispositivoService;
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
@RequestMapping("tipo_dispositivo")
public class TipoDispositivoController {

    private final TipoDispositivoService tipoDispositivoService;

    @Autowired
    public TipoDispositivoController(TipoDispositivoService tipoDispositivoService) {
        this.tipoDispositivoService = tipoDispositivoService;
    }

    @GetMapping("/tipos")
    public  List<TipoDispositivoEntity> obtenerTodosLosTiposDispositivos(){
        return tipoDispositivoService.obtenerTodosLosTiposDispositivos();
    }
    @GetMapping("/tiposPorId/{id}")
    public  TipoDispositivoEntity obtenerTiposDispositivosPorId(@PathVariable Long id){
        return tipoDispositivoService.obtenerTiposDispositivosPorId(id);
    }

    @PostMapping("/crear")
    public TipoDispositivoEntity crearTiposDispositivos(@RequestBody TipoDispositivoEntity tipoDispositivo){
        return tipoDispositivoService.crearTiposDispositivos(tipoDispositivo);
    }

    @PutMapping("/actualizar/{id}")
    public TipoDispositivoEntity actualizarTiposDispositivos(@PathVariable Long id, @RequestBody TipoDispositivoEntity tipoDispositivo) {
        return tipoDispositivoService.actualizarTiposDispositivos(id, tipoDispositivo);
    }


    @DeleteMapping("/eliminar/{id}")
    public void eliminarTiposDispositivos(@PathVariable Long id) {
        tipoDispositivoService.eliminarTiposDispositivos(id);
    }

}