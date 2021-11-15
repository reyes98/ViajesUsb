/**  
 * @Title:  UsuarioService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:57:17 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;

import co.edu.usbcali.viajesusb.domain.Usuario;
import co.edu.usbcali.viajesusb.dto.UsuarioDTO;

/**   
 * @ClassName:  UsuarioService   
 * @Description: Service de Usuario 
 * @author: Reyes98   
 * @date:   19/09/2021 9:57:17 a. m.      
 * @Copyright:  USB
 */
public interface UsuarioService {
	
	/**   
	 * @Title: findByLogin   
	 * @Description: TODO 
	 * @param: @param login
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Usuario      
	 * @throws   
	 */
	public List<Usuario> findByLogin(String login) throws SQLException, Exception;
	

	/**   
	 * @Title: findByLoginAndPassword   
	 * @Description: TODO 
	 * @param: @param login
	 * @param: @param password
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Usuario      
	 * @throws   
	 */
	public Usuario findByLoginAndPassword(String login, String password) throws SQLException, Exception;
	
	/**   
	 * @Title: findByIdentificacion   
	 * @Description: TODO 
	 * @param: @param identificacion
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: List<Usuario>      
	 * @throws   
	 */
	public List<Usuario> findByIdentificacion(String identificacion) throws SQLException, Exception;
	
	/**   
	 * @Title: findByNombre   
	 * @Description: TODO 
	 * @param: @param nombre
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: List<Usuario>      
	 * @throws   
	 */
	public List<Usuario> findByNombreLikeIgnoreCase(String nombre) throws SQLException, Exception;
	
	/**   
	 * @Title: findById   
	 * @Description: TODO 
	 * @param: @param id
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Usuario      
	 * @throws   
	 */
	public Usuario findById(Long id) throws SQLException, Exception;
	
	/**   
	 * @Title: guardarUsuario   
	 * @Description: TODO 
	 * @param: @param usuarioDTO
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Usuario      
	 * @throws   
	 */
	public Usuario guardarUsuario(UsuarioDTO usuarioDTO) throws SQLException, Exception;
	
	/**   
	 * @Title: actualizarCliente   
	 * @Description: TODO 
	 * @param: @param usuarioDTO
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Usuario      
	 * @throws   
	 */
	public Usuario actualizarUsuario(UsuarioDTO usuarioDTO) throws SQLException, Exception;

	/**   
	 * @Title: eliminarUsuario   
	 * @Description: TODO 
	 * @param: @param idUsua
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	public void eliminarUsuario(Long idUsua) throws SQLException, Exception;

}
