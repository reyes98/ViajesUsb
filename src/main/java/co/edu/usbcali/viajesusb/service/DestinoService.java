/**  
 * @Title:  DestinoService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   7/09/2021 12:18:22 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;

/**   
 * @ClassName:  DestinoService   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   7/09/2021 12:18:22 p. m.      
 * @Copyright:  USB
 */
public interface DestinoService {
	/**   
	 * @Title: findByTipoDestino_Codigo   
	 * @Description: Retorna la lista de destinos dependiendo del tipo destino
	 * @param: @param codigoTipoDestino
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<Destino>      
	 * @throws Exception 
	 * @throws   
	 */
	public List<Destino> findByTipoDestinoCodigo(String codigoTipoDestino) throws SQLException, Exception;

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
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws SQLException, Exception;
	
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
	

	/**   
	 * @Title: guardarDestino   
	 * @Description: Guarda un nuevo destino 
	 * @param: @param destinoDTO
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	public Destino guardarDestino(DestinoDTO destinoDTO) throws SQLException, Exception;
	
	/**   
	 * @Title: actualizarDestino   
	 * @Description: Actualiza la info de un destino 
	 * @param: @param destinoDTO
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	public void actualizarDestino(DestinoDTO destinoDTO) throws SQLException, Exception;

	/**   
	 * @Title: eliminarDestino   
	 * @Description: Elimina un destino 
	 * @param: @param destinoDTO      
	 * @return: void      
	 * @throws   
	 */
	public void eliminarDestino(Long idDestino) throws SQLException, Exception;

}
