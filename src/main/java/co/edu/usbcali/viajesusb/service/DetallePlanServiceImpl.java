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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
