/**  
 * @Title:  TipoDestinoService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   7/09/2021 11:50:56 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;

/**   
 * @ClassName:  TipoDestinoService   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   7/09/2021 11:50:56 a. m.      
 * @Copyright:  USB
 */
public interface TipoDestinoService {

	/**   
	 * @Title: findByCodigo   
	 * @Description: Encuentra por código
	 * @param: @param codigo
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoDestino      
	 * @throws   
	 */
	public TipoDestino findByCodigo(String codigo) throws SQLException, Exception;
	
	/**   
	 * @Title: findByCodigoAndEstado   
	 * @Description: Consulta por tipo destino y estado
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoDestino      
	 * @throws   
	 */
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws SQLException, Exception;
	
	/**   
	 * @Title: findByEstadoOrderByNombre   
	 * @Description: Lista por estado o nombre
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<TipoDestino>      
	 * @throws   
	 */
	public List<TipoDestino> findByEstadoOrderByNombre(String estado) throws SQLException, Exception;
	
	/**   
	 * @Title: guardarDestino   
	 * @Description: Guarda un nuevo TipoDestino 
	 * @param: @param destinoDTO
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	public TipoDestino guardarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws SQLException, Exception;
	
	/**   
	 * @Title: actualizarDestino   
	 * @Description: Actualiza la info de un destino 
	 * @param: @param destinoDTO
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	public TipoDestino actualizarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws SQLException, Exception;

	/**   
	 * @Title: eliminarDestino   
	 * @Description: Elimina un destino 
	 * @param: @param destinoDTO      
	 * @return: void      
	 * @throws   
	 */
	public void eliminarTipoDestino(Long id) throws SQLException, Exception;
}
