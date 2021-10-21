/**  
 * @Title:  DestinoTest.java   
 * @Package co.edu.usbcali.test   
 * @Description: description   
 * @author: Sebastián Reyes     
 * @date:   31/08/2021 11:41:32 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.service.DestinoService;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**
 * @ClassName: DestinoTest
 * @Description: TODO
 * @author: Sebastián Reyes
 * @date: 31/08/2021 11:41:32 a. m.
 * @Copyright: USB
 */
@SpringBootTest
class DestinoTest {

	@Autowired
	private DestinoService destinoService;

	@Test
	@Transactional
	void debeConsultarDestinosPorTipoDestino() {

		List<Destino> lstDestino = null;

		try {

			lstDestino = destinoService.findByTipoDestinoCodigo("PLAYA");

			for (Destino destino : lstDestino) {
				System.out.println(destino.getCodigo() + " - " + destino.getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	void debeConsultarDestinosPorCodigoYEstado() {

		Destino destino = null;

		try {

			destino = destinoService.findByCodigoAndEstado("SAND", "A");

			System.out.println(destino.getCodigo() + " - " + destino.getNombre());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	void debeConsultarDestinosPorEstadoPaginado() {

		Page<Destino> pageDestino = null;

		try {

			// PageRequest:
			// Primer numero: Es el número de pagina actual, empezando desde cero
			// segundo numero: Es la cantidad de items por pagina
			Pageable pageable = PageRequest.of(1, 1);
			pageDestino = destinoService.findByEstado("A", pageable);

			for (Destino destino : pageDestino.getContent()) {
				System.out.println(destino.getCodigo() + " - " + destino.getNombre());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeGuardarDestino() {

		try {
			DestinoDTO destinoDTO = new DestinoDTO();
//			destinoDTO.setIdDest(26L);

			destinoDTO.setAire(Constantes.SI);
			destinoDTO.setTierra(Constantes.NO);
			destinoDTO.setMar(Constantes.SI);

			destinoDTO.setCodigo("PNGTA");
			destinoDTO.setNombre("Piangüita");
			destinoDTO.setDescripcion("Isla de Piangüita en Buenaventura");
			destinoDTO.setEstado(Constantes.ACTIVO);

			destinoDTO.setFechaCreacion(Constantes.ahora());
			destinoDTO.setUsuCreador("JSREYES");

			destinoDTO.setCodigoTipoDestino("PLAYA");
			destinoDTO.setNombreTipoDestino("PLAYA Y MAR");

			destinoDTO.setIdTide(2L);

			destinoService.guardarDestino(destinoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeActualizarDestino() {

		try {
			DestinoDTO destinoDTO = new DestinoDTO();

			destinoDTO.setIdDest(9L);
			destinoDTO.setAire(Constantes.NO);
			destinoDTO.setTierra(Constantes.NO);
			destinoDTO.setMar(Constantes.SI);

			destinoDTO.setCodigo("PIGTA");
			destinoDTO.setNombre("Piangüita");
			destinoDTO.setDescripcion("Isla de Piangüita en Buenaventura");
			destinoDTO.setEstado(Constantes.ACTIVO);

			destinoDTO.setFechaModificacion(Constantes.ahora());
			destinoDTO.setUsuModificador("JSREYES");

			destinoDTO.setCodigoTipoDestino("PLAYA");
			destinoDTO.setNombreTipoDestino("PLAYA Y MAR");

			destinoDTO.setIdTide(2L);
			destinoService.actualizarDestino(destinoDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeEliminarDestino() {

		try {

			destinoService.eliminarDestino(8L);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}