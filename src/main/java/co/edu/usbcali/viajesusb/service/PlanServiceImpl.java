/**  
 * @Title:  PlanServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:52:34 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Plan;
import co.edu.usbcali.viajesusb.dto.PlanDTO;
import co.edu.usbcali.viajesusb.repository.PlanRepository;

/**   
 * @ClassName:  PlanServiceImpl   
 * @Description: Implementación de los servicios de Plan 
 * @author: Reyes98   
 * @date:   19/09/2021 9:52:34 a. m.      
 * @Copyright:  USB
 */
@Service
public class PlanServiceImpl implements PlanService{
	@Autowired
	private PlanRepository planRepository;

	/**   
	 * <p>Title: findByEstado</p>   
	 * <p>Description: </p>   
	 * @param estado
	 * @param pageable
	 * @return
	 * @throws SQLException   
	 * @see co.edu.usbcali.viajesusb.service.PlanService#findByEstado(java.lang.String, org.springframework.data.domain.Pageable)   
	 */
	@Override
	public Page<Plan> findByEstado(String estado, Pageable pageable) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: findByCodigoAndEstado</p>   
	 * <p>Description: </p>   
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.PlanService#findByCodigoAndEstado(java.lang.String, java.lang.String)   
	 */
	@Override
	public Plan findByCodigoAndEstado(String codigo, String estado) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: findByClienteNumeroIdentificacion</p>   
	 * <p>Description: </p>   
	 * @param numeroIdentificacion
	 * @param pageable
	 * @return
	 * @throws SQLException   
	 * @see co.edu.usbcali.viajesusb.service.PlanService#findByClienteNumeroIdentificacion(java.lang.String, org.springframework.data.domain.Pageable)   
	 */
	@Override
	public Page<Plan> findByClienteNumeroIdentificacion(String numeroIdentificacion, Pageable pageable)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: findByDescripcionSolicitudLikeIgnoreCase</p>   
	 * <p>Description: </p>   
	 * @param descripcionSolicitud
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.PlanService#findByDescripcionSolicitudLikeIgnoreCase(java.lang.String)   
	 */
	@Override
	public List<Plan> findByDescripcionSolicitudLikeIgnoreCase(String descripcionSolicitud)
			throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: guardarPlan</p>   
	 * <p>Description: </p>   
	 * @param planDTO
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.PlanService#guardarPlan(co.edu.usbcali.viajesusb.dto.PlanDTO)   
	 */
	@Override
	public Plan guardarPlan(PlanDTO planDTO) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: actualizarPlan</p>   
	 * <p>Description: </p>   
	 * @param planDTO
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.PlanService#actualizarPlan(co.edu.usbcali.viajesusb.dto.PlanDTO)   
	 */
	@Override
	public Plan actualizarPlan(PlanDTO planDTO) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: eliminarPlan</p>   
	 * <p>Description: </p>   
	 * @param idPlan
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.PlanService#eliminarPlan(java.lang.Long)   
	 */
	@Override
	public void eliminarPlan(Long idPlan) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * <p>Title: findById</p>   
	 * <p>Description: </p>   
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.PlanService#findById(java.lang.Long)   
	 */
	@Override
	public Plan findById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
