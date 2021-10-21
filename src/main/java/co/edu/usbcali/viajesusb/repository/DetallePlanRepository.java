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

}
