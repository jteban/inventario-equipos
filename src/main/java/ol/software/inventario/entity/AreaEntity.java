package ol.software.inventario.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "areas")
@Getter
@Setter
public class AreaEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "descripcion")
  private String descripcion;

  @OneToMany(mappedBy = "areas")
  private List<EquiposComputoEntity> equipos;

  @OneToMany(mappedBy = "area")
  private List<UsuarioEntity> usuarios;

}
