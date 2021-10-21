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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
