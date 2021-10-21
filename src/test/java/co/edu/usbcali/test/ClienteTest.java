/**  
 * @Title:  ClienteTest.java   
 * @Package co.edu.usbcali.test   
 * @Description: description   
 * @author: Reyes98    
 * @date:   5/09/2021 11:13:04 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.service.ClienteService;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**
 * @ClassName: ClienteTest
 * @Description: TODO
 * @author: Reyes98
 * @date: 5/09/2021 11:13:04 a. m.
 * @Copyright: USB
 */
@SpringBootTest
class ClienteTest {
	@Autowired
	private ClienteService clienteService;

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

	@Test
	@Transactional
	void debeConsultarLosClienteaPorEstadoOrdenadoAsc() {
		Page<Cliente> pageCliente = null;
		try {

			// PageRequest:
			// Primer numero: Es el número de pagina actual, empezando desde cero
			// segundo numero: Es la cantidad de items por pagina
			Pageable pageable = PageRequest.of(0, 50);
			pageCliente = clienteService.findByEstadoOrderByIdClieAsc("A", pageable);

			for (Cliente cl : pageCliente.getContent()) {
				System.out.println(cl.getIdClie() + " - " + cl.getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	void debeConsultarClientePorCorreoIgnorandoMayusculaYMinuscula() {
		Cliente cliente = null;
		try {

			cliente = clienteService.findByCorreoIgnoreCase("guApaCha2@hotmail.Com");
			if (cliente != null) {
				System.out.println(cliente.getIdClie() + " - " + cliente.getNombre() + " - " + cliente.getCorreo());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	void debeConsultarClientePorNumeroIdentificacionConLike() {
		List<Cliente> clientes = null;
		try {

			clientes = clienteService.findByNumeroIdentificacionLike("85");

			for (Cliente cliente : clientes) {
				System.out.println(cliente.getIdClie() + " - " + cliente.getNumeroIdentificacion());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	void debeConsultarClientePorNombreConLikeIgnorandoMayusculasYMinusculas() {
		List<Cliente> clientes = null;
		try {

			clientes = clienteService.findByNombreLikeIgnoreCase("juan");

			for (Cliente cliente : clientes) {
				System.out.println(
						cliente.getIdClie() + " - " + cliente.getNumeroIdentificacion() + " - " + cliente.getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	@Transactional
	void debeConsultarClientesPorFechasDeNacimiento() {
		List<Cliente> clientes = null;
//		Calendar fechaActual = Calendar.getInstance();
//		Calendar fechaAntes = new GregorianCalendar(fechaActual.get(Calendar.YEAR) - 24,
//				fechaActual.get(Calendar.MONTH), fechaActual.get(Calendar.DAY_OF_MONTH));

		try {

			clientes = clienteService.findByFechaNacimientoBetween(
					new SimpleDateFormat("yyyy-MM-dd").parse("1980-06-27"),
					new SimpleDateFormat("yyyy-MM-dd").parse("2021-01-01"));

//			clientes = clienteService.findByFechaNacimientoBetween(fechaAntes.getTime(), fechaActual.getTime());

			for (Cliente cliente : clientes) {
				System.out.println(cliente.getIdClie() + " - " + cliente.getFechaNacimiento().toString() + " - "
						+ cliente.getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	void debeContarCuantosClientesPorEstado() {
//		List<String[]> clientes = null;
		try {
//			clientes = clienteService.countTotalClientesByEstado();

//			for (String[] cliente : clientes) {
//				System.out.println(cliente[0] + " - " + cliente[1]);
//			}

			System.out.println(clienteService.countClientesByEstado("A"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Test
	@Transactional
	void debeConsultarClientePorTiposDeIdentificacion() {
		List<Cliente> clientes = null;

		try {

			
			clientes = clienteService.findByTipoIdentificacionCodigo("CC");

			for (Cliente cl : clientes) {
				System.out.println(
						cl.getIdClie() + " - " + cl.getNombre() + " - " + cl.getTipoIdentificacion().getCodigo());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	void debeConsultarClientePorTiposDeIdentificacionPaginado() {
		Page<Cliente> pageCliente = null;

		try {

			// PageRequest:
			// Primer numero: Es el número de pagina actual, empezando desde cero
			// segundo numero: Es la cantidad de items por pagina
			Pageable pageable = PageRequest.of(0, 2);
			pageCliente = clienteService.findByTipoIdentificacionCodigo("CC", pageable);

			for (Cliente cl : pageCliente.getContent()) {
				System.out.println(
						cl.getIdClie() + " - " + cl.getNombre() + " - " + cl.getTipoIdentificacion().getCodigo());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	void debeConsultarPorPrimerApellidoOPorSegundoApellido() {
		List<Cliente> clientes = null;
		try {

			clientes = clienteService.findByPrimerApellidoContainsOrSegundoApellidoContains("A");

			for (Cliente cliente : clientes) {
				System.out.println(cliente.getIdClie() + " - " + cliente.getNombre() + " - "
						+ cliente.getPrimerApellido() + " - " + cliente.getSegundoApellido());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	void debeConsultarPorFiltros() {
		List<ClienteDTO> clientes = null;
		try {

			clientes = clienteService.consultarClientePorFiltros("A", "1144102785", 1L, "sebas");

			for (ClienteDTO cliente : clientes) {
				System.out.println(cliente.getIdClie() + " - " + cliente.getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeGuardarcliente() {

		try {
			ClienteDTO clienteDTO = new ClienteDTO();
			
			clienteDTO.setNumeroIdentificacion("71627229");
			clienteDTO.setNombre("Sandra");
			clienteDTO.setPrimerApellido("Jimenez");
			clienteDTO.setSegundoApellido("Ruiz");
			clienteDTO.setTelefono1("3156369984");
			clienteDTO.setTelefono2("3153763287");
			clienteDTO.setCorreo("otrocorreo@hotmail.com");
			clienteDTO.setSexo("M");
			clienteDTO.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2000-02-22"));
			
			clienteDTO.setEstado(Constantes.ACTIVO);
			clienteDTO.setFechaCreacion(Constantes.ahora());
			clienteDTO.setUsuCreador("JSREYES");

			clienteDTO.setCodigoTipoIdentificacion("CC");

			clienteService.guardarCliente(clienteDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeActualizarcliente() {

		try {
			ClienteDTO clienteDTO = new ClienteDTO();

			clienteDTO.setIdClie(7L);
			
			clienteDTO.setNumeroIdentificacion("71627229");
			clienteDTO.setNombre("Sandra");
			clienteDTO.setPrimerApellido("Jimenez");
//			clienteDTO.setSegundoApellido("Ruiz");
			clienteDTO.setTelefono1("3156369984");
//			clienteDTO.setTelefono2("3153763287");
			clienteDTO.setCorreo(clienteDTO.getNombre()+"@hotmail.com");
			clienteDTO.setSexo("M");
			clienteDTO.setFechaNacimiento(new SimpleDateFormat("yyyy-MM-dd").parse("2000-02-22"));
			
			clienteDTO.setEstado(Constantes.ACTIVO);
			clienteDTO.setFechaModificacion(Constantes.ahora());
			clienteDTO.setUsuModificador("JSREYES");

			clienteDTO.setCodigoTipoIdentificacion("CC");

			clienteService.actualizarCliente(clienteDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeEliminarcliente() {

		try {
			clienteService.eliminarCliente(9L);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
