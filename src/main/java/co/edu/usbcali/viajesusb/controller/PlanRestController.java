/**  
 * @Title:  PlanRestController.java   
 * @Package co.edu.usbcali.viajesusb.controller   
 * @Description: description   
 * @author: Reyes98    
 * @date:   11/11/2021 5:29:16 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.Plan;
import co.edu.usbcali.viajesusb.dto.PlanDTO;
import co.edu.usbcali.viajesusb.mapper.PlanMapper;
import co.edu.usbcali.viajesusb.service.PlanService;

/**   
 * @ClassName:  PlanRestController   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   11/11/2021 5:29:16 p. m.      
 * @Copyright:  USB
 */
@RestController
@RequestMapping("/api/plan")
public class PlanRestController {
	@Autowired
	private PlanService planService;
	@Autowired
	private PlanMapper planMapper;
	
	@GetMapping("/getPlanes/{id}")
	public ResponseEntity<?> consultarPlan(@PathVariable("id") Long id) {
		try {
		
			Plan plan = planService.findById(id);

			return ResponseEntity.ok().body(planMapper.planToPlanDTO(plan));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}
	
	@PostMapping("/guardarPlan")
	public ResponseEntity<?> guardarPlan(@RequestBody PlanDTO planDTO) {
		try {
			Plan plan = planService.guardarPlan(planDTO);
			
			return ResponseEntity.ok(planMapper.planToPlanDTO(plan));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}		
	}
	
	@PutMapping("/actualizarPlan")
	public ResponseEntity<?> actualizarPlan(@RequestBody PlanDTO planDTO) {
		try {
			Plan plan = planService.actualizarPlan(planDTO);

			return ResponseEntity.ok(planMapper.planToPlanDTO(plan));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}
	
	@DeleteMapping("/eliminarPlan/{id}")
	public ResponseEntity<?> borrarPlan(@PathVariable("id") Long id) {
		try {
			planService.eliminarPlan(id);
			
			return ResponseEntity.ok("Se eliminó satisfactoriamente");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}		
	}

}
