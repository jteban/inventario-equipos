package ol.software.inventario.controller;

import ol.software.inventario.entity.AreaEntity;
import ol.software.inventario.service.AreaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AreaControllerTest {

  @Mock
  private AreaService areaService;

  @InjectMocks
  private AreaController areaController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testObtenerTodasLasAreas() {
    // Arrange
    List<AreaEntity> areas = new ArrayList<>();
    when(areaService.obtenerTodasLasAreas()).thenReturn(areas);

    // Act
    List<AreaEntity> result = areaController.obtenerTodasLasAreas();

    // Assert
    assertEquals(areas, result);
  }

  @Test
  void testObtenerAreaPorId() {
    // Arrange
    Long id = 1L;
    AreaEntity area = new AreaEntity();
    when(areaService.obtenerAreaPorId(id)).thenReturn(area);

    // Act
    AreaEntity result = areaController.obtenerAreaPorId(id);

    // Assert
    assertEquals(area, result);
  }

  @Test
  void testCrearArea() {
    // Arrange
    AreaEntity area = new AreaEntity();
    when(areaService.crearArea(area)).thenReturn(area);

    // Act
    ResponseEntity<AreaEntity> response = areaController.crearArea(area);

    // Assert
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(area, response.getBody());
  }

  @Test
  void testActualizarArea() {
    // Arrange
    Long id = 1L;
    AreaEntity area = new AreaEntity();
    when(areaService.actualizarArea(id, area)).thenReturn(area);

    // Act
    ResponseEntity<AreaEntity> response = areaController.actualizarArea(id, area);

    // Assert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(area, response.getBody());
  }

  @Test
  void testEliminarArea() {
    // Arrange
    Long id = 1L;

    // Act
    ResponseEntity<Void> response = areaController.eliminarArea(id);

    // Assert
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    verify(areaService, times(1)).eliminarArea(id);
  }
}