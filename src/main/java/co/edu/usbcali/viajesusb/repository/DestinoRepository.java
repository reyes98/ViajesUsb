/**  
 * @Title:  DestinoRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Reyes98    
 * @date:   4/09/2021 1:21:24 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.Destino;


/**   
 * @ClassName:  DestinoRepository   
 * @Description: TODO   
 * @author: Sebastián Reyes     
 * @date:   31/08/2021 11:41:02 a. m.      
 * @Copyright:  USB
 */
public interface DestinoRepository extends JpaRepository<Destino, Long>{
	

	/**   
	 * @Title: findByTipoDestino_Codigo   
	 * @Description: Retorna la lista de destinos dependiendo del tipo destino
	 * @param: @param codigoTipoDestino
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<Destino>      
	 * @throws   
	 */
	public List<Destino> findByTipoDestino_Codigo(String codigoTipoDestino) throws SQLException;

	/**   
	 * @Title: findByEstado   
	 * @Description: retorna una lista de destinos por estado
	 * @param: @param estado
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: Page<Destino>      
	 * @throws   
	 */
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws SQLException;
	
	/**   
	 * @Title: findByCodigoAndEstado   
	 * @Description: encuantra por código y estado
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Destino      
	 * @throws   
	 */
	public Destino findByCodigoAndEstado(String codigo, String estado) throws SQLException, Exception;

}
