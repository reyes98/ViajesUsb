/**  
 * @Title:  PlanService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:51:58 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import co.edu.usbcali.viajesusb.domain.Plan;
import co.edu.usbcali.viajesusb.dto.PlanDTO;

/**   
 * @ClassName:  PlanService   
 * @Description: Service de Plan  
 * @author: Reyes98   
 * @date:   19/09/2021 9:51:58 a. m.      
 * @Copyright:  USB
 */
public interface PlanService {
	
	/**
	 * @Title: findByEstado
	 * @Description: TODO
	 * @param: @param  estado
	 * @param: @param  pageable
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: Page<Plan>
	 * @throws
	 */
	public Page<Plan> findByEstado(String estado, Pageable pageable) throws SQLException;

	/**
	 * @Title: findByCodigoAndEstado
	 * @Description: encuantra por código y estado
	 * @param: @param  codigo
	 * @param: @param  estado
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception
	 * @return: Destino
	 * @throws
	 */
	public Plan findByCodigoAndEstado(String codigo, String estado) throws SQLException, Exception;
	
	/**   
	 * @Title: findByClienteNumeroIdentificacion   
	 * @Description: TODO 
	 * @param: @param estado
	 * @param: @param pageable
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: Page<Plan>      
	 * @throws   
	 */
	public Page<Plan> findByClienteNumeroIdentificacion(String numeroIdentificacion, Pageable pageable) throws SQLException;

	/**
	 * @Title: findByDescripcionSolicitudLikeIgnoreCase
	 * @Description: TODO
	 * @param: @param  descripcionSolicitud
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception
	 * @return: List<Plan>
	 * @throws
	 */
	public List<Plan> findByDescripcionSolicitudLikeIgnoreCase(String descripcionSolicitud)
			throws SQLException, Exception;
	
	/**   
	 * @Title: findById   
	 * @Description: TODO 
	 * @param: @param id
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Plan      
	 * @throws   
	 */
	public Plan findById(Long id) throws SQLException, Exception;

	/**   
	 * @Title: guardarPlan   
	 * @Description: TODO 
	 * @param: @param planDTO
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Plan      
	 * @throws   
	 */
	public Plan guardarPlan(PlanDTO planDTO) throws SQLException, Exception;
	

	/**   
	 * @Title: actualizarPlan   
	 * @Description: TODO 
	 * @param: @param planDTO
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: Plan      
	 * @throws   
	 */
	public Plan actualizarPlan(PlanDTO planDTO) throws SQLException, Exception;


	/**   
	 * @Title: eliminarPlan   
	 * @Description: TODO 
	 * @param: @param idPlan
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	public void eliminarPlan(Long idPlan) throws SQLException, Exception;

}
