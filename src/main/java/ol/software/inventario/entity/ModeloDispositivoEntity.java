package ol.software.inventario.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "modelos_dispositivos")
@Getter
@Setter
public class ModeloDispositivoEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "descripcion")
  private String descripcion;

  @ManyToOne
  @JoinColumn(name = "fabricante_id")
  private FabricanteDispositivoEntity fabricante;

  @OneToMany(mappedBy = "modelo")
  private List<EquiposComputoEntity> equipos;
}
