/**  
 * @Title:  TipoDestinoTest.java   
 * @Package co.edu.usbcali.test   
 * @Description: description   
 * @author: Sebastián Reyes     
 * @date:   31/08/2021 11:20:46 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import co.edu.usbcali.viajesusb.service.TipoDestinoService;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**
 * @ClassName: TipoDestinoTest
 * @Description: TODO
 * @author: Sebastián Reyes
 * @date: 31/08/2021 11:20:46 a. m.
 * @Copyright: USB
 */
@SpringBootTest
class TipoDestinoTest {

	@Autowired
	private TipoDestinoService tipoDestinoService;

	@Test
	@Transactional
	void debeConsultarUnTipoDeDestinoPorCodigo() {

		TipoDestino tipoDestino = null;

		try {

			tipoDestino = tipoDestinoService.findByCodigo("PLAYA");
			System.out.println(tipoDestino.getNombre() + " - " + tipoDestino.getNombre());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	void debeConsultarUnTipoDeDestinoPorCodigoEstado() {

		TipoDestino tipoDestino = null;

		try {

			tipoDestino = tipoDestinoService.findByCodigoAndEstado("PLAYA", "A");
			System.out.println(tipoDestino.getNombre());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	void debeConsultarTiposDeDestinoPorEstadoOrdenadosAlfabeticamente() {

		List<TipoDestino> lstTipoDestino = null;

		try {

			lstTipoDestino = tipoDestinoService.findByEstadoOrderByNombre("A");

			for (TipoDestino tipoDestino : lstTipoDestino) {
				System.out.println(tipoDestino.getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeGuardarTipoDestino() {

		try {
			TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();
//			tipoDestinoDTO.setIdTide(26L);

			tipoDestinoDTO.setCodigo("PRPNT");
			tipoDestinoDTO.setNombre("PARAPENTE");
			tipoDestinoDTO.setDescripcion("VUELOS EN PARAPENTE");
			tipoDestinoDTO.setEstado(Constantes.ACTIVO);

			tipoDestinoDTO.setFechaCreacion(Constantes.ahora());
			tipoDestinoDTO.setUsuCreador("JSREYES");

			tipoDestinoService.guardarTipoDestino(tipoDestinoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeActualizarDestino() {

		try {
			TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();

			tipoDestinoDTO.setIdTide(2L);

			tipoDestinoDTO.setCodigo("RIO");
			tipoDestinoDTO.setNombre("RIOS Y QUEBRADAS");
			tipoDestinoDTO.setDescripcion("RIOS Y QUEBRADAS");
			tipoDestinoDTO.setEstado(Constantes.ACTIVO);

			tipoDestinoDTO.setFechaModificacion(Constantes.ahora());
			tipoDestinoDTO.setUsuModificador("JSREYES");

			tipoDestinoService.actualizarTipoDestino(tipoDestinoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeEliminarDestino() {

		try {
			TipoDestinoDTO tipoDestinoDTO = new TipoDestinoDTO();

			tipoDestinoDTO.setIdTide(10L);

			tipoDestinoService.eliminarTipoDestino(tipoDestinoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}