/**  
 * @Title:  ClienteRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Reyes98    
 * @date:   5/09/2021 10:27:13 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;

/**
 * @ClassName: ClienteRepository
 * @Description: Repositorio de Cliente
 * @author: Reyes98
 * @date: 5/09/2021 10:27:13 a. m.
 * @Copyright: USB
 */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	/**
	 * @Title: findByEstado
	 * @Description: Consulta los clientes por estado, ordenado por idClie asc
	 * @param: @param  estado
	 * @param: @param  pageable
	 * @param: @return
	 * @param: @throws Exception
	 * @return: Page<Cliente>
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
	public Page<Cliente> findByTipoIdentificacionCodigo(String codigo, Pageable pageable)
			throws SQLException, Exception;

	/**
	 * @Title: findByTipoIdentificacionCodigo
	 * @Description: TODO
	 * @param: @param  codigo
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
	public List<Cliente> findByPrimerApellidoContainsIgnoreCaseOrSegundoApellidoContainsIgnoreCase(
			String primerApellido, String segundoApellido) throws SQLException, Exception;

	/**
	 * @Title: consultarClientePorFiltros
	 * @Description: Consulta los clientes mediante filtros
	 * @param: @param  estado
	 * @param: @param  numeroIdentificacion
	 * @param: @param  idTiid
	 * @param: @param  nombre
	 * @param: @return
	 * @param: @throws SQLException
	 * @return: List<Cliente>
	 * @throws
	 */
	@Query(nativeQuery = true)
	public List<ClienteDTO> consultarClientePorFiltros(@Param("pEstado") String estado,
			@Param("pNumeroIdentificacion") String numeroIdentificacion, @Param("pIdTiid") Long idTiid,
			@Param("pNombre") String nombre) throws SQLException, Exception;

}
