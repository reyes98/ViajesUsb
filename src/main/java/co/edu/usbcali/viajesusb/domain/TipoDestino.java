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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**   
 * @ClassName:  Cliente   
 * @Description: Clase modelo de los tipos de destinos que tiene un Destino
 * @author: Reyes98   
 * @date:   31/08/2021 1:24:34 p. m.      
 * @Copyright:  USB
 */


@Data
@Entity
@Table(name = "tipo_destino")
public class TipoDestino {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_tide")
	private Long idTide;
	
	@Column(name="codigo", unique = true, nullable= false, length=5)
	private String codigo;
	
	@Column(name="nombre", unique = true, nullable= false, length=100)
	private String nombre;
	
	@Column(name="descripcion", nullable= false, length=300)
	private String descripcion;
	
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
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy="tipoDestino")
	private List<Destino> destino = new ArrayList<>();
	
}
