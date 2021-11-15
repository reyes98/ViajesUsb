/**  
 * @Title:  DetallePlanService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:54:42 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.usbcali.viajesusb.domain.DetallePlan;
import co.edu.usbcali.viajesusb.dto.DetallePlanDTO;

/**
 * @ClassName: DetallePlanService
 * @Description: Service de DetallePlan
 * @author: Reyes98
 * @date: 19/09/2021 9:54:42 a. m.
 * @Copyright: USB
 */
public interface DetallePlanService {
	
	/**   
	 * @Title: findByEstado   
	 * @Description: TODO 
	 * @param: @param estado
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Page<DetallePlan>      
	 * @throws   
	 */
	public Page<DetallePlan> findByEstado(String estado, Pageable pageable) throws SQLException;

	/**   
	 * @Title: findByPlanCodigo   
	 * @Description: TODO 
	 * @param: @param codigo
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Page<DetallePlan>      
	 * @throws   
	 */
	public Page<DetallePlan> findByPlanCodigo(String codigo, Pageable pageable ) throws SQLException, Exception;
	
	/**   
	 * @Title: findByDestinoCodigo   
	 * @Description: TODO 
	 * @param: @param codigo
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Page<DetallePlan>      
	 * @throws   
	 */
	public Page<DetallePlan> findByDestinoCodigo(String codigo, Pageable pageable ) throws SQLException, Exception;
	
	/**   
	 * @Title: findById   
	 * @Description: TODO 
	 * @param: @param id
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: DetallePlan      
	 * @throws   
	 */
	public DetallePlan findById(Long id) throws SQLException, Exception;

	/**   
	 * @Title: guardarDetallePlan   
	 * @Description: TODO 
	 * @param: @param detallePlanDTO
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: DetallePlan      
	 * @throws   
	 */
	public DetallePlan guardarDetallePlan(DetallePlanDTO detallePlanDTO) throws SQLException, Exception;

	/**   
	 * @Title: actualizarDetallePlan   
	 * @Description: TODO 
	 * @param: @param detallePlanDTO
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: DetallePlan      
	 * @throws   
	 */
	public DetallePlan actualizarDetallePlan(DetallePlanDTO detallePlanDTO) throws SQLException, Exception;

	/**   
	 * @Title: eliminarDetallePlan   
	 * @Description: TODO 
	 * @param: @param idDepl
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	public void eliminarDetallePlan(Long idDepl) throws SQLException, Exception;
}
