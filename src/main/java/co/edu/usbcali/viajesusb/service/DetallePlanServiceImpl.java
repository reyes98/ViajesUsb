/**  
 * @Title:  DetallePlanServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:55:20 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.DetallePlan;
import co.edu.usbcali.viajesusb.dto.DetallePlanDTO;
import co.edu.usbcali.viajesusb.repository.DetallePlanRepository;

/**
 * @ClassName: DetallePlanServiceImpl
 * @Description: Implementación del servicio de DetallePlan
 * @author: Reyes98
 * @date: 19/09/2021 9:55:20 a. m.
 * @Copyright: USB
 */
@Service
public class DetallePlanServiceImpl implements DetallePlanService {
	@Autowired
	private DetallePlanRepository detallePlanRepository;

	/**   
	 * <p>Title: findByEstado</p>   
	 * <p>Description: </p>   
	 * @param estado
	 * @param pageable
	 * @return
	 * @throws SQLException   
	 * @see co.edu.usbcali.viajesusb.service.DetallePlanService#findByEstado(java.lang.String, org.springframework.data.domain.Pageable)   
	 */
	@Override
	public Page<DetallePlan> findByEstado(String estado, Pageable pageable) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: findByPlanCodigo</p>   
	 * <p>Description: </p>   
	 * @param codigo
	 * @param pageable
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.DetallePlanService#findByPlanCodigo(java.lang.String, org.springframework.data.domain.Pageable)   
	 */
	@Override
	public Page<DetallePlan> findByPlanCodigo(String codigo, Pageable pageable) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: findByDestinoCodigo</p>   
	 * <p>Description: </p>   
	 * @param codigo
	 * @param pageable
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.DetallePlanService#findByDestinoCodigo(java.lang.String, org.springframework.data.domain.Pageable)   
	 */
	@Override
	public Page<DetallePlan> findByDestinoCodigo(String codigo, Pageable pageable) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: guardarDetallePlan</p>   
	 * <p>Description: </p>   
	 * @param detallePlanDTO
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.DetallePlanService#guardarDetallePlan(co.edu.usbcali.viajesusb.dto.DetallePlanDTO)   
	 */
	@Override
	public DetallePlan guardarDetallePlan(DetallePlanDTO detallePlanDTO) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: actualizarDetallePlan</p>   
	 * <p>Description: </p>   
	 * @param detallePlanDTO
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.DetallePlanService#actualizarDetallePlan(co.edu.usbcali.viajesusb.dto.DetallePlanDTO)   
	 */
	@Override
	public DetallePlan actualizarDetallePlan(DetallePlanDTO detallePlanDTO) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/**   
	 * <p>Title: eliminarDetallePlan</p>   
	 * <p>Description: </p>   
	 * @param idDepl
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.DetallePlanService#eliminarDetallePlan(java.lang.Long)   
	 */
	@Override
	public void eliminarDetallePlan(Long idDepl) throws SQLException, Exception {
		// TODO Auto-generated method stub
		
	}

	/**   
	 * <p>Title: findById</p>   
	 * <p>Description: </p>   
	 * @param id
	 * @return
	 * @throws SQLException
	 * @throws Exception   
	 * @see co.edu.usbcali.viajesusb.service.DetallePlanService#findById(java.lang.Long)   
	 */
	@Override
	public DetallePlan findById(Long id) throws SQLException, Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
