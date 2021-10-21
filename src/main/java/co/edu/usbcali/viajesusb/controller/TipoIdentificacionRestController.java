/**  
 * @Title:  TipoIdentificacionRestController.java   
 * @Package co.edu.usbcali.viajesusb.controller   
 * @Description: description   
 * @author: Reyes98    
 * @date:   17/10/2021 11:44:17 a. m.   
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

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.mapper.TipoIdentificacionMapper;
import co.edu.usbcali.viajesusb.service.TipoIdentificacionService;

/**
 * @ClassName: TipoIdentificacionRestController
 * @Description: TODO
 * @author: Reyes98
 * @date: 17/10/2021 11:44:17 a. m.
 * @Copyright: USB
 */
@RestController
@RequestMapping("/api/tipoIdentificacion")
public class TipoIdentificacionRestController {
	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;

	@Autowired
	private TipoIdentificacionMapper tipoIdentificacionMapper;

	@GetMapping("/getTipoIdentificacion")
	public ResponseEntity<?> consultarTipoIdentificacionPorEstado(@RequestParam("estado") String estado) {
		try {

			List<TipoIdentificacion> listTipoIdentificacion = tipoIdentificacionService
					.findByEstadoOrderByNombreAsc(estado);

			return ResponseEntity.ok().body(
					tipoIdentificacionMapper.listTipoIdentificacionTolistTipoIdentificacionDTO(listTipoIdentificacion));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getTipoIdentificacion/codigo")
	public ResponseEntity<?> consultarTipoIdentificacionPorCodigo(@RequestParam("estado") String estado,
			@RequestParam("codigo") String codigo) {
		try {

			TipoIdentificacion tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(codigo, estado);

			return ResponseEntity.ok()
					.body(tipoIdentificacionMapper.tipoIdentificacionToTipoIdentificacionDTO(tipoIdentificacion));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getCodigoTipoIdentificacion")
	public ResponseEntity<?> consultarCodigosTipoIdentificacion(@RequestParam("estado") String estado) {
		try {

			List<String[]> lstCodigos = tipoIdentificacionService.findCodigoTipoIdentificacionByEstado(estado);

			return ResponseEntity.ok().body(lstCodigos);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@PostMapping("/guardarTipoIdentificacion")
	public ResponseEntity<?> guardarTipoIdentificacion(@RequestBody TipoIdentificacionDTO tipoIdentificacionDTO) {
		try {
			TipoIdentificacion tipoIdentificacion = tipoIdentificacionService
					.guardarTipoIdentificacion(tipoIdentificacionDTO);

			return ResponseEntity
					.ok(tipoIdentificacionMapper.tipoIdentificacionToTipoIdentificacionDTO(tipoIdentificacion));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@PutMapping("/actualizarTipoIdentificacion")
	public ResponseEntity<?> actualizarTipoIdentificacion(@RequestBody TipoIdentificacionDTO tipoIdentificacionDTO) {
		try {
			TipoIdentificacion tipoIdentificacion = tipoIdentificacionService
					.actualizarTipoIdentificacion(tipoIdentificacionDTO);

			return ResponseEntity
					.ok(tipoIdentificacionMapper.tipoIdentificacionToTipoIdentificacionDTO(tipoIdentificacion));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@DeleteMapping("/eliminarTipoIdentificacion/{idTiid}")
	public ResponseEntity<?> actualizarTipoIdentificacion(@PathVariable Long idTiid) {
		try {
			tipoIdentificacionService.eliminarTipoIdentificacion(idTiid);

			return ResponseEntity.ok("Tipo Identificación " + idTiid + " eliminada exitosamente");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

}
