/**  
 * @Title:  ClienteServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   11/09/2021 9:22:35 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;
import co.edu.usbcali.viajesusb.repository.ClienteRepository;
import co.edu.usbcali.viajesusb.utils.Constantes;

/**
 * @ClassName: ClienteServiceImpl
 * @Description: Validaciones de Cliente
 * @author: Reyes98
 * @date: 11/09/2021 9:22:35 a. m.
 * @Copyright: USB
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TipoIdentificacionService tipoIdentificacionService;

	/**
	 * <p>
	 * Title: findByEstadoOrderByIdClieAsc
	 * </p>
	 * <p>
	 * Description: Retorna un paginado de los clientes por estado, limite de
	 * elementos por pagina es 100
	 * </p>
	 * 
	 * @param estado
	 * @param pageable
	 * @return Page <Cliente>
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByEstadoOrderByIdClieAsc(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Cliente> findByEstadoOrderByIdClieAsc(String estado, Pageable pageable) throws SQLException, Exception {
		Page<Cliente> pageCliente = null;

		// Verificando contenido
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado está vacio!");
		}
		// Verificando estado
		if (!(estado.equalsIgnoreCase(Constantes.ACTIVO) || estado.equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}

		// Verificando contenido del Pageable
		if (pageable == null || pageable.isUnpaged()) {
			throw new Exception("No existe paginación!");
		}
		// Verificando numero de página
		if (pageable.getPageNumber() < 0) {
			throw new Exception("No existe pagina negativa!");
		}
//		// Verificando la cantidad de elementos por página
//		if (pageable.getPageSize() > 100) {
//			throw new SQLException("No puedes paginar más de 100 elementos!");
//		}
		// Verificando que la cantidad no sea negativa
		if (pageable.getPageSize() < 0) {
			throw new SQLException("No puedes paginar un número negativo de elementos!");
		}

		pageCliente = clienteRepository.findByEstadoOrderByIdClieAsc(estado, pageable);

		return pageCliente;
	}

	/**
	 * <p>
	 * Title: findByCorreoIgnoreCase
	 * </p>
	 * <p>
	 * Description: Consulta un Cliente por correo ignorando mayusculas y minusculas
	 * </p>
	 * 
	 * @param correo
	 * @return Cliente
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByCorreoIgnoreCase(java.lang.String)
	 */
	@Override
	public Cliente findByCorreoIgnoreCase(String correo) throws SQLException, Exception {
		// validando contenido
		if (correo == null || correo.trim().equals("")) {
			throw new Exception("El correo está vacio!");
		}
		// validando patrón del correo
		if (!Constantes.PATTERN_CORREO.matcher(correo).matches()) {
			throw new Exception("El correo tiene que ser con el patrón 'ejemplo@correo.com'!");
		}

		return clienteRepository.findByCorreoIgnoreCase(correo);

	}

	/**
	 * <p>
	 * Title: findByNumeroIdentificacionLike
	 * </p>
	 * <p>
	 * Description: Busca los clientes que tengan numeros de identificacion por
	 * operador like
	 * </p>
	 * 
	 * @param numeroIdentificacion
	 * @return List <Cliente>
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByNumeroIdentificacionLike(java.lang.String)
	 */
	@Override
	public List<Cliente> findByNumeroIdentificacionLike(String numeroIdentificacion) throws SQLException, Exception {

		// validando contenido
		if (numeroIdentificacion == null || numeroIdentificacion.trim().equals("")) {
			throw new Exception("El numero de identificación está vacío!");
		}
		// validando patrón del correo
		if (!numeroIdentificacion.trim().matches(Constantes.PATRON_NUMERO_IDENTIFICACION)) {
			throw new Exception("El número de identificación debe ser solo números, ej: 110280985");
		}

		return clienteRepository.findByNumeroIdentificacionLike("%" + numeroIdentificacion + "%");

	}

	/**
	 * <p>
	 * Title: findByNombreLikeIgnoreCase
	 * </p>
	 * <p>
	 * Description: Consulta los Clientes por coincidencia de nombre
	 * </p>
	 * 
	 * @param nombre
	 * @return List <Cliente>
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByNombreLikeIgnoreCase(java.lang.String)
	 */
	@Override
	public List<Cliente> findByNombreLikeIgnoreCase(String nombre) throws SQLException, Exception {
		// validando contenido
		if (nombre == null || nombre.trim().equals("")) {
			throw new Exception("El nombre está vacio!");
		}
		// Se valida que el nombre tenga máximo 100 caracteres
		if (nombre.length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}
		return clienteRepository.findByNombreLikeIgnoreCase("%" + nombre + "%");
	}

	/**
	 * <p>
	 * Title: findByFechaNacimientoBetween
	 * </p>
	 * <p>
	 * Description: Encuentra Clientes por rangos de fecha de nacimiento
	 * </p>
	 * 
	 * @param fechaNacimientoFrom
	 * @param fechaNacimientoTo
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByFechaNacimientoBetween(java.util.Date,
	 *      java.util.Date)
	 */
	@Override
	public List<Cliente> findByFechaNacimientoBetween(Date fechaNacimientoFrom, Date fechaNacimientoTo)
			throws SQLException, Exception {
		// validando contenido from
		if (fechaNacimientoFrom == null) {
			throw new Exception("La fecha de nacimiento desde está vacia!");
		}
		// validando contenido to
		if (fechaNacimientoTo == null) {
			throw new Exception("La fecha de nacimiento hasta está vacia!");
		}
		// valida si la fecha from > to
		if (fechaNacimientoFrom.after(fechaNacimientoTo)) {
			throw new Exception("La fecha de nacimiento desde es mayor que la fecha hasta!");
		}
		// validan si la fecha from > a la actual
		if (fechaNacimientoFrom.after(Constantes.ahora())) {
			throw new Exception("Las fecha desde no puede ser mayor a la actual!");
		}
//		// valida si la fecha to > a la actual
//		if (fechaNacimientoTo.after(Calendar.getInstance().getTime())) {
//			throw new Exception("Las fecha hasta no puede ser mayor a la actual!");
//		}
		return clienteRepository.findByFechaNacimientoBetween(fechaNacimientoFrom, fechaNacimientoTo);
	}

	/**
	 * <p>
	 * Title: countTotalClientesByEstado
	 * </p>
	 * <p>
	 * Description: retorna el total de clientes por estado agrupados
	 * </p>
	 * 
	 * @return List
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#countTotalClientesByEstado()
	 */
	@Override
	public List<String[]> countTotalClientesByEstado() throws SQLException, Exception {
		return clienteRepository.countTotalClientesByEstado();
	}

	/**
	 * <p>
	 * Title: countClientesByEstado
	 * </p>
	 * <p>
	 * Description: consulta el numero de clientes por un estado especifico
	 * </p>
	 * 
	 * @param estado
	 * @return Long
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#countClientesByEstado(java.lang.String)
	 */
	@Override
	public Long countClientesByEstado(String estado) throws SQLException, Exception {
		// Verificando contenido
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado está vacio!");
		} else {
			// Verificando estado
			if (!(estado.equalsIgnoreCase("A") || estado.equalsIgnoreCase("I"))) {
				throw new SQLException("El estado solo puede ser 'A'-> activo ó 'I'-> inactivo!");
			}
		}
		return clienteRepository.countClientesByEstado(estado);
	}

	/**
	 * <p>
	 * Title: findByTipoIdentificacionCodigo
	 * </p>
	 * <p>
	 * Description: Encuentra los cliente por código del tipo de identificacion
	 * </p>
	 * 
	 * @param codigo
	 * @param pageable
	 * @return Page
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByTipoIdentificacionCodigo(java.lang.String,
	 *      org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Cliente> findByTipoIdentificacionCodigo(String codigo, Pageable pageable)
			throws SQLException, Exception {
		// Verificando contenido
		if (codigo == null || codigo.trim().equals("")) {
			throw new Exception("El código está vacio!");
		}
		// Verificando codigo
		if (!(codigo.equalsIgnoreCase("CC") || codigo.equalsIgnoreCase("TI") || codigo.equalsIgnoreCase("CE")
				|| codigo.equalsIgnoreCase("PA") || codigo.equalsIgnoreCase("RC")
				|| codigo.equalsIgnoreCase("LIC"))) {
			throw new SQLException("Elige un código de tipo de identificación válido (CC, TI, CE, PA, RC, LIC)!");
		}

		// Verificando contenido del Pageable
		if (pageable == null || pageable.isUnpaged()) {
			throw new Exception("No existe paginación!");
		}
		// Verificando numero de página
		if (pageable.getPageNumber() < 0) {
			throw new Exception("No existe pagina negativa!");
		}
//					// Verificando la cantidad de elementos por página
//					if (pageable.getPageSize() > 100) {
//						throw new SQLException("No puedes paginar más de 100 elementos!");
//					}
		// Verificando que la cantidad no sea negativa
		if (pageable.getPageSize() < 0) {
			throw new SQLException("No puedes paginar un número negativo de elementos!");
		}

		return clienteRepository.findByTipoIdentificacionCodigo(codigo, pageable);
	}

	/**
	 * <p>
	 * Title: findByTipoIdentificacionCodigo
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param codigo
	 * @return
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByTipoIdentificacionCodigo(java.lang.String)
	 */
	@Override
	public List<Cliente> findByTipoIdentificacionCodigo(String codigo) throws SQLException, Exception {
		// Verificando contenido
		if (codigo == null || codigo.trim().equals("")) {
			throw new Exception("El código está vacio!");
		}
		
		return clienteRepository.findByTipoIdentificacionCodigo(codigo);
	}

	/**
	 * <p>
	 * Title: findByPrimerApellidoContainsOrSegundoApellidoContains
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param primerApellido
	 * @param segundoApellido
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#findByPrimerApellidoContainsOrSegundoApellidoContains(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public List<Cliente> findByPrimerApellidoContainsOrSegundoApellidoContains(String apellido)
			throws SQLException, Exception {
		// validando contenido
		if (apellido == null || apellido.trim().equals("")) {
			throw new Exception("El apellido está vacio!");
		}
		return clienteRepository.findByPrimerApellidoContainsIgnoreCaseOrSegundoApellidoContainsIgnoreCase(apellido, apellido);

	}

	/**
	 * <p>
	 * Title: consultarClientePorFiltros
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param estado
	 * @param numeroIdentificacion
	 * @param idTiid
	 * @param nombre
	 * @return
	 * @throws SQLException
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#consultarClientePorFiltros(java.lang.String,
	 *      java.lang.String, java.lang.Long, java.lang.String)
	 */
	@Override
	public List<ClienteDTO> consultarClientePorFiltros(String estado, String numeroIdentificacion, Long idTiid,
			String nombre) throws SQLException, Exception {
		// Verificando contenido
		if (estado == null || estado.trim().equals("")) {
			throw new Exception("El estado está vacio!");
		} else {
			// Verificando estado
			if (!(estado.equalsIgnoreCase("A") || estado.equalsIgnoreCase("I"))) {
				throw new SQLException("El estado solo puede ser 'A'-> activo ó 'I'-> inactivo!");
			}
		}
		// validando contenido
		if (numeroIdentificacion == null || numeroIdentificacion.trim().equals("")) {
			throw new Exception("El numero de identificación está vacío!");
		} else {
			// validando patrón del correo
			if (!numeroIdentificacion.trim().matches(Constantes.PATRON_NUMERO_IDENTIFICACION)) {
				throw new Exception("El número de identificación debe ser solo números, ej: 110280985");
			}
		}
		// validando contenido
		if (idTiid == null || idTiid == 0) {
			throw new Exception("El idTiid está vacío!");
		}
		// validando si es menor a 0
		if (idTiid < 0) {
			throw new Exception("El idTiid es un número negativo!");
		}
		// validando contenido
		if (nombre == null || nombre.trim().equals("")) {
			throw new Exception("El nombre está vacio!");
		}

		return clienteRepository.consultarClientePorFiltros(estado, numeroIdentificacion, idTiid, "%" + nombre + "%");
	}

	/**
	 * <p>
	 * Title: guardarCliente
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clienteDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#guardarCliente(co.edu.usbcali.viajesusb.dto.ClienteDTO)
	 */
	@Override
	public Cliente guardarCliente(ClienteDTO clienteDTO) throws SQLException, Exception {
		Cliente cliente = null;
		TipoIdentificacion tipoIdentificacion = null;

		// Validamos si el destino está presente
//		if (clienteRepository.findById(clienteDTO.getIdDest()).isPresent()) {
//			throw new SQLException(
//					"El cliente " + clienteDTO.getIdDest() + " ya existe en la Base de datos, asigna un id diferente!");
//		}

		// validando contenido
		if (clienteDTO.getNumeroIdentificacion() == null || clienteDTO.getNumeroIdentificacion().trim().equals("")) {
			throw new Exception("El numero de identificación está vacío!");
		}
		// validando patrón del correo
		if (!clienteDTO.getNumeroIdentificacion().trim().matches(Constantes.PATRON_NUMERO_IDENTIFICACION)) {
			throw new Exception("El número de identificación debe ser solo números, ej: 110280985");
		}

		// Se valida que se ingrese el nombre
		if (clienteDTO.getNombre() == null || clienteDTO.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre de cliente válido");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (clienteDTO.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// Se valida que se ingrese el apellido 1
		if (clienteDTO.getPrimerApellido() == null || clienteDTO.getPrimerApellido().equals("")) {
			throw new Exception("Debe ingresar el primer apellido del cliente ");
		}

		// Se valida que el apellido tenga máximo 100 caracteres
		if (clienteDTO.getPrimerApellido().length() > 100) {
			throw new Exception("Debe ingresar un apellido de maximo de 100 caracteres");
		}

		// Se valida que se ingrese el apellido 2
		if (clienteDTO.getSegundoApellido() != null && !clienteDTO.getPrimerApellido().equals("")) {
			// Se valida que el apellido tenga máximo 100 caracteres
			if (clienteDTO.getSegundoApellido().length() > 100) {
				throw new Exception("Debe ingresar un apellido de maximo de 100 caracteres");
			}
		}

		// Se consulta si existe un cliente con el correo
		Cliente clienteBd = clienteRepository.findByCorreoIgnoreCase(clienteDTO.getCorreo());
		if (clienteBd != null) {
			throw new Exception("El cliente con correo " + clienteBd.getCorreo() + " ya existe");
		}

		// validando contenido
		if (clienteDTO.getCorreo() == null || clienteDTO.getCorreo().trim().equals("")) {
			throw new Exception("El correo está vacio!");
		}
		// validando patrón del correo
		if (!Constantes.PATTERN_CORREO.matcher(clienteDTO.getCorreo()).matches()) {
			throw new Exception("El correo tiene que ser con el patrón 'ejemplo@correo.com'!");
		}

		// validando contenido fecha
		if (clienteDTO.getFechaNacimiento() == null) {
			throw new Exception("La fecha de nacimiento desde está vacia!");
		}

		// validan si la fecha nac > a la actual
		if (clienteDTO.getFechaNacimiento().after(Constantes.ahora())) {
			throw new Exception("Las fecha desde no puede ser mayor a la actual!");
		}

		// validando edad
		if (Constantes.calcularEdad(clienteDTO.getFechaNacimiento()) < Constantes.EDAD_MINIMA) {
			throw new Exception("El cliente debe ser mayor a " + Constantes.EDAD_MINIMA + "!");
		}

		// Se valida que se ingrese un usuario creador
		if (clienteDTO.getUsuCreador() == null || clienteDTO.getUsuCreador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario creador");
		}

		if (clienteDTO.getUsuCreador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario creador maximo de 10 caracteres");
		}

		// Verificando contenido
		if (clienteDTO.getEstado() == null) {
			throw new SQLException("El estado está vacío ");
		}

		// Verificando estado
		if (!(clienteDTO.getEstado().equalsIgnoreCase(Constantes.ACTIVO)
				|| clienteDTO.getEstado().equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}

		// Verificando contenido
		if (clienteDTO.getCodigoTipoIdentificacion() == null
				|| clienteDTO.getCodigoTipoIdentificacion().trim().equals("")) {
			throw new Exception("El código de tipo de identificacion está vacio!");
		}
		// Verificando codigo
		if (!(clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("CC")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("TI")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("CE")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("PA")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("RC")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("LIC"))) {
			throw new SQLException("Elige un código de tipo de identificación válido (CC, TI, CE, PA, RC, LIC)!");
		}

		// Verificando sexo
		if (!(clienteDTO.getSexo().equalsIgnoreCase("M") || clienteDTO.getSexo().equalsIgnoreCase("F")
				|| clienteDTO.getSexo().equalsIgnoreCase("N"))) {
			throw new SQLException("Elige un  sexo válido (M, F), elige N si no aplica!");
		}

		cliente = new Cliente();

		cliente.setIdClie(clienteDTO.getIdClie());

		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());
		cliente.setTelefono1(clienteDTO.getTelefono1());
		cliente.setTelefono2(clienteDTO.getTelefono2());
		cliente.setCorreo(clienteDTO.getCorreo());
		cliente.setSexo(clienteDTO.getSexo());
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());

		cliente.setEstado(clienteDTO.getEstado());
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());
		cliente.setUsuCreador(clienteDTO.getUsuCreador());

		tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),
				Constantes.ACTIVO);
		if (tipoIdentificacion == null) {
			throw new SQLException(
					"El tipo de identificación " + clienteDTO.getCodigoTipoIdentificacion() + " no existe!");
		}

		cliente.setTipoIdentificacion(tipoIdentificacion);

		clienteRepository.save(cliente);
		return cliente;
	}

	/**
	 * <p>
	 * Title: actualizarCliente
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clienteDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#actualizarCliente(co.edu.usbcali.viajesusb.dto.ClienteDTO)
	 */
	@Override
	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws SQLException, Exception {
		Cliente cliente = null;
		TipoIdentificacion tipoIdentificacion = null;
		boolean mismo = false;
		// Validamos si el destino está presente
		cliente = findById(clienteDTO.getIdClie());
		if (cliente == null) {
			throw new SQLException(
					"El cliente " + clienteDTO.getIdClie() + " no existe en la Base de datos, debes crearlo primero");
		}

		// validando contenido
		if (clienteDTO.getNumeroIdentificacion() == null || clienteDTO.getNumeroIdentificacion().trim().equals("")) {
			throw new Exception("El numero de identificación está vacío!");
		}
		// validando patrón del correo
		if (!clienteDTO.getNumeroIdentificacion().trim().matches(Constantes.PATRON_NUMERO_IDENTIFICACION)) {
			throw new Exception("El número de identificación debe ser solo números, ej: 110280985");
		}

		// Se valida que se ingrese el nombre
		if (clienteDTO.getNombre() == null || clienteDTO.getNombre().equals("")) {
			throw new Exception("Debe ingresar un nombre de cliente válido");
		}

		// Se valida que el nombre tenga máximo 100 caracteres
		if (clienteDTO.getNombre().length() > 100) {
			throw new Exception("Debe ingresar un nombre de maximo de 100 caracteres");
		}

		// Se valida que se ingrese el apellido 1
		if (clienteDTO.getPrimerApellido() == null || clienteDTO.getPrimerApellido().equals("")) {
			throw new Exception("Debe ingresar el primer apellido del cliente ");
		}

		// Se valida que el apellido tenga máximo 100 caracteres
		if (clienteDTO.getPrimerApellido().length() > 100) {
			throw new Exception("Debe ingresar un apellido de maximo de 100 caracteres");
		}

		// Se valida que se ingrese el apellido 2
		if (clienteDTO.getSegundoApellido() != null && !clienteDTO.getPrimerApellido().equals("")) {
			// Se valida que el apellido tenga máximo 100 caracteres
			if (clienteDTO.getSegundoApellido().length() > 100) {
				throw new Exception("Debe ingresar un apellido de maximo de 100 caracteres");
			}
		}

		// validando contenido
		if (clienteDTO.getCorreo() == null || clienteDTO.getCorreo().trim().equals("")) {
			throw new Exception("El correo está vacio!");
		}
		// validando patrón del correo
		if (!Constantes.PATTERN_CORREO.matcher(clienteDTO.getCorreo()).matches()) {
			throw new Exception("El correo tiene que ser con el patrón 'ejemplo@correo.com'!");
		}

		// Se consulta si existe un cliente con el correo
		Cliente clienteBd = clienteRepository.findByCorreoIgnoreCase(clienteDTO.getCorreo());
		if (clienteBd != null) {
			// Se verifica si es el mismo correo
			if (cliente.getIdClie() == clienteBd.getIdClie()) {
				mismo = true;
			}
		}
		// si es el mismo correo se puede dejar el mismo correo
		if (clienteBd != null && !mismo) {
			throw new Exception("El cliente con correo " + clienteBd.getCorreo() + " ya existe");
		}

		// validando contenido fecha
		if (clienteDTO.getFechaNacimiento() == null) {
			throw new Exception("La fecha de nacimiento desde está vacia!");
		}

		// validan si la fecha nac > a la actual
		if (clienteDTO.getFechaNacimiento().after(Constantes.ahora())) {
			throw new Exception("Las fecha desde no puede ser mayor a la actual!");
		}

		// validando edad
		if (Constantes.calcularEdad(clienteDTO.getFechaNacimiento()) < Constantes.EDAD_MINIMA) {
			throw new Exception("El cliente debe ser mayor a " + Constantes.EDAD_MINIMA + "!");
		}

		// Se valida que se ingrese un usuario creador
		if (clienteDTO.getUsuModificador() == null || clienteDTO.getUsuModificador().trim().equals("")) {
			throw new Exception("Se debe ingresar un usuario creador");
		}

		if (clienteDTO.getUsuModificador().length() > 10) {
			throw new Exception("Se debe ingresar un usuario creador maximo de 10 caracteres");
		}

		// Verificando contenido
		if (clienteDTO.getEstado() == null) {
			throw new SQLException("El estado está vacío ");
		}

		// Verificando estado
		if (!(clienteDTO.getEstado().equalsIgnoreCase(Constantes.ACTIVO)
				|| clienteDTO.getEstado().equalsIgnoreCase(Constantes.INACTIVO))) {
			throw new SQLException("El estado solo puede ser '" + Constantes.ACTIVO + "'-> activo ó '"
					+ Constantes.INACTIVO + "'-> inactivo!");
		}

		// Verificando contenido
		if (clienteDTO.getCodigoTipoIdentificacion() == null
				|| clienteDTO.getCodigoTipoIdentificacion().trim().equals("")) {
			throw new Exception("El código está vacio!");
		}
		// Verificando codigo
		if (!(clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("CC")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("TI")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("CE")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("PA")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("RC")
				|| clienteDTO.getCodigoTipoIdentificacion().equalsIgnoreCase("LIC"))) {
			throw new SQLException("Elige un código de tipo de identificación válido (CC, TI, CE, PA, RC, LIC)!");
		}

		// Verificando sexo
		if (!(clienteDTO.getSexo().equalsIgnoreCase("M") || clienteDTO.getSexo().equalsIgnoreCase("F")
				|| clienteDTO.getSexo().equalsIgnoreCase("N"))) {
			throw new SQLException("Elige un  sexo válido (M, F), elige N si no aplica!");
		}

		cliente.setNumeroIdentificacion(clienteDTO.getNumeroIdentificacion());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setPrimerApellido(clienteDTO.getPrimerApellido());
		cliente.setSegundoApellido(clienteDTO.getSegundoApellido());
		cliente.setTelefono1(clienteDTO.getTelefono1());
		cliente.setTelefono2(clienteDTO.getTelefono2());
		cliente.setCorreo(clienteDTO.getCorreo());
		cliente.setSexo(clienteDTO.getSexo());
		cliente.setFechaNacimiento(clienteDTO.getFechaNacimiento());

		cliente.setEstado(clienteDTO.getEstado());
		cliente.setFechaModificacion(Constantes.ahora());
		cliente.setUsuModificador(clienteDTO.getUsuModificador());

		tipoIdentificacion = tipoIdentificacionService.findByCodigoAndEstado(clienteDTO.getCodigoTipoIdentificacion(),
				Constantes.ACTIVO);
		if (tipoIdentificacion == null) {
			throw new SQLException(
					"El tipo de identificación " + clienteDTO.getCodigoTipoIdentificacion() + " no existe!");
		}

		cliente.setTipoIdentificacion(tipoIdentificacion);

		clienteRepository.save(cliente);
		
		return cliente;
	}

	/**
	 * <p>
	 * Title: eliminarCliente
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param clienteDTO
	 * @throws SQLException
	 * @throws Exception
	 * @see co.edu.usbcali.viajesusb.service.ClienteService#eliminarCliente(co.edu.usbcali.viajesusb.dto.ClienteDTO)
	 */
	@Override
	public void eliminarCliente(Long idClie) throws SQLException, Exception {
		if (idClie == null) {
			throw new Exception("El id del cliente está vacío");
		}

		Optional<Cliente> clienteBD = clienteRepository.findById(idClie);

		if (clienteBD.isPresent()) {
			clienteRepository.delete(clienteBD.get());
		} else {
			throw new SQLException("El cliente " +idClie + " no existe!");
		}

	}

	/**
	 * @Title: findById
	 * @Description: TODO
	 * @param: @param  idClie
	 * @param: @return
	 * @param: @throws Exception
	 * @return: Cliente
	 * @throws
	 */
	public Cliente findById(Long idClie) throws Exception {

		// Validamos el idClie venga con info
		if (idClie == null) {
			throw new Exception("Debe ingresar un id de cliente");
		}

		if (!clienteRepository.findById(idClie).isPresent()) {
			throw new Exception("El  cliente con id: " + idClie + " no existe");
		}

		return clienteRepository.findById(idClie).get();

	}

}
