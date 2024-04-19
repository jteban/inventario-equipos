package ol.software.inventario.util;

import com.opencsv.CSVWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import ol.software.inventario.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class CSVGenerarReporte {

  public void generarCSVReporte(List<UsuarioEntity> usuarios, String fileName) throws IOException {
    Path path = Paths.get(fileName);
    try (CSVWriter writer = new CSVWriter(Files.newBufferedWriter(path))) {
      String[] header = {"Id", "Tipo ID", "Número ID", "Primer Nombre", "Segundo Nombre", "Primer Apellido", "Segundo Apellido",
                          "Email", "Teléfono", "Usuario", "Password"};
      writer.writeNext(header);

      for (UsuarioEntity reportData : usuarios) {
        String[] rowData = {String.valueOf(reportData.getId()), reportData.getTipoId(), reportData.getNumeroId(),
          reportData.getPrimerNombre(), reportData.getSegundoNombre(), reportData.getPrimerApellido(), reportData.getSegundoApellido(),
          reportData.getEmail(), reportData.getTelefono(), reportData.getUsuario(), reportData.getPassword()};
        writer.writeNext(rowData);
      }
    }
  }
}