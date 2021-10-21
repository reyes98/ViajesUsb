/**  
 * @Title:  TipoIdentificacionServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   13/09/2021 9:48:24 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;
import co.edu.usbcali.viajesusb.repository.TipoIdentificacionRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**
 * @ClassName: TipoIdentificacionServiceImpl
 * @Description: Validaciones de TipoIdentificacionServiceImpl
 * @author: Reyes98
 * @date: 13/09/2021 9:48:24 a. m.
 * @Copyright: USB
 */
@Service
public class TipoIdentificacionServiceImpl implements TipoIdentificacionService {

	@Autowired
	private TipoIdentificacionRepository tipoIdentificacionRepository;
	
	@Autowired
	private ClienteService clienteService;

	/**
	 * <p>
	 * Title: findByEstadoOrderByNombreAsc
	 * </p>
	 * <p>
	 * Description: Consulta por estado y ordena por nombre de manera ascendente
	 * </p>
	 * 
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#findByEstadoOrderByNombreAsc(java.lang.String)
	 */
	@Override
	public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado) throws SQLException, Exception {
		// Verificando contenido
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado está vacio!");
		} else {
			// Verificando estado
			if (!(estado.equalsIgnoreCase("A") || estado.equalsIgnoreCase("I"))) {
				throw new SQLException("El estado solo puede ser 'A'-> activo ó 'I'-> inactivo!");
			}
		}
		return tipoIdentificacionRepository.findByEstadoOrderByNombreAsc(estado);
	}

	/**
	 * <p>
	 * Title: findByCodigoAndEstado
	 * </p>
	 * <p>
	 * Description: Encuentra tipos de identificacion por codigo y estado
	 * </p>
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#findByCodigoAndEstado(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws SQLException, Exception {
		// Verificando contenido
		if (codigo == null || codigo.trim().equals("")) {
			throw new Exception("El código está vacio!");
		}

		// Verificando contenido
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado está vacio!");
		}
		// Verificando estado
		if (!(estado.equalsIgnoreCase(Constantes.ACTIVO) || estado.equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}

		return tipoIdentificacionRepository.findByCodigoAndEstado(codigo, estado);
	}

	/**
	 * <p>
	 * Title: findCodigoTipoIdentificacionByEstado
	 * </p>
	 * <p>
	 * Description: Encuentra codigos y nombre de tipos de identificacion por estado
	 * </p>
	 * 
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#findCodigoTipoIdentificacionByEstado(java.lang.String)
	 */
	@Override
	public List<String[]> findCodigoTipoIdentificacionByEstado(String estado) throws SQLException, Exception {
		// Verificando contenido
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado está vacio!");
		} else {
			// Verificando estado
			if (!(estado.equalsIgnoreCase("A") || estado.equalsIgnoreCase("I"))) {
				throw new SQLException("El estado solo puede ser 'A'-> activo ó 'I'-> inactivo!");
			}
		}
		return tipoIdentificacionRepository.findCodigoTipoIdentificacionByEstado(estado);
	}

	/**
	 * <p>
	 * Title: guardarTipoIdentificacion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoIdentificacionDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#guardarTipoIdentificacion(co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO)
	 */
	@Override
	public TipoIdentificacion guardarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) throws SQLException, Exception {
		TipoIdentificacion tipoIdentificacion = null;
		// Se valida que el tipo identificacion tenga un codigo
		if (tipoIdentificacionDTO.getCodigo() == null || tipoIdentificacionDTO.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un código de tipo identificación válido");
		}

		// Se valida que el codigo tenga máximo 5 caracteres
		if (tipoIdentificacionDTO.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un código de maximo de 5 caracteres");
		}

		// Se consulta si existe un tipo identificación con el codigo ingresado con
		// estado
		// Activo
		TipoIdentificacion tipoIdentificacionBd = findByCodigoAndEstado(tipoIdentificacionDTO.getCodigo(),
				Constantes.ACTIVO);
		if (tipoIdentificacionBd != null) {
			throw new Exception("El tipo identificación con código " + tipoIdentificacionBd.getCodigo() + " ya existe");

		}

		// Se valida que se ingrese el nombre
		if (tipoIdentificacionDTO.getNombre() == null || tipoIdentificacionDTO.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre válido, ej: Cédula de ciudadanía");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (tipoIdentificacionDTO.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// Se valida que se ingrese un usuario creador
		if (tipoIdentificacionDTO.getUsuCreador() == null || tipoIdentificacionDTO.getUsuCreador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario creador");
		}

		if (tipoIdentificacionDTO.getUsuCreador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario creador maximo de 10 caracteres");
		}

		// Verificando contenido
		if (tipoIdentificacionDTO.getEstado() == null) {
			throw new SQLException("El estado está vacío ");
		}

		// Verificando estado
		if (!(tipoIdentificacionDTO.getEstado().equalsIgnoreCase(Constantes.ACTIVO)
				|| tipoIdentificacionDTO.getEstado().equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}

		tipoIdentificacion = new TipoIdentificacion();

		tipoIdentificacion.setIdTiid(tipoIdentificacionDTO.getIdTiid());

		tipoIdentificacion.setCodigo(tipoIdentificacionDTO.getCodigo());
		tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());

		tipoIdentificacion.setEstado(tipoIdentificacionDTO.getEstado());
		tipoIdentificacion.setFechaCreacion(tipoIdentificacionDTO.getFechaCreacion());
		tipoIdentificacion.setUsuCreador(tipoIdentificacionDTO.getUsuCreador());

		tipoIdentificacionRepository.save(tipoIdentificacion);
		
		return tipoIdentificacion;
	}

	/**
	 * <p>
	 * Title: actualizarTipoIdentificacion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoIdentificacionDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#actualizarTipoIdentificacion(co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO)
	 */
	@Override
	public TipoIdentificacion actualizarTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO)
			throws SQLException, Exception {
		TipoIdentificacion tipoIdentificacion = null;
		boolean mismo = false;

		// Se valida que el tipo identificacion tenga un codigo
		if (tipoIdentificacionDTO.getCodigo() == null || tipoIdentificacionDTO.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un código de tipo identificación válido");
		}

		// Se valida que el codigo tenga máximo 5 caracteres
		if (tipoIdentificacionDTO.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un código de maximo de 5 caracteres");
		}

		// Se consulta si existe un tipo identificación con el codigo ingresado con
		// estado
		// Activo
		tipoIdentificacion = findById(tipoIdentificacionDTO.getIdTiid());
		TipoIdentificacion tipoIdentificacionBd = findByCodigoAndEstado(tipoIdentificacionDTO.getCodigo(),
				Constantes.ACTIVO);
		if (tipoIdentificacion == null) {
			throw new SQLException("El tipo de identificación " + tipoIdentificacionDTO.getIdTiid()
					+ " no existe en la Base de datos, debes crearlo primero");
		} else {
			if (tipoIdentificacionBd != null) {
				if (tipoIdentificacionBd.getIdTiid() == tipoIdentificacion.getIdTiid()) {
					mismo = true;
				}
			}
		}
		// Se consulta si existe un tipo de identificación con el codigo ingresado con
		// estado Activo y
		// que no sea el mismo
		if (tipoIdentificacionBd != null && !mismo) {
			throw new Exception("El tipo identificación con código " + tipoIdentificacionBd.getCodigo() + " ya existe");

		}

		// Se valida que se ingrese el nombre
		if (tipoIdentificacionDTO.getNombre() == null || tipoIdentificacionDTO.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre válido, ej: Cédula de ciudadanía");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (tipoIdentificacionDTO.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		/// Se valida que se ingrese un usuario modificador
		if (tipoIdentificacionDTO.getUsuModificador() == null
				|| tipoIdentificacionDTO.getUsuModificador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario modificador");
		}

		if (tipoIdentificacionDTO.getUsuModificador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario modificador maximo de 10 caracteres");
		}

		// Verificando contenido
		if (tipoIdentificacionDTO.getEstado() == null) {
			throw new SQLException("El estado está vacío ");
		}

		// Verificando estado
		if (!(tipoIdentificacionDTO.getEstado().equalsIgnoreCase(Constantes.ACTIVO)
				|| tipoIdentificacionDTO.getEstado().equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}

		// asignamos los valores al objeto
		tipoIdentificacion.setIdTiid(tipoIdentificacionDTO.getIdTiid());

		tipoIdentificacion.setCodigo(tipoIdentificacionDTO.getCodigo());
		tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());

		tipoIdentificacion.setEstado(tipoIdentificacionDTO.getEstado());
		tipoIdentificacion.setFechaModificacion(tipoIdentificacionDTO.getFechaModificacion());
		tipoIdentificacion.setUsuModificador(tipoIdentificacionDTO.getUsuModificador());

		tipoIdentificacionRepository.save(tipoIdentificacion);
		
		return tipoIdentificacion;
	}

	/**
	 * <p>
	 * Title: eliminarTipoIdentificacion
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoIdentificacionDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoIdentificacionService#eliminarTipoIdentificacion(co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO)
	 */
	@Override
	public void eliminarTipoIdentificacion(Long idTiid) throws SQLException, Exception {
		if (idTiid == null) {
			throw new Exception("El id está vacío");
		}

		Optional<TipoIdentificacion> tipoIdentificacionBD = tipoIdentificacionRepository
				.findById(idTiid);
		
		if (tipoIdentificacionBD.isPresent()) {
			TipoIdentificacion ti = tipoIdentificacionBD.get();
			if(!clienteService.findByTipoIdentificacionCodigo(ti.getCodigo()).isEmpty()) {
				throw new Exception("El tipo de identificacion con código '" + ti.getCodigo() + "' tiene registros en otras tablas!");
			}
			tipoIdentificacionRepository.delete(ti);
		} else {
			throw new Exception("El tipo de identificacion " + idTiid + " no existe!");
		}
	}

	public TipoIdentificacion findById(Long idTipo) throws Exception {
		// Validamos el idTipovenga con info
		if (idTipo == null) {
			throw new Exception("Debe ingresar un id De tipo identificacion");
		}

		if (!tipoIdentificacionRepository.findById(idTipo).isPresent()) {
			throw new Exception("El tipo de identificacion con id: " + idTipo + " no existe");
		}

		return tipoIdentificacionRepository.findById(idTipo).get();

	}

}
