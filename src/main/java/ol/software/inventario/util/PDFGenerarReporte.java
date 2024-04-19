package ol.software.inventario.util;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import ol.software.inventario.entity.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class PDFGenerarReporte {

  public void generarPDFReporte(List<UsuarioEntity> data, String fileName) throws IOException, DocumentException {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(fileName));
    document.open();

    Paragraph title = new Paragraph("Reporte de Usuarios");
    document.add(title);

    Table table = new Table(11);
    table.addCell("ID");
    table.addCell("Tipo ID");
    table.addCell("Número ID");
    table.addCell("Primer Nombre");
    table.addCell("Segundo Nombre");
    table.addCell("Primer Apellido");
    table.addCell("Segundo Apellido");
    table.addCell("Correo Electrónico");
    table.addCell("Teléfono");
    table.addCell("Usuario");
    table.addCell("Contraseña");

    for (UsuarioEntity usuario : data) {
      table.addCell(usuario.getId().toString());
      table.addCell(usuario.getTipoId());
      table.addCell(usuario.getNumeroId());
      table.addCell(usuario.getPrimerNombre());
      table.addCell(usuario.getSegundoNombre());
      table.addCell(usuario.getPrimerApellido());
      table.addCell(usuario.getSegundoApellido());
      table.addCell(usuario.getEmail());
      table.addCell(usuario.getTelefono());
      table.addCell(usuario.getUsuario());
      table.addCell(usuario.getPassword());
    }

    document.add(table);
    document.close();
  }
}