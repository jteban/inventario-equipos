package ol.software.inventario.repository;

import java.util.Optional;
import ol.software.inventario.entity.AreaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AreaRepositoryTest {
    @Autowired
    private AreaRepository areaRepository;

    @Test
    public void buscarAreaPorId_deberiaRetornarArea_cuandoExiste() {
      Long idExistente = 1L;

      Optional<AreaEntity> areaOptional = areaRepository.findById(idExistente);

      assertTrue(areaOptional.isPresent());
      AreaEntity area = areaOptional.get();
    }

    @Test
    public void buscarAreaPorId_deberiaRetornarOptionalVacio_cuandoNoExiste() {
      Long idNoExistente = 100L;

      Optional<AreaEntity> areaOptional = areaRepository.findById(idNoExistente);

      assertFalse(areaOptional.isPresent());
    }

    @Test
    public void existeAreaPorId_deberiaRetornarVerdadero_cuandoExiste() {
      Long idExistente = 1L;


      boolean existe = areaRepository.existsById(idExistente);

      assertTrue(existe);
    }

    @Test
    public void existeAreaPorId_deberiaRetornarFalso_cuandoNoExiste() {
      Long idNoExistente = 100L;

      boolean existe = areaRepository.existsById(idNoExistente);

      assertFalse(existe);
    }
  }