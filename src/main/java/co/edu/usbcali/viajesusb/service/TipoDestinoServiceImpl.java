/**  
 * @Title:  TipoDestinoImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   7/09/2021 11:53:15 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;
import co.edu.usbcali.viajesusb.repository.TipoDestinoRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**
 * @ClassName: TipoDestinoImpl
 * @Description: TODO
 * @author: Reyes98
 * @date: 7/09/2021 11:53:15 a. m.
 * @Copyright: USB
 */
@Service
public class TipoDestinoServiceImpl implements TipoDestinoService {

	@Autowired
	private TipoDestinoRepository tipoDestinoRepository;

	/**
	 * <p>
	 * Title: findByCodigo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param codigo
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByCodigo(java.lang.String)
	 */
	@Override
	public TipoDestino findByCodigo(String codigo) throws SQLException, Exception {
		// Verificando contenido
		if (codigo == null || codigo.trim().equals("")) {
			throw new Exception("El código está vacio!");
		}

		return tipoDestinoRepository.findByCodigo(codigo);
	}

	/**
	 * <p>
	 * Title: findByCodigoAndEstado
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param codigo
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByCodigoAndEstado(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public TipoDestino findByCodigoAndEstado(String codigo, String estado) throws SQLException, Exception {
		// Verificando contenido
		if (codigo == null || codigo.trim().equals("")) {
			throw new Exception("El código está vacio!");
		}

		// Verificando contenido
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado está vacio!");
		}
		// Verificando estado
		if (!(estado.equalsIgnoreCase("A") || estado.equalsIgnoreCase("I"))) {
			throw new SQLException("El estado solo puede ser 'A'-> activo ó 'I'-> inactivo!");
		}

		return tipoDestinoRepository.findByCodigoAndEstado(codigo, estado);
	}

	/**
	 * <p>
	 * Title: findByEstadoOrderByNombre
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#findByEstadoOrderByNombre(java.lang.String)
	 */
	@Override
	public List<TipoDestino> findByEstadoOrderByNombre(String estado) throws SQLException, Exception {
		// Verificando contenido
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado está vacio!");
		} else {
			// Verificando estado
			if (!(estado.equalsIgnoreCase(Constantes.ACTIVO) || estado.equalsIgnoreCase(Constantes.INACTIVO))) {
				throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
						+ Constantes.INACTIVO + "'-> inactivo!");
			}
		}

		return tipoDestinoRepository.findByEstadoOrderByNombre(estado);
	}

	/**
	 * <p>
	 * Title: guardarTipoDestino
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoDestinoDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#guardarTipoDestino(co.edu.usbcali.viajesusb.dto.TipoDestinoDTO)
	 */
	@Override
	public TipoDestino guardarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws SQLException, Exception {
		TipoDestino tipoDestino = null;

		// Se valida que el tipo destino tenga un codigo
		if (tipoDestinoDTO.getCodigo() == null || tipoDestinoDTO.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un código de tipo destino válido");
		}

		// Se valida que el codigo tenga máximo 5 caracteres
		if (tipoDestinoDTO.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un código de maximo de 5 caracteres");
		}

		// Se consulta si existe un tipo destino con el codigo ingresado con estado
		// Activo
		TipoDestino tipoDestinoBd = findByCodigoAndEstado(tipoDestinoDTO.getCodigo(), Constantes.ACTIVO);
		if (tipoDestinoBd != null) {
			throw new Exception("El tipo destino con código " + tipoDestinoBd.getCodigo() + " ya existe");

		}

		// Se valida que se ingrese el nombre
		if (tipoDestinoDTO.getNombre() == null || tipoDestinoDTO.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre válido, ej: Playa y Mar");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (tipoDestinoDTO.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// Se valida que se ingrese una descripcion
		if (tipoDestinoDTO.getDescripcion() == null || tipoDestinoDTO.getDescripcion().equals("")) {
			throw new Exception("Debe ingresar una descripción de destino válido");
		}

		// Se valida que la descripción tenga máximo 300 caracteres
		if (tipoDestinoDTO.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripción de maximo de 100 caracteres");
		}

		// Se valida que se ingrese un usuario creador
		if (tipoDestinoDTO.getUsuCreador() == null || tipoDestinoDTO.getUsuCreador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario creador");
		}

		if (tipoDestinoDTO.getUsuCreador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario creador maximo de 10 caracteres");
		}

		// Verificando estado
		if (!(tipoDestinoDTO.getEstado().equalsIgnoreCase(Constantes.ACTIVO)
				|| tipoDestinoDTO.getEstado().equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}
		tipoDestino = new TipoDestino();

		tipoDestino.setIdTide(tipoDestinoDTO.getIdTide());

		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());
		tipoDestino.setNombre(tipoDestinoDTO.getNombre());
		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());
		tipoDestino.setEstado(tipoDestinoDTO.getEstado());

		tipoDestino.setFechaCreacion(tipoDestinoDTO.getFechaCreacion());
		tipoDestino.setUsuCreador(tipoDestinoDTO.getUsuCreador());

		tipoDestinoRepository.save(tipoDestino);

		return tipoDestino;
	}

	/**
	 * <p>
	 * Title: actualizarTipoDestino
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoDestinoDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#actualizarTipoDestino(co.edu.usbcali.viajesusb.dto.TipoDestinoDTO)
	 */
	@Override
	public TipoDestino actualizarTipoDestino(TipoDestinoDTO tipoDestinoDTO) throws SQLException, Exception {
		TipoDestino tipoDestino = null;
		boolean mismo = false;

		// Se valida que el tipo destino sea ingresado
		if (tipoDestinoDTO == null || tipoDestinoDTO.getIdTide() == null) {
			throw new Exception("Debe ingresar un Tipo Destino para actualizar");
		}
		// Se valida que el destino tenga un codigo
		if (tipoDestinoDTO.getCodigo() == null || tipoDestinoDTO.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un código de Tipo Destino");
		}

		// Se valida que el codigo tenga máximo 5 caracteres
		if (tipoDestinoDTO.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un código de maximo de 5 caracteres");
		}

		tipoDestino = findById(tipoDestinoDTO.getIdTide());
		TipoDestino tipoDestinoBd = findByCodigoAndEstado(tipoDestinoDTO.getCodigo(), Constantes.ACTIVO);
		if (tipoDestino == null) {
			throw new SQLException("El destino " + tipoDestinoDTO.getIdTide()
					+ " no existe en la Base de datos, debes crearlo primero");
		} else {
			if (tipoDestinoBd != null) {
				if (tipoDestinoBd.getIdTide() == tipoDestino.getIdTide()) {
					mismo = true;
				}
			}
		}

		// Se consulta si existe un destino con el codigo ingresado con estado Activo y
		// que no sea el mismo
		if (tipoDestinoBd != null && !mismo) {
			throw new Exception("El destino con código " + tipoDestinoBd.getCodigo() + " ya existe");
		}

		// Se valida que se ingrese el nombre
		if (tipoDestinoDTO.getNombre() == null || tipoDestinoDTO.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre de destino válido");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (tipoDestinoDTO.getCodigo().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// Se valida que se ingrese una descripcion
		if (tipoDestinoDTO.getDescripcion() == null || tipoDestinoDTO.getDescripcion().equals("")) {
			throw new Exception("Debe ingresar una descripción del tipo destino válido");
		}

		// Se valida que la descripción tenga máximo 300 caracteres
		if (tipoDestinoDTO.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripción de maximo de 100 caracteres");
		}

		// Se valida que se ingrese un usuario modificador
		if (tipoDestinoDTO.getUsuModificador() == null || tipoDestinoDTO.getUsuModificador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario modificador");
		}

		if (tipoDestinoDTO.getUsuModificador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario modificador maximo de 10 caracteres");
		}
		// Verificando estado
		if (!(tipoDestinoDTO.getEstado().equalsIgnoreCase(Constantes.ACTIVO)
				|| tipoDestinoDTO.getEstado().equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}

		// asignar datos al objeto
		tipoDestino.setIdTide(tipoDestinoDTO.getIdTide());

		tipoDestino.setCodigo(tipoDestinoDTO.getCodigo());
		tipoDestino.setNombre(tipoDestinoDTO.getNombre());
		tipoDestino.setDescripcion(tipoDestinoDTO.getDescripcion());
		tipoDestino.setEstado(tipoDestinoDTO.getEstado());

		tipoDestino.setFechaModificacion(tipoDestinoDTO.getFechaModificacion());
		tipoDestino.setUsuModificador(tipoDestinoDTO.getUsuModificador());

		tipoDestinoRepository.save(tipoDestino);
		return tipoDestino;

	}

	/**
	 * <p>
	 * Title: eliminarTipoDestino
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param tipoDestinoDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.TipoDestinoService#eliminarTipoDestino(co.edu.usbcali.viajesusb.dto.TipoDestinoDTO)
	 */
	@Override
	public void eliminarTipoDestino(Long id) throws SQLException, Exception {
		if (id == null) {
			throw new Exception("El destino está vacío");
		}

		Optional<TipoDestino> destinoBD = tipoDestinoRepository.findById(id);

		if (destinoBD.isPresent()) {
			tipoDestinoRepository.delete(destinoBD.get());
		} else {
			throw new SQLException("El destino " + id + " no existe!");
		}
	}

	/**
	 * @Title: findById
	 * @Description: TODO
	 * @param: @param  idTipo
	 * @param: @return
	 * @param: @throws Exception
	 * @return: TipoDestino
	 * @throws
	 */
	public TipoDestino findById(Long idTipo) throws Exception {

		// Validamos el idTipovenga con info
		if (idTipo == null) {
			throw new Exception("Debe ingresar un id De tipo destino");
		}

		if (!tipoDestinoRepository.findById(idTipo).isPresent()) {
			throw new Exception("El tipo destino con id: " + idTipo + " no existe");
		}

		return tipoDestinoRepository.findById(idTipo).get();

	}

}
