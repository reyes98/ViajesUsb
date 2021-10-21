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

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.Plan;

/**   
 * @ClassName:  PlanRepository   
 * @Description: Repository para la clase Plan
 * @author: Reyes98   
 * @date:   19/09/2021 9:48:08 a. m.      
 * @Copyright:  USB
 */
public interface PlanRepository extends JpaRepository<Plan, Long>{

}
