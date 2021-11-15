/**  
 * @Title:  PlanRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:48:08 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.Plan;

/**
 * @ClassName: PlanRepository
 * @Description: Repository para la clase Plan
 * @author: Reyes98
 * @date: 19/09/2021 9:48:08 a. m.
 * @Copyright: USB
 */
public interface PlanRepository extends JpaRepository<Plan, Long> {

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

}
