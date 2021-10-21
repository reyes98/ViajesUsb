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
 * @ClassName:  TipoCliente   
 * @Description: Clase modelo de los tipos de documentos que tiene un Cliente
 * @author: Reyes98   
 * @date:   31/08/2021 1:24:34 p. m.      
 * @Copyright:  USB
 */
@Entity
@Table(name = "tipo_identificacion")
@Data
public class TipoIdentificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idTiid;
	
	@Column(name = "codigo", unique = true, nullable = false, length= 5)
	private String codigo;
	
	@Column(name = "nombre", nullable = false, length= 100)
	private String nombre;
	
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
	
	@OneToMany(fetch= FetchType.LAZY, mappedBy="tipoIdentificacion")
	private List<Cliente> cliente = new ArrayList<>();
	
}
