/**  
 * @Title:  TipoIdentificacionRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Reyes98    
 * @date:   5/09/2021 10:37:25 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import java.sql.SQLException;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;

/**   
 * @ClassName:  TipoIdentificacionRepository   
 * @Description: Repository de TipoIdentificacion
 * @author: Reyes98   
 * @date:   5/09/2021 10:37:25 a. m.      
 * @Copyright:  USB
 */
public interface TipoIdentificacionRepository extends JpaRepository<TipoIdentificacion, Long>{
	
	/**   
	 * @Title: findByEstado   
	 * @Description: Consulta los tipos de identificacion por estado
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: List<TipoIdentificacion>      
	 * @throws   
	 */
	public List<TipoIdentificacion> findByEstadoOrderByNombreAsc(String estado) throws SQLException, Exception;
	
	/**   
	 * @Title: findByCodigoAndEstado   
	 * @Description: Consulta los tipos de identificaciones por código y estado
	 * @param: @param codigo
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException      
	 * @return: TipoIdentificacion      
	 * @throws   
	 */
	public TipoIdentificacion findByCodigoAndEstado(String codigo, String estado) throws SQLException, Exception;
	
	/**   
	 * @Title: findCodigoTipoIdentificacionByEstado   
	 * @Description: Consulta los tipos de documentos y nombres
	 * @param: @param estado
	 * @param: @return
	 * @param: @throws SQLException
	 * @param: @throws Exception      
	 * @return: List<String[]>      
	 * @throws   
	 */
	@Query(value = "select codigo, nombre from tipo_identificacion where estado = :pEstado", nativeQuery = true)
	public List<String[]> findCodigoTipoIdentificacionByEstado(@Param("pEstado") String estado) throws SQLException, Exception;
	

}
