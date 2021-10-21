package co.edu.usbcali.viajesusb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import lombok.Data;

/**   
 * @ClassName:  Cliente   
 * @Description: Atributos de un Cliente
 * @author: Reyes98   
 * @date:   31/08/2021 1:24:34 p. m.      
 * @Copyright:  USB
 */
@NamedNativeQueries({
		@NamedNativeQuery(name="Cliente.consultarClientePorFiltros", query="", resultSetMapping="consultarClientePorFiltros")
})
@SqlResultSetMappings({
	@SqlResultSetMapping(name="consultarClientePorFiltros",
			classes= {
					@ConstructorResult(targetClass = ClienteDTO.class,
							columns= {
									@ColumnResult(name="idClie", type= Long.class),
									@ColumnResult(name="numeroIdentificacion", type= String.class),
									@ColumnResult(name="idTiid", type= Long.class),
									@ColumnResult(name="nombre", type= String.class),
									@ColumnResult(name="estado", type= String.class)
									
							}
					)
			}),
})

@Data
@Entity
@Table(name = "cliente")
public class Cliente {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idClie;
	
	@Column(name = "numero_identificacion", unique = true, nullable = false, length= 15)
	private String numeroIdentificacion;
	
	@Column(name = "primer_apellido", nullable = false, length= 100)
	private String primerApellido;
	
	@Column(name = "segundo_apellido", nullable = true, length= 100)
	private String segundoApellido;
	
	@Column(name = "nombre", nullable = false, length= 100)
	private String nombre;
	
	@Column(name = "telefono1", nullable = true, length= 15)
	private String telefono1;
	
	@Column(name = "telefono2", nullable = true, length= 15)
	private String telefono2;
	
	@Column(name = "correo", nullable = true, length= 100)
	private String correo;
	
	@Column(name = "sexo", nullable = false, length= 1)
	private String sexo;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fechaNacimiento;
	
	@Column(name = "fecha_creacion", nullable = false)
	private Date fechaCreacion;
	
	@Column(name = "fecha_modificacion", nullable = true)
	private Date fechaModificacion;
	
	@Column(name = "usu_creador", nullable = false, length = 10)
	private String usuCreador;
	
	@Column(name = "usu_modificador", nullable = true, length = 10)
	private String usuModificador;
	
	@Column(name = "estado", nullable = false, length= 1)
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tiid" , nullable = false)
	private TipoIdentificacion tipoIdentificacion;
	
//	@OneToMany(fetch= FetchType.LAZY, mappedBy="plan")
//	private List<Plan> plan = new ArrayList<>();
}
