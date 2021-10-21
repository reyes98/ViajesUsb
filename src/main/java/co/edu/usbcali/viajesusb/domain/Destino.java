package co.edu.usbcali.viajesusb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

/**   
 * @ClassName:  Destino
 * @Description: Atributos de un Destino
 * @author: Reyes98   
 * @date:   31/08/2021 1:24:34 p. m.      
 * @Copyright:  USB
 */
@Data
@Entity
@Table(name = "destino")
public class Destino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_dest")
	private Long idDest;
	
	@Column(name="codigo", unique = true, nullable= false, length=5)
	private String codigo;
	
	@Column(name="nombre", unique = false, nullable= false, length=100)
	private String nombre;
	
	@Column(name="descripcion", nullable= false, length=300)
	private String descripcion;
	
	@Column(name="tierra", nullable= false, length=1)
	private String tierra;
	
	@Column(name="aire", nullable= false, length=1)
	private String aire;
	
	@Column(name="mar", nullable= false, length=1)
	private String mar;
	
	@Column(name="fecha_creacion",  nullable= false)
	private Date fechaCreacion;
	
	@Column(name="fecha_modificacion")
	private Date fechaModificacion;
	
	@Column(name="usu_creador",  nullable= false, length=10)
	private String usuCreador;
	
	@Column(name="usu_modificador", length=10)
	private String usuModificador;
	
	@Column(name="estado", nullable= false, length=1)
	private String estado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_tide" , nullable = false)
	private TipoDestino tipoDestino;
	
//	@OneToMany(fetch= FetchType.LAZY, mappedBy="detallePlan")
//	private List<DetallePlan> detallePlan= new ArrayList<>();
		
}
