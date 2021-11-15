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
 * @ClassName:  DetallePlan  
 * @Description: Clase modelo de los detalles que tiene un Plan
 * @author: Reyes98   
 * @date:   31/08/2021 1:24:34 p. m.      
 * @Copyright:  USB
 */
@Data
@Entity
@Table(name = "detalle_plan")
public class DetallePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idDepl;
	
	@Column(name = "alimentacion", nullable = false, length= 1)
	private String alimentacion;
	
	@Column(name = "hospedaje", nullable = false, length= 1)
	private String hospedaje;
	
	@Column(name = "transporte", nullable = false, length= 1)
	private String transporte;
	
	@Column(name = "traslados", nullable = false, length= 1)
	private String traslados;
	
	@Column(name = "valor", nullable = false, columnDefinition = "DECIMAL(19,2)")
	private double valor;
	
	@Column(name = "cantidad_noches", nullable = false, length= 4)
	private int cantidadNoches;
	
	@Column(name = "cantidad_dias", nullable = false, length= 4)
	private int cantidadDias;
	
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
	@JoinColumn(name="id_plan" , nullable = false)
	private Plan plan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="id_dest" , nullable = false)
	private Destino destino;
}
