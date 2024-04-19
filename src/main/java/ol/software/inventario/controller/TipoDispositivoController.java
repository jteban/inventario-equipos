package ol.software.inventario.controller;

import java.util.List;
import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.entity.TipoDispositivoEntity;
import ol.software.inventario.service.TipoDispositivoService;
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
    public ResponseEntity<TipoDispositivoEntity> crearTiposDispositivos(@RequestBody TipoDispositivoEntity tipoDispositivo) {
        TipoDispositivoEntity nuevoTipo = tipoDispositivoService.crearTiposDispositivos(tipoDispositivo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoTipo);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<TipoDispositivoEntity> actualizarTiposDispositivos(@PathVariable Long id, @RequestBody TipoDispositivoEntity tipoDispositivo) {
        TipoDispositivoEntity actualizarTiposDispositivos = tipoDispositivoService.actualizarTiposDispositivos(id, tipoDispositivo);
        return ResponseEntity.status(HttpStatus.OK).body(actualizarTiposDispositivos);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarTiposDispositivos(@PathVariable Long id) {
        tipoDispositivoService.eliminarTiposDispositivos(id);
        return ResponseEntity.noContent().build();
    }


}