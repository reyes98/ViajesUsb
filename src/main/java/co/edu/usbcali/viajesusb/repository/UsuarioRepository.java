/**  
 * @Title:  UsuarioRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:50:43 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.Usuario;

/**   
 * @ClassName:  UsuarioRepository   
 * @Description: Repositorio de la Clase Usuario  
 * @author: Reyes98   
 * @date:   19/09/2021 9:50:43 a. m.      
 * @Copyright:  USB
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
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
	

}
