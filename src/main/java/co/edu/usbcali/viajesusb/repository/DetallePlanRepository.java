/**  
 * @Title:  DetallePlanRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:49:48 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.DetallePlan;

/**   
 * @ClassName:  DetallePlanRepository   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   19/09/2021 9:49:48 a. m.      
 * @Copyright:  USB
 */
public interface DetallePlanRepository extends JpaRepository<DetallePlan, Long>{
	
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


}
