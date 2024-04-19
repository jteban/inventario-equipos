package ol.software.inventario.service;

import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.entity.EquiposComputoEntity;
import ol.software.inventario.repository.EquiposComputoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EquiposComputoServiceTest {

  @Mock
  private EquiposComputoRepository equiposComputoRepository;

  @InjectMocks
  private EquiposComputoService equiposComputoService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testObtenerTodosLosEquipos() {
    List<EquiposComputoEntity> equiposComputoEntities = new ArrayList<>();
    EquiposComputoEntity equiposComputoEntity = new EquiposComputoEntity();
    equiposComputoEntity.setId(1L);
    equiposComputoEntity.setNombre("Monitor");
    equiposComputoEntities.add(equiposComputoEntity);

    EquiposComputoEntity equiposComputoEntities2 = new EquiposComputoEntity();
    equiposComputoEntities2.setId(2L);
    equiposComputoEntities2.setNombre("Teclado");
    equiposComputoEntities.add(equiposComputoEntities2);

    when(equiposComputoRepository.findAll()).thenReturn(equiposComputoEntities);

    // Act
    List<EquiposComputoEntity> result = equiposComputoService.obtenerTodosLosEquipos();

    // Assert
    assertEquals(2, result.size());
    assertEquals("Monitor", result.get(0).getNombre());
    assertEquals("Teclado", result.get(1).getNombre());
  }

  @Test
  void testObtenerEquipoPorId_Existente() {
    // Arrange
    Long id = 1L;
    EquiposComputoEntity equipo = new EquiposComputoEntity();
    equipo.setId(1l);
    equipo.setNombre("Monitor");
    when(equiposComputoRepository.findById(id)).thenReturn(Optional.of(equipo));

    // Act
    EquiposComputoEntity result = equiposComputoService.obtenerEquipoPorId(id);

    // Assert
    assertEquals(equipo, result);
  }

  @Test
  void testObtenerEquipoPorId_NoExistente() {
    // Arrange
    Long id = 1L;
    when(equiposComputoRepository.findById(id)).thenReturn(Optional.empty());

    // Act
    EquiposComputoEntity result = equiposComputoService.obtenerEquipoPorId(id);

    // Assert
    assertEquals(null, result);
  }

  @Test
  void testCrearEquipo() {
    // Arrange
    EquiposComputoEntity equipo = new EquiposComputoEntity();
    equipo.setId(1l);
    equipo.setNombre("Monitor");
    when(equiposComputoRepository.save(equipo)).thenReturn(equipo);

    // Act
    EquiposComputoEntity result = equiposComputoService.crearEquipo(equipo);

    // Assert
    assertEquals(equipo, result);
  }

  @Test
  void testActualizarEquipo_Existente() {
    // Arrange
    Long id = 1L;
    EquiposComputoEntity equipo = new EquiposComputoEntity();
    equipo.setId(1l);
    equipo.setNombre("Monitor");
    when(equiposComputoRepository.existsById(id)).thenReturn(true);
    when(equiposComputoRepository.save(equipo)).thenReturn(equipo);

    // Act
    EquiposComputoEntity result = equiposComputoService.actualizarEquipo(id, equipo);

    // Assert
    assertEquals(equipo, result);
  }

  @Test
  void testActualizarEquipo_NoExistente() {
    // Arrange
    Long id = 1L;
    EquiposComputoEntity equipo = new EquiposComputoEntity();
    equipo.setId(1l);
    equipo.setNombre("Monitor");
    when(equiposComputoRepository.existsById(id)).thenReturn(false);

    // Act
    EquiposComputoEntity result = equiposComputoService.actualizarEquipo(id, equipo);

    // Assert
    assertEquals(null, result);
  }

  @Test
  void testEliminarEquipo() {
    // Arrange
    Long id = 1L;

    // Act
    equiposComputoService.eliminarEquipo(id);

    // Assert
    verify(equiposComputoRepository, times(1)).deleteById(id);
  }
}