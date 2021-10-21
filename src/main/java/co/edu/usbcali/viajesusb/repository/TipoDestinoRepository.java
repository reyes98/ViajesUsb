/**  
 * @Title:  TipoDestinoRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Reyes98    
 * @date:   4/09/2021 1:23:48 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.usbcali.viajesusb.domain.TipoDestino;

/**   
 * @ClassName:  TipoDestinoRepository   
 * @Description: TODO   
 * @author: Sebastián Reyes     
 * @date:   31/08/2021 11:19:36 a. m.      
 * @Copyright:  USB
 */
public interface TipoDestinoRepository extends JpaRepository<TipoDestino, Long> {

	
	/**   
	 * @Title: findByCodigo   
	 * @Description: 
	 * @param: @param codigo
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: TipoDestino      
	 * @throws   
	 */
	public TipoDestino findByCodigo(String codigo) throws SQLException, Exception;
	
	/**   
	 * @Title: findByCodigoAndEstado   
	 * @Description: TODO 
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: TipoDestino      
	 * @throws   
	 */
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws SQLException, Exception;
	
	/**   
	 * @Title: findByestado   
	 * @Description: TODO 
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<TipoDestino>      
	 * @throws   
	 */
	public List<TipoDestino> findByEstadoOrderByNombre(String estado) throws SQLException, Exception;
	
}