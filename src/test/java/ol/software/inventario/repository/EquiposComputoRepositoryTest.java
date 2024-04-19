package ol.software.inventario.repository;

import java.util.Optional;
import ol.software.inventario.entity.EquiposComputoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
public class EquiposComputoRepositoryTest {

  @Autowired
  private EquiposComputoRepository equiposComputoRepository;

  @Test
  public void buscarEquipoComputoPorId_deberiaRetornarEquipo_cuandoExiste() {
    Long idExistente = 1L;

    Optional<EquiposComputoEntity> equipoOptional = equiposComputoRepository.findById(idExistente);

    assertTrue(equipoOptional.isPresent());
    EquiposComputoEntity equipo = equipoOptional.get();
  }

  @Test
  public void buscarEquipoComputoPorId_deberiaRetornarOptionalVacio_cuandoNoExiste() {
    Long idNoExistente = 100L;

    Optional<EquiposComputoEntity> equipoOptional = equiposComputoRepository.findById(idNoExistente);

    assertFalse(equipoOptional.isPresent());
  }

  @Test
  public void existeEquipoComputoPorId_deberiaRetornarVerdadero_cuandoExiste() {
    Long idExistente = 1L;

    boolean existe = equiposComputoRepository.existsById(idExistente);

    assertTrue(existe);
  }

  @Test
  public void existeEquipoComputoPorId_deberiaRetornarFalso_cuandoNoExiste() {
    Long idNoExistente = 100L;


    boolean existe = equiposComputoRepository.existsById(idNoExistente);

    assertFalse(existe);
  }

}