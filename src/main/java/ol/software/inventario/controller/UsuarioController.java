package ol.software.inventario.controller;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.validation.Valid;
import ol.software.inventario.entity.UsuarioEntity;
import ol.software.inventario.service.UsuarioService;
import ol.software.inventario.util.CSVGenerarReporte;
import ol.software.inventario.util.PDFGenerarReporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    private final CSVGenerarReporte csvGenerarReporte;
    private final PDFGenerarReporte pdfGenerarReporte;

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(CSVGenerarReporte csvGenerarReporte, PDFGenerarReporte pdfGenerarReporte, UsuarioService usuarioService) {
        this.csvGenerarReporte = csvGenerarReporte;
        this.pdfGenerarReporte = pdfGenerarReporte;
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
    public ResponseEntity<UsuarioEntity> crearUsuario(@Valid @RequestBody UsuarioEntity usuario) {
        UsuarioEntity nuevoUsuario = usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UsuarioEntity> actualizarUsuario(@Valid @PathVariable Long id, @RequestBody UsuarioEntity usuario) {
        UsuarioEntity actualizarUsuario = usuarioService.actualizarUsuario(id, usuario);
        return ResponseEntity.status(HttpStatus.OK).body(actualizarUsuario);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/generarReporteCSV")
    public ResponseEntity<byte[]> generarReporteCSV() throws IOException {
        List<UsuarioEntity> usuarios = usuarioService.obtenerTodosLosUsuarios();

        String fileName = "reporte_usuarios.csv";
        csvGenerarReporte.generarCSVReporte(usuarios, fileName);

        byte[] fileBytes = Files.readAllBytes(Paths.get(fileName));
        return ResponseEntity.ok()
          .contentType(MediaType.APPLICATION_OCTET_STREAM)
          .header("Content-Disposition", "attachment; filename=" + fileName)
          .body(fileBytes);
    }

    @GetMapping("/generarReportePDF")
    public ResponseEntity<byte[]> generarReportePDF() throws IOException, DocumentException {
        List<UsuarioEntity> usuarios = usuarioService.obtenerTodosLosUsuarios();

        String fileName = "reporte_usuarios.pdf";
        pdfGenerarReporte.generarPDFReporte(usuarios, fileName);

        byte[] fileBytes = Files.readAllBytes(Paths.get(fileName));
        return ResponseEntity.ok()
          .contentType(MediaType.APPLICATION_OCTET_STREAM)
          .header("Content-Disposition", "attachment; filename=" + fileName)
          .body(fileBytes);
    }

}