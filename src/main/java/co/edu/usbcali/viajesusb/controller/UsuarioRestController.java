/**  
 * @Title:  UsuarioRestController.java   
 * @Package co.edu.usbcali.viajesusb.controller   
 * @Description: description   
 * @author: Reyes98    
 * @date:   11/11/2021 5:15:01 p. m.   
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.viajesusb.domain.Usuario;
import co.edu.usbcali.viajesusb.dto.UsuarioDTO;
import co.edu.usbcali.viajesusb.mapper.UsuarioMapper;
import co.edu.usbcali.viajesusb.service.UsuarioService;

/**   
 * @ClassName:  UsuarioRestController   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   11/11/2021 5:15:01 p. m.      
 * @Copyright:  USB
 */
@RestController
@RequestMapping("/api/usuario")
public class UsuarioRestController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UsuarioMapper usuarioMapper;
	
	@PostMapping("/autenticacion")
	public ResponseEntity<?> autenticarUsuario(@RequestParam("login") String login, @RequestParam("password") String pwd) {
		try {
		
			Usuario usuario = usuarioService.findByLoginAndPassword(login, pwd);

			return ResponseEntity.ok().body(usuarioMapper.usuarioToUsuarioDTO(usuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}	
	
	@GetMapping("/getUsuarios/{id}")
	public ResponseEntity<?> consultarUsuario(@PathVariable("id") Long id) {
		try {
		
			Usuario usuario = usuarioService.findById(id);

			return ResponseEntity.ok().body(usuarioMapper.usuarioToUsuarioDTO(usuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}
	
	@PostMapping("/guardarUsuario")
	public ResponseEntity<?> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			Usuario usuario = usuarioService.guardarUsuario(usuarioDTO);
			
			return ResponseEntity.ok(usuarioMapper.usuarioToUsuarioDTO(usuario));
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}		
	}
	
	@PutMapping("/actualizarUsuario")
	public ResponseEntity<?> actualizarUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			Usuario usuario = usuarioService.actualizarUsuario(usuarioDTO);

			return ResponseEntity.ok(usuarioMapper.usuarioToUsuarioDTO(usuario));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	public ResponseEntity<?> borrarUsuario(@PathVariable("id") Long id) {
		try {
			usuarioService.eliminarUsuario(id);
			
			return ResponseEntity.ok("Se eliminó satisfactoriamente");
			
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}		
	}

}
