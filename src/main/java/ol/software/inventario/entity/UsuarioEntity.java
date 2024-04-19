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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

  @NotEmpty(message = "Este campo es obligatorio")
  @Column(name = "tipo_id")
  private String tipoId;

  @NotEmpty(message = "Este campo es obligatorio")
  @Digits(integer = 15, fraction = 0, message = "Este campo solo puede contener números")
  @Column(name = "numero_id")
  private String numeroId;

  @NotEmpty(message = "Este campo es obligatorio")
  @Column(name = "primer_nombre")
  private String primerNombre;

  @Column(name = "segundo_nombre")
  private String segundoNombre;

  @NotEmpty(message = "Este campo es obligatorio")
  @Column(name = "primer_apellido")
  private String primerApellido;

  @Column(name = "segundo_apellido")
  private String segundoApellido;

  @NotEmpty(message = "Este campo es obligatorio")
  @Email(message = "Debe ingresar un correo electrónico válido")
  @Column(name = "email")
  private String email;

  @NotEmpty(message = "Este campo es obligatorio")
  @Pattern(regexp = "[0-9]{10}", message = "El teléfono debe tener 10 dígitos numéricos")
  @Column(name = "telefono")
  private String telefono;

  @NotEmpty(message = "Este campo es obligatorio")
  @Column(name = "usuario")
  private String usuario;

  @NotEmpty(message = "Este campo es obligatorio")
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
