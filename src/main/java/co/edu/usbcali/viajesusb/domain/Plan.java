package co.edu.usbcali.viajesusb.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**   
 * @ClassName:  Plan   
 * @Description: Atributos de un Plan
 * @author: Reyes98   
 * @date:   31/08/2021 1:24:34 p. m.      
 * @Copyright:  USB
 */
@Data
@Entity
@Table(name = "plan")
public class Plan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idPlan;
	
	@Column(name = "codigo", unique = true, nullable = false, length= 5)
	private String codigo;
	
	@Column(name = "nombre", nullable = false, length= 100)
	private String nombre;
	
	@Column(name = "descripcion_solicitud", nullable = true, length= 300)
	private String descripcionSolicitud;
	
	@Column(name = "cantidad_personas", nullable = false, length= 4)
	private int cantidadPersonas;
	
	@Column(name = "fecha_solicitud", nullable = false)
	private Date fechaSolicitud;
	
	@Column(name = "fecha_inicio_viaje", nullable = true)
	private Date fechaInicioViaje;
	
	@Column(name = "fecha_fin_viaje", nullable = true)
	private Date fechaFinViaje;
	
	@Column(name = "valor_total", nullable = false, columnDefinition = "DECIMAL(19,2)")
	private double valorTotal;
	
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
	@JoinColumn(name="id_clie" , nullable = false)
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_usua" , nullable = false)
	private Usuario usuario;
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy="plan")
	public List<DetallePlan> detallePlan = new ArrayList<>();

}
