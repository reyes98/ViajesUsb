/**  
 * @Title:  DestinoServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   7/09/2021 12:18:58 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;
import co.edu.usbcali.viajesusb.repository.DestinoRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**
 * @ClassName: DestinoServiceImpl
 * @Description: TODO
 * @author: Reyes98
 * @date: 7/09/2021 12:18:58 p. m.
 * @Copyright: USB
 */
@Service
public class DestinoServiceImpl implements DestinoService {
	@Autowired
	private DestinoRepository destinoRepository;

	@Autowired
	private TipoDestinoService tipoDestinoService;

	/**
	 * <p>
	 * Title: findByTipoDestino_Codigo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param codigoTipoDestino
	 * @return
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#findByTipoDestino_Codigo(java.lang.String)
	 */
	@Override
	public List<Destino> findByTipoDestinoCodigo(String codigoTipoDestino) throws Exception, SQLException {
		List<Destino> lstDestino = null;
		if (codigoTipoDestino == null || codigoTipoDestino.trim().equals("")) {
			throw new Exception("Codigo destino vacio!");
		}

		lstDestino = destinoRepository.findByTipoDestino_Codigo(codigoTipoDestino);

		return lstDestino;
	}

	/**
	 * <p>
	 * Title: findByEstado
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @param pageable
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#findByEstado(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Destino> findByEstado(String estado, Pageable pageable) throws SQLException, Exception {
		Page<Destino> pageDestino = null;

		// Verificando contenido
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado está vacio!");
		}

		// Verificando estado
		if (!(estado.equalsIgnoreCase("A") || estado.equalsIgnoreCase("I"))) {
			throw new SQLException("El estado solo puede ser 'A'-> activo ó 'I'-> inactivo!");
		}

		// Verificando contenido del Pageable
		if (pageable == null || pageable.isUnpaged()) {
			throw new Exception("No existe paginación!");
		}
		// Verificando numero de página
		if (pageable.getPageNumber() < 0) {
			throw new Exception("No existe pagina negativa!");
		}
		// Verificando la cantidad de elementos por página
		if (pageable.getPageSize() > 100) {
			throw new SQLException("No puedes paginar más de 100 elementos!");
		}
		// Verificando que la cantidad no sea negativa
		if (pageable.getPageSize() < 0) {
			throw new SQLException("No puedes paginar un número negativo de elementos!");
		}

		// PageRequest:
		// Primer numero: Es el número de pagina actual, empezando desde cero
		// segundo numero: Es la cantidad de items por pagina
		pageDestino = destinoRepository.findByEstado(estado, pageable);

		return pageDestino;

	}

	/**
	 * <p>
	 * Title: guardarDestino
	 * </p>
	 * <p>
	 * Description: Guarda un destino
	 * </p>
	 * 
	 * @param destinoDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#guardarDestino(co.edu.usbcali.viajesusb.dto.DestinoDTO)
	 */
	@Override
	public Destino guardarDestino(DestinoDTO destinoDTO) throws SQLException, Exception {
		Destino destino = null;
		TipoDestino tipoDestino = null;

		// Validamos si el destino está presente
//		if (destinoRepository.findById(destinoDTO.getIdDest()).isPresent()) {
//			throw new SQLException(
//					"El destino " + destinoDTO.getIdDest() + " ya existe en la Base de datos, asigna un id diferente!");
//		}

		// Se valida que el destino tenga un codigo
		if (destinoDTO.getCodigo() == null || destinoDTO.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un código de destino válido");
		}

		// Se valida que el codigo tenga máximo 5 caracteres
		if (destinoDTO.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un código de maximo de 5 caracteres");
		}

		// Se consulta si existe un destino con el codigo ingresado con estado Activo
		Destino destinoBd = findByCodigoAndEstado(destinoDTO.getCodigo(), Constantes.ACTIVO);
		if (destinoBd != null) {
			throw new Exception("El destino con código " + destinoBd.getCodigo() + " ya existe");

		}

		// Se valida que se ingrese el nombre
		if (destinoDTO.getNombre() == null || destinoDTO.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre de destino válido");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (destinoDTO.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// Se valida que se ingrese una descripcion
		if (destinoDTO.getDescripcion() == null || destinoDTO.getDescripcion().equals("")) {
			throw new Exception("Debe ingresar una descripción de destino válido");
		}

		// Se valida que la descripción tenga máximo 300 caracteres
		if (destinoDTO.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripción de maximo de 100 caracteres");
		}

		// Se valida la información de acceso al sitio
		if (destinoDTO.getTierra() == null || destinoDTO.getTierra().equals("") || destinoDTO.getAire() == null
				|| destinoDTO.getAire().equals("") || destinoDTO.getMar() == null || destinoDTO.getMar().equals("")) {
			throw new Exception("Debe ingresar la información completa de acceso transporte");
		}

		// Se valida la información de acceso al sitio
		if (destinoDTO.getTierra().trim().length() > 1 || destinoDTO.getAire().trim().length() > 1
				|| destinoDTO.getMar().trim().length() > 1) {
			throw new Exception("Los campos de acceso al sitio deben ser máximo de un caracter");
		}

		// Se valida que se ingrese un usuario creador
		if (destinoDTO.getUsuCreador() == null || destinoDTO.getUsuCreador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario creador");
		}

		if (destinoDTO.getUsuCreador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario creador maximo de 10 caracteres");
		}

		// Verificando estado
		if (!(destinoDTO.getEstado().equalsIgnoreCase(Constantes.ACTIVO)
				|| destinoDTO.getEstado().equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}
		destino = new Destino();

		destino.setIdDest(destinoDTO.getIdDest());

		destino.setAire(destinoDTO.getAire());
		destino.setTierra(destinoDTO.getTierra());
		destino.setMar(destinoDTO.getMar());

		destino.setCodigo(destinoDTO.getCodigo());
		destino.setNombre(destinoDTO.getNombre());
		destino.setDescripcion(destinoDTO.getDescripcion());
		destino.setEstado(destinoDTO.getEstado());

		destino.setFechaCreacion(destinoDTO.getFechaCreacion());
		destino.setUsuCreador(destinoDTO.getUsuCreador());

		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(), Constantes.ACTIVO);
		if (tipoDestino == null) {
			throw new SQLException("El tipo destino " + destinoDTO.getCodigoTipoDestino() + " no existe!");
		}

		destino.setTipoDestino(tipoDestino);

		destinoRepository.save(destino);
		
		return destino;
	}

	/**
	 * <p>
	 * Title: actualizarDestino
	 * </p>
	 * <p>
	 * Description: Actualiza los datos de un destino
	 * </p>
	 * 
	 * @param destinoDTO
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#actualizarDestino(co.edu.usbcali.viajesusb.dto.DestinoDTO)
	 */
	@Override
	public void actualizarDestino(DestinoDTO destinoDTO) throws Exception {

		Destino destino = null;
		TipoDestino tipoDestino = null;
		boolean mismo = false;

		// Se valida que el destino sea ingresado
		if (destinoDTO == null || destinoDTO.getIdDest() == null) {
			throw new Exception("Debe ingresar un destino para actualizar");
		}
		// Se valida que el destino tenga un codigo
		if (destinoDTO.getCodigo() == null || destinoDTO.getCodigo().equals("")) {
			throw new Exception("Debe ingresar un código de destino válido");
		}

		// Se valida que el codigo tenga máximo 5 caracteres
		if (destinoDTO.getCodigo().length() > 5) {
			throw new Exception("Debe ingresar un código de maximo de 5 caracteres");
		}

		destino = findById(destinoDTO.getIdDest());
		Destino destinoBd = findByCodigoAndEstado(destinoDTO.getCodigo(), Constantes.ACTIVO);
		if (destino == null) {
			throw new SQLException(
					"El destino " + destinoDTO.getIdDest() + " no existe en la Base de datos, debes crearlo primero");
		} else {			
			if (destinoBd != null) {
				if (destino.getIdDest() == destinoBd.getIdDest()) {
					mismo = true;
				}				
			}
		}

		// Se consulta si existe un destino con el codigo ingresado con estado Activo y
		// que no sea el mismo
		if (destinoBd != null && !mismo) {
			throw new Exception("El destino con código " + destinoBd.getCodigo() + " ya existe");
		}

		// Se valida que se ingrese el nombre
		if (destinoDTO.getNombre() == null || destinoDTO.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre de destino válido");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (destinoDTO.getCodigo().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// Se valida que se ingrese una descripcion
		if (destinoDTO.getDescripcion() == null || destinoDTO.getDescripcion().equals("")) {
			throw new Exception("Debe ingresar una descripción de destino válido");
		}

		// Se valida que la descripción tenga máximo 300 caracteres
		if (destinoDTO.getDescripcion().length() > 300) {
			throw new Exception("Debe ingresar una descripción de maximo de 100 caracteres");
		}

		// Se valida la información de acceso al sitio
		if (destinoDTO.getTierra() == null || destinoDTO.getTierra().equals("") || destinoDTO.getAire() == null
				|| destinoDTO.getAire().equals("") || destinoDTO.getMar() == null || destinoDTO.getMar().equals("")) {
			throw new Exception("Debe ingresar la información completa de acceso transporte");
		}

		// Se valida la información de acceso al sitio
		if (destinoDTO.getTierra().trim().length() > 1 || destinoDTO.getAire().trim().length() > 1
				|| destinoDTO.getMar().trim().length() > 1) {
			throw new Exception("Los campos de acceso al sitio deben ser máximo de un caracter");
		}

		// Se valida que se ingrese un usuario creador
		if (destinoDTO.getUsuModificador() == null || destinoDTO.getUsuModificador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario modificador");
		}

		if (destinoDTO.getUsuModificador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario modificador maximo de 10 caracteres");
		}
		// Verificando estado
		if (!(destinoDTO.getEstado().equalsIgnoreCase(Constantes.ACTIVO)
				|| destinoDTO.getEstado().equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}

		// asignar datos al objeto
		destino.setIdDest(destinoDTO.getIdDest());

		destino.setAire(destinoDTO.getAire());
		destino.setTierra(destinoDTO.getTierra());
		destino.setMar(destinoDTO.getMar());

		destino.setCodigo(destinoDTO.getCodigo());
		destino.setNombre(destinoDTO.getNombre());
		destino.setDescripcion(destinoDTO.getDescripcion());

		destino.setEstado(destinoDTO.getEstado());
		destino.setFechaModificacion(Constantes.ahora());
		destino.setUsuModificador(destinoDTO.getUsuModificador());

		// Se consulta el tipo destino dado su id
		tipoDestino = tipoDestinoService.findByCodigoAndEstado(destinoDTO.getCodigoTipoDestino(), Constantes.ACTIVO);

		// Validamos que el tipo destino exista y este activo
		if (tipoDestino == null) {
			throw new Exception("El tipo destino " + destinoDTO.getCodigoTipoDestino() + " NO existe");
		}

		destino.setTipoDestino(tipoDestino);

		// guardamos el objeto
		destinoRepository.save(destino);

	}

	/**
	 * 
	 * @Title: findById
	 * @Description: Encuentra un destino por Id
	 * @param: @param  idDest
	 * @param: @return
	 * @param: @throws Exception
	 * @return: Optional<Destino>
	 * @throws
	 */
	public Destino findById(Long idDest) throws Exception {

		// Validamos el idDest venga con info
		if (idDest == null) {
			throw new Exception("Debe ingresar un id destino");
		}

		if (!destinoRepository.findById(idDest).isPresent()) {
			throw new Exception("El destino con id: " + idDest + " no existe");
		}

		return destinoRepository.findById(idDest).get();

	}

	/**
	 * <p>
	 * Title: eliminarDestino
	 * </p>
	 * <p>
	 * Description: elimina un destino de la DB
	 * </p>
	 * 
	 * @param destinoDTO
	 * @throws Exception
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#eliminarDestino(co.edu.usbcali.viajesusb.dto.DestinoDTO)
	 */
	@Override
	public void eliminarDestino(Long idDestino) throws Exception, SQLException {
		if (idDestino == null) {
			throw new Exception("El destino está vacío");
		}

		Optional<Destino> destinoBD = destinoRepository.findById(idDestino);

		if (destinoBD.isPresent()) {
			destinoRepository.delete(destinoBD.get());
		} else {
			throw new SQLException("El destino " + idDestino + " no existe!");
		}

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
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.DestinoService#findByCodigoAndEstado(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public Destino findByCodigoAndEstado(String codigo, String estado) throws SQLException, Exception {
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
		return destinoRepository.findByCodigoAndEstado(codigo, estado);
	}

}
