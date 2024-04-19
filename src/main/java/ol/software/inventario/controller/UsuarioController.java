package ol.software.inventario.controller;

import ol.software.inventario.entity.UsuarioEntity;
import ol.software.inventario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public  List<UsuarioEntity> obtenerTodosLosUsuarios(){
        return usuarioService.obtenerTodosLosUsuarios();
    }

    @GetMapping("/usuariosPorId/{id}")
    public  UsuarioEntity obtenerUsuarioPorId(@PathVariable Long id){
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PostMapping("/crear")
    public UsuarioEntity crearUsuario(@RequestBody UsuarioEntity usuario){
        return usuarioService.crearUsuario(usuario);
    }

    @PutMapping("/actualizar/{id}")
    public UsuarioEntity actualizarUsuario(@PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }

}