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

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.mapper.DestinoMapper;
import co.edu.usbcali.viajesusb.service.DestinoService;

/**
 * @ClassName: DestinoRestController
 * @Description: TODO
 * @author: Reyes98
 * @date: 12/10/2021 10:32:25 a. m.
 * @Copyright: USB
 */
@RestController
@RequestMapping("/api/destino")
public class DestinoRestController {
	@Autowired
	private DestinoService destinoService;
	@Autowired
	private DestinoMapper destinoMapper;

	@GetMapping("/getDestinos")
	public ResponseEntity<?> consultarDestinos(@RequestParam(value = "estado", required = false) String estado,
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") Integer pageNumber,
			@RequestParam(value = "limit", required = false, defaultValue = "10") Integer limit) {
		try {
			// PageRequest:
			// Primer numero: Es el número de pagina actual, empezando desde cero
			// segundo numero: Es la cantidad de items por pagina
			Pageable pageable = PageRequest.of(pageNumber, limit);
			List<Destino> listDestinos = null;
			if (estado == null) {
				listDestinos = destinoService.listar(pageable).toList();
			} else {
				listDestinos = destinoService.findByEstado(estado, pageable).toList();
			}

			return ResponseEntity.ok().body(destinoMapper.listDestinoToListDestnoDTO(listDestinos));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getDestinos/{id}")
	public ResponseEntity<?> consultarDestinos(@PathVariable("id") Long id) {
		try {

			Destino destino = destinoService.findById(id);

			return ResponseEntity.ok().body(destinoMapper.destinoToDestinoDTO(destino));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@PostMapping("/guardarDestino")
	public ResponseEntity<?> guardarDestino(@RequestBody DestinoDTO destinoDTO) {
		try {
			Destino destino = destinoService.guardarDestino(destinoDTO);

			return ResponseEntity.ok(destinoMapper.destinoToDestinoDTO(destino));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@PutMapping("/actualizarDestino")
	public ResponseEntity<?> actualizarDestino(@RequestBody DestinoDTO destinoDTO) {
		try {
			Destino destino = destinoService.actualizarDestino(destinoDTO);

			return ResponseEntity.ok(destinoMapper.destinoToDestinoDTO(destino));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@DeleteMapping("/eliminarDestino/{id}")
	public ResponseEntity<?> borrarDestino(@PathVariable("id") Long id) {
		try {
			destinoService.eliminarDestino(id);

			return ResponseEntity.ok("Se eliminó satisfactoriamente");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

}
