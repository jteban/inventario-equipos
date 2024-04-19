package ol.software.inventario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "equipos_computo")
@Getter
@Setter
public class EquiposComputoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @ManyToOne
  @JoinColumn(name = "usuarios")
  private UsuarioEntity usuarios;

  @ManyToOne
  @JoinColumn(name = "area_id")
  private AreaEntity areas;

  @ManyToOne
  @JoinColumn(name = "estado")
  private EstadoEntity estado;

  @ManyToOne
  @JoinColumn(name = "tipo_dispositivo_id")
  private TipoDispositivoEntity tipoDispositivo;

  @ManyToOne
  @JoinColumn(name = "fabricante_id")
  private FabricanteDispositivoEntity fabricante;

  @ManyToOne
  @JoinColumn(name = "modelo_id")
  private ModeloDispositivoEntity modelo;

  @Column(name = "numero_serie")
  private String nroSerie;

  //FIXME revisar secuencia desde bd
  @Column(name = "numero_inventario")
  private String nroInventario;

  @Column(name = "comentarios")
  private String comentarios;

}
