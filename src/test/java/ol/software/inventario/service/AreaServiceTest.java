package ol.software.inventario.service;

import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.repository.AreaRepository;
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

public class AreaServiceTest {

  @Mock
  private AreaRepository areaRepository;

  @InjectMocks
  private AreaService areaService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testObtenerTodasLasAreas() {
    // Arrange
    List<AreaEntity> areas = new ArrayList<>();
    AreaEntity area1 = new AreaEntity();
    area1.setId(1L);
    area1.setDescripcion("Area 1");
    areas.add(area1);

    AreaEntity area2 = new AreaEntity();
    area2.setId(2L);
    area2.setDescripcion("Area 2");
    areas.add(area2);

    when(areaRepository.findAll()).thenReturn(areas);

    // Act
    List<AreaEntity> result = areaService.obtenerTodasLasAreas();

    // Assert
    assertEquals(2, result.size());
    assertEquals("Area 1", result.get(0).getDescripcion());
    assertEquals("Area 2", result.get(1).getDescripcion());
  }

  @Test
  void testObtenerAreaPorId_Existente() {
    // Arrange
    AreaEntity area = new AreaEntity();
    area.setId(1L);
    area.setDescripcion("Sistemas");
    when(areaRepository.findById(area.getId())).thenReturn(Optional.of(area));

    // Act
    AreaEntity result = areaService.obtenerAreaPorId(area.getId());

    // Assert
    assertEquals(area, result);
  }

  @Test
  void testObtenerAreaPorId_NoExistente() {
    // Arrange
    Long id = 1L;
    when(areaRepository.findById(id)).thenReturn(Optional.empty());

    // Act
    AreaEntity result = areaService.obtenerAreaPorId(id);

    // Assert
    assertEquals(null, result);
  }

  @Test
  void testCrearArea() {
    // Arrange
    AreaEntity area = new AreaEntity();
    area.setId(1L);
    area.setDescripcion("Sistemas");
    when(areaRepository.save(area)).thenReturn(area);

    // Act
    AreaEntity result = areaService.crearArea(area);

    // Assert
    assertEquals(area, result);
  }

  @Test
  void testActualizarArea_Existente() {
    // Arrange
    Long id = 1L;
    AreaEntity area = new AreaEntity();
    area.setId(1L);
    area.setDescripcion("Sistemas");
    when(areaRepository.existsById(id)).thenReturn(true);
    when(areaRepository.save(area)).thenReturn(area);

    // Act
    AreaEntity result = areaService.actualizarArea(id, area);

    // Assert
    assertEquals(area, result);
  }

  @Test
  void testActualizarArea_NoExistente() {
    // Arrange
    Long id = 1L;
    AreaEntity area = new AreaEntity();
    area.setId(1L);
    area.setDescripcion("Sistemas");
    when(areaRepository.existsById(id)).thenReturn(false);

    // Act
    AreaEntity result = areaService.actualizarArea(id, area);

    // Assert
    assertEquals(null, result);
  }

  @Test
  void testEliminarArea() {
    // Arrange
    Long id = 1L;

    // Act
    areaService.eliminarArea(id);

    // Assert
    verify(areaRepository, times(1)).deleteById(id);
  }
}