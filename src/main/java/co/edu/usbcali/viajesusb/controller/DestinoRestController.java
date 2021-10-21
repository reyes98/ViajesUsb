/**  
 * @Title:  DestinoRestController.java   
 * @Package co.edu.usbcali.viajesusb.controller   
 * @Description: description   
 * @author: Reyes98    
 * @date:   12/10/2021 10:32:25 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.mapper.DestinoMapper;
import co.edu.usbcali.viajesusb.service.DestinoService;

/**   
 * @ClassName:  DestinoRestController   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   12/10/2021 10:32:25 a. m.      
 * @Copyright:  USB
 */
@RestController
@RequestMapping("/api/destino")
public class DestinoRestController {
	@Autowired
	private DestinoService destinoService;
	@Autowired
	private DestinoMapper destinoMapper;
	
	@PostMapping("/guardarDestino")
	public ResponseEntity<?> guardarDestino(@RequestBody DestinoDTO destinoDTO) {
		try {
			Destino destino = destinoService.guardarDestino(destinoDTO);
			
			return ResponseEntity.ok(destinoMapper.destinoToDestinoDTO(destino));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}		
	}
	
	@DeleteMapping("/eliminarDestino/{id}")
	public ResponseEntity<?> borrarDestino(@PathVariable("id") Long id) {
		try {
			destinoService.eliminarDestino(id);
			
			return ResponseEntity.ok("Se eliminó satisfactoriamente");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}		
	}

}
