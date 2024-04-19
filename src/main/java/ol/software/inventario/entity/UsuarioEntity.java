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
@Table(name = "usuarios")
@Getter
@Setter
public class UsuarioEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "tipo_id")
  private String tipoId;

  @Column(name = "numero_id")
  private String numeroId;

  @Column(name = "primer_nombre")
  private String primerNombre;

  @Column(name = "segundo_nombre")
  private String segundoNombre;

  @Column(name = "primer_apellido")
  private String primerApellido;

  @Column(name = "segundo_apellido")
  private String segundoApellido;

  @Column(name = "email")
  private String email;

  @Column(name = "telefono")
  private String telefono;

  @Column(name = "usuario")
  private String usuario;

  @Column(name = "password")
  private String password;

  @OneToMany(mappedBy = "usuarios")
  private List<EquiposComputoEntity> equipos;

  @ManyToOne
  @JoinColumn(name = "rol_id")
  private RolEntity rol;

  @ManyToOne
  @JoinColumn(name = "area_id")
  private AreaEntity area;

}
