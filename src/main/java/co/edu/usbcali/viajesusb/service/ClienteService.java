/**  
 * @Title:  ClienteService.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   11/09/2021 9:19:09 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;

/**   
 * @ClassName:  ClienteService   
 * @Description: Sevice de Cliente
 * @author: Reyes98   
 * @date:   11/09/2021 9:19:09 a. m.      
 * @Copyright:  USB
 */
public interface ClienteService {
	/**
	 * @Title: findByEstado
	 * @Description: Consulta los clientes por estado, ordenado por idClie asc
	 * @param: @param  estado
	 * @param: @param  pageable
	 * @param: @return
	 * @param: @throws Exception
	 * @return: Page<Cliente>
	 * @throws Exception 
	 * @throws
	 */
	public Page<Cliente> findByEstadoOrderByIdClieAsc(String estado, Pageable pageable) throws SQLException, Exception;

	/**
	 * @Title: findByCorreoIgnoreCase
	 * @Description: Encuentra un cliente por correo ignorando mayusculas y
	 *               minusculas
	 * @param: @param  correo
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: Cliente
	 * @throws
	 */
	public Cliente findByCorreoIgnoreCase(String correo) throws SQLException, Exception;

	/**
	 * @Title: findByNumeroIdentificacionLike
	 * @Description:Encuentra por numero de identificación del cliente
	 * @param: @param  numeroIdentificacion
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: List<Cliente>
	 * @throws
	 */
	public List<Cliente> findByNumeroIdentificacionLike(String numeroIdentificacion) throws SQLException, Exception;

	/**
	 * @Title: findByNombreLikeIgnoreCase
	 * @Description: Consulta cliente por coincidencia de nombre
	 * @param: @param  nombre
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: List<Cliente>
	 * @throws
	 */
	public List<Cliente> findByNombreLikeIgnoreCase(String nombre) throws SQLException, Exception;

	/**
	 * @Title: findByFechaNacimientoBetween
	 * @Description: Consulta cliente entre un rango de fecha de nacimiento
	 * @param: @param  fechaNacimientoFrom
	 * @param: @param  fechaNacimientoTo
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: List<Cliente>
	 * @throws
	 */
	public List<Cliente> findByFechaNacimientoBetween(Date fechaNacimientoFrom, Date fechaNacimientoTo)
			throws SQLException, Exception;

	/**
	 * @Title: countTotalClientesByEstado
	 * @Description: Cuenta cuantos clientes hay por estado
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: List<String[]>
	 * @throws
	 */
	@Query(value = "select estado, count(id_clie) cantidad from cliente group by estado", nativeQuery = true)
	public List<String[]> countTotalClientesByEstado() throws SQLException, Exception;

	/**
	 * @Title: countTotalClientesByEstado
	 * @Description: Cuenta cuantos clientes hay en un estado
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: Long
	 * @throws
	 */
	public Long countClientesByEstado(String estado) throws SQLException, Exception;

	/**
	 * @Title: findByTipoIdentificacionCodigo
	 * @Description: Pagina clientes por código de tipo de identificacion
	 * @param: @param  codigo
	 * @param: @param  pageable
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: Page<Cliente>
	 * @throws
	 */
	public Page<Cliente> findByTipoIdentificacionCodigo(String codigo, Pageable pageable) throws SQLException, Exception;
	
	/**   
	 * @Title: findByTipoIdentificacionCodigo   
	 * @Description: TODO 
	 * @param: @param codigo
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: List<Cliente>      
	 * @throws   
	 */
	public List<Cliente> findByTipoIdentificacionCodigo(String codigo) throws SQLException, Exception;

	/**
	 * @Title: findByPrimerApellidoContainsOrSegundoApellidoContains
	 * @Description: Encuentra por coincidencia de apellidos
	 * @param: @param  primerApellido
	 * @param: @param  segundoApellido
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: List<Cliente>
	 * @throws
	 */
	public List<Cliente> findByPrimerApellidoContainsOrSegundoApellidoContains(String apellido) throws SQLException, Exception;

	/**   
	 * @Title: consultarClientePorFiltros   
	 * @Description: Consulta los clientes mediante filtros
	 * @param: @param estado
	 * @param: @param numeroIdentificacion
	 * @param: @param idTiid
	 * @param: @param nombre
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: List<Cliente>      
	 * @throws   
	 */
	@Query(nativeQuery = true)
	public List<ClienteDTO> consultarClientePorFiltros(@Param("pEstado") String estado,
			@Param("pNumeroIdentificacion") String numeroIdentificacion,
			@Param("pIdTiid") Long idTiid,
			@Param("pNombre") String nombre) throws SQLException, Exception;

	/**   
	 * @Title: guardar Cliente   
	 * @Description: Guarda un nuevo Cliente 
	 * @param: @param clienteDTO
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	public Cliente guardarCliente(ClienteDTO clienteDTO) throws SQLException, Exception;
	
	/**   
	 * @Title: actualizarCliente   
	 * @Description: Actualiza la info de un Cliente 
	 * @param: @param clienteDTO
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: void      
	 * @throws   
	 */
	public Cliente actualizarCliente(ClienteDTO clienteDTO) throws SQLException, Exception;

	/**   
	 * @Title: eliminarCliente   
	 * @Description: Elimina un Cliente 
	 * @param: @param clienteDTO      
	 * @return: void      
	 * @throws   
	 */
	public void eliminarCliente(Long idClie) throws SQLException, Exception;
}
