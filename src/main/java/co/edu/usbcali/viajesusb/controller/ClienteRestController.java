/**  
 * @Title:  ClienteRestController.java   
 * @Package co.edu.usbcali.viajesusb.controller   
 * @Description: description   
 * @author: Reyes98    
 * @date:   17/10/2021 11:43:51 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.controller;

import java.text.SimpleDateFormat;
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
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.mapper.ClienteMapper;
import co.edu.usbcali.viajesusb.service.ClienteService;

/**
 * @ClassName: ClienteRestController
 * @Description: TODO
 * @author: Reyes98
 * @date: 17/10/2021 11:43:51 a. m.
 * @Copyright: USB
 */
@RestController
@RequestMapping("/api/cliente")
public class ClienteRestController {
	
	@Autowired
	private ClienteService clienteService;
	@Autowired
	private ClienteMapper clienteMapper;

	@GetMapping("/getClientes")
	public ResponseEntity<?> consultarCliente(@RequestParam("estado") String estado,
			@RequestParam("pageNumber") Integer pageNumber, @RequestParam("limit") Integer limit) {
		try {
			// PageRequest:
			// Primer numero: Es el número de pagina actual, empezando desde cero
			// segundo numero: Es la cantidad de items por pagina
			Pageable pageable = PageRequest.of(pageNumber, limit);
			List<Cliente> listClientes = clienteService.findByEstadoOrderByIdClieAsc(estado, pageable).toList();

			return ResponseEntity.ok().body(clienteMapper.listClienteToListClienteDTO(listClientes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getCliente/correo/{correo}")
	public ResponseEntity<?> consultarClientePorCorreo(@PathVariable("correo") String correo) {
		try {

			Cliente cliente = clienteService.findByCorreoIgnoreCase(correo);

			return ResponseEntity.ok().body(clienteMapper.clienteToClienteDTO(cliente));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getCliente")
	public ResponseEntity<?> consultarClientePorIdentificacion(
			@RequestParam("numeroIdentificacionLike") String numeroIdentificacion) {
		try {

			List<Cliente> clientes = clienteService.findByNumeroIdentificacionLike(numeroIdentificacion);

			return ResponseEntity.ok().body(clienteMapper.listClienteToListClienteDTO(clientes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getClientes/nombre")
	public ResponseEntity<?> consultarClientePorNombre(@RequestParam("nombre") String nombre) {
		try {

			List<Cliente> clientes = clienteService.findByNombreLikeIgnoreCase(nombre);

			return ResponseEntity.ok().body(clienteMapper.listClienteToListClienteDTO(clientes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getClientes/fechaNacimientoEntre")
	public ResponseEntity<?> consultarClientePorFechaNacimiento(@RequestParam("fechaFrom") String fechaFrom,
			@RequestParam("fechaTo") String fechaTo) {
		try {

			List<Cliente> clientes = clienteService.findByFechaNacimientoBetween(
					new SimpleDateFormat("yyyy-MM-dd").parse(fechaFrom),
					new SimpleDateFormat("yyyy-MM-dd").parse(fechaTo));

			return ResponseEntity.ok().body(clienteMapper.listClienteToListClienteDTO(clientes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getClientesCount")
	public ResponseEntity<?> countClientes(@RequestParam("estado") String estado) {
		try {
			return ResponseEntity.ok().body(clienteService.countClientesByEstado(estado));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getCliente/tipoIdentificacion")
	public ResponseEntity<?> consultarClientePorTipoIdentificacion(@RequestParam("codigo") String codigo) {
		try {

			List<Cliente> clientes = clienteService.findByTipoIdentificacionCodigo(codigo);

			return ResponseEntity.ok().body(clienteMapper.listClienteToListClienteDTO(clientes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getClientes/apellido")
	public ResponseEntity<?> consultarClientesPorApellido(@RequestParam("apellido") String apellido) {
		try {

			List<Cliente> clientes = clienteService.findByPrimerApellidoContainsOrSegundoApellidoContains(apellido);

			return ResponseEntity.ok().body(clienteMapper.listClienteToListClienteDTO(clientes));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@GetMapping("/getClientes/filtros")
	public ResponseEntity<?> consultarClientesPorFiltros(@RequestParam("estado") String estado,
			@RequestParam("identificacion") String identificacion, @RequestParam("idTiid") Long idTiid,
			@RequestParam("nombre") String nombre) {
		try {

			return ResponseEntity.ok()
					.body(clienteService.consultarClientePorFiltros(estado, identificacion, idTiid, nombre));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@PostMapping("/guardarCliente")
	public ResponseEntity<?> guardarCliente(@RequestBody ClienteDTO clienteDTO) {
		try {
			Cliente cliente = clienteService.guardarCliente(clienteDTO);

			return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@PutMapping("/actualizarCliente")
	public ResponseEntity<?> actualizarCliente(@RequestBody ClienteDTO clienteDTO) {
		try {
			Cliente cliente = clienteService.actualizarCliente(clienteDTO);

			return ResponseEntity.ok(clienteMapper.clienteToClienteDTO(cliente));

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

	@DeleteMapping("/eliminarCliente/{idClie}")
	public ResponseEntity<?> eliminarCliente(@PathVariable("idClie") Long idClie) {
		try {
			clienteService.eliminarCliente(idClie);

			return ResponseEntity.ok("cliente " + idClie + " eliminado exitosamente");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.toString());
		}
	}

}
