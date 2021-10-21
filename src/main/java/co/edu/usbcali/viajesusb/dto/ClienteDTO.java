/**  
 * @Title:  ClienteDTO.java   
 * @Package co.edu.usbcali.viajesusb.dto   
 * @Description: description   
 * @author: Reyes98    
 * @date:   5/09/2021 10:01:56 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**   
 * @ClassName:  ClienteDTO   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   5/09/2021 10:01:56 a. m.      
 * @Copyright:  USB
 */
@Data
public class ClienteDTO implements Serializable {
	
	/**   
	 * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = 2995595431720510970L;
	private long idClie;
	private String numeroIdentificacion;
	private String primerApellido;
	private String segundoApellido;
	private String nombre;
	private String telefono1;
	private String telefono2;	
	private String correo;
	private String sexo;
	private Date fechaNacimiento;	
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	private Long idTiid;
	private String codigoTipoIdentificacion;
	
	public ClienteDTO(long idClie, String numeroIdentificacion, Long idTiid, String nombre, String estado) {
		super();
		this.idClie = idClie;
		this.numeroIdentificacion = numeroIdentificacion;
		this.idTiid = idTiid;
		this.nombre = nombre;
		this.estado = estado;
	}

	public ClienteDTO() {
		super();
	}
	
	

	
}
