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
 * @ClassName:  UsuarioDTO   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   1/11/2021 1:32:52 p. m.      
 * @Copyright:  USB
 */
@Data
public class UsuarioDTO implements Serializable {
	
	/**   
	 * @Fields serialVersionUID: TODO (what does this variable mean)   
	 */
	private static final long serialVersionUID = -7084854093652716572L;
	
	private long idUsua;
	private String login;
	private String password;
	private String nombre;
	private String identificacion;
	private Date fechaCreacion;
	private Date fechaModificacion;
	private String usuCreador;
	private String usuModificador;
	private String estado;
	private String codigoTipoIdentificacion;
	
	public UsuarioDTO(long idUsua, String login, String nombre, String estado) {
		super();
		this.idUsua = idUsua;
		this.login = login;
		this.nombre = nombre;
		this.estado = estado;
	}

	public UsuarioDTO() {
		super();
	}
}
