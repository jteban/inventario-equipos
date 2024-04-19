package ol.software.inventario.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import ol.software.inventario.entity.EquiposComputoEntity;
import ol.software.inventario.service.EquiposComputoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class EquiposComputoControllerTest {

  @Mock
  private EquiposComputoService equiposComputoService;

  @InjectMocks
  private EquiposComputoController equiposComputoController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  void testObtenerTodosLosEquipos() {
    // Arrange
    List<EquiposComputoEntity> equipos = new ArrayList<>();
    when(equiposComputoService.obtenerTodosLosEquipos()).thenReturn(equipos);

    // Act
    List<EquiposComputoEntity> result = equiposComputoController.obtenerTodosLosEquipos();

    // Assert
    assertEquals(equipos, result);
  }

  @Test
  void testObtenerEquipoPorId() {
    // Arrange
    Long id = 1L;
    EquiposComputoEntity equipos = new EquiposComputoEntity();
    when(equiposComputoService.obtenerEquipoPorId(id)).thenReturn(equipos);

    // Act
    EquiposComputoEntity result = equiposComputoController.obtenerEquipoPorId(id);

    // Assert
    assertEquals(equipos, result);
  }

  @Test
  void testCrearEquipo() {
    // Arrange
    EquiposComputoEntity equipos = new EquiposComputoEntity();
    when(equiposComputoService.crearEquipo(equipos)).thenReturn(equipos);

    // Act
    ResponseEntity<EquiposComputoEntity> response = equiposComputoController.crearEquipo(equipos);

    // Assert
    assertEquals(HttpStatus.CREATED, response.getStatusCode());
    assertEquals(equipos, response.getBody());
  }

  @Test
  void testActualizarEquipo() {
    // Arrange
    Long id = 1L;
    EquiposComputoEntity equipos = new EquiposComputoEntity();
    when(equiposComputoService.actualizarEquipo(id, equipos)).thenReturn(equipos);

    // Act
    ResponseEntity<EquiposComputoEntity> response = equiposComputoController.actualizarEquipo(id, equipos);

    // Assert
    assertEquals(HttpStatus.OK, response.getStatusCode());
    assertEquals(equipos, response.getBody());
  }

  @Test
  void testEliminarEquipo() {
    // Arrange
    Long id = 1L;

    // Act
    ResponseEntity<Void> response = equiposComputoController.eliminarEquipo(id);

    // Assert
    assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    verify(equiposComputoService, times(1)).eliminarEquipo(id);
  }

}