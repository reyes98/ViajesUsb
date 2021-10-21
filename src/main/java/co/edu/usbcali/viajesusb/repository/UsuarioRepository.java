/**  
 * @Title:  UsuarioRepository.java   
 * @Package co.edu.usbcali.viajesusb.repository   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:50:43 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.usbcali.viajesusb.domain.Usuario;

/**   
 * @ClassName:  UsuarioRepository   
 * @Description: Repositorio de la Clase Usuario  
 * @author: Reyes98   
 * @date:   19/09/2021 9:50:43 a. m.      
 * @Copyright:  USB
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
