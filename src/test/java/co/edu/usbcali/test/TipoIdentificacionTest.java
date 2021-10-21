/**  
 * @Title:  TipoIdentificacionTest.java   
 * @Package co.edu.usbcali.test   
 * @Description: description   
 * @author: Reyes98    
 * @date:   5/09/2021 10:47:34 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.service.TipoIdentificacionService;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**   
 * @ClassName:  TipoIdentificacionTest   
 * @Description: JunitTest TipoIdentificacion
 * @author: Reyes98   
 * @date:   5/09/2021 10:47:34 a. m.      
 * @Copyright:  USB
 */
@SpringBootTest
class TipoIdentificacionTest {
	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;
	
	@Test
	@Transactional
	void debeConsultarLosTipoDeIdentificacionPorEstadoOrdenadoAsc() {
		
		List<TipoIdentificacion> tipoIdentificaciones = null;
		
		try {
			
			tipoIdentificaciones = tipoIdentificacionService.findByEstadoOrderByNombreAsc("A");
			
			for (TipoIdentificacion ti : tipoIdentificaciones) {
				System.out.println(ti.getNombre());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	@Test
	@Transactional
	void debeConsultarLosTipoDeIdentificacionPorCodigoYEstado() {
		
		TipoIdentificacion tipoIdentificacion = null;
		
		try {
			
			tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado("CC","A");			
			
			System.out.println(tipoIdentificacion.getCodigo()+" - "+tipoIdentificacion.getNombre());		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional
	@Rollback(false)
	void debeGuardarTipoIdentificacion() {

		try {
			TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
//			tipoIdentificacionDTO.setIdTiid(26L);

			tipoIdentificacionDTO.setCodigo("LIC");
			tipoIdentificacionDTO.setNombre("LICENCIA DE CONDUCCIÓN");
			tipoIdentificacionDTO.setEstado(Constantes.ACTIVO);

			tipoIdentificacionDTO.setFechaCreacion(Constantes.ahora());
			tipoIdentificacionDTO.setUsuCreador("JSREYES");

			tipoIdentificacionService.guardarTipoIdentificacion(tipoIdentificacionDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeActualizarTipoIdentificacion() {

		try {
			TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();

			tipoIdentificacionDTO.setIdTiid(8L);

			tipoIdentificacionDTO.setCodigo("LIC");
			tipoIdentificacionDTO.setNombre("LICENCIA DE CONDUCCIÓN ESTADOUNIDENSE");
			tipoIdentificacionDTO.setEstado(Constantes.ACTIVO);

			tipoIdentificacionDTO.setFechaModificacion(Constantes.ahora());
			tipoIdentificacionDTO.setUsuModificador("JSREYES");

			tipoIdentificacionService.actualizarTipoIdentificacion(tipoIdentificacionDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	@Transactional
	@Rollback(false)
	void debeEliminarIdentificacion() {

		try {


			tipoIdentificacionService.eliminarTipoIdentificacion(8L);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Test
//	void test() {
//		fail("Not yet implemented");
//	}

}
