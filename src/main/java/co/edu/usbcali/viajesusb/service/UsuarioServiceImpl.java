/**  
 * @Title:  UsuarioServiceImpl.java   
 * @Package co.edu.usbcali.viajesusb.service   
 * @Description: description   
 * @author: Reyes98    
 * @date:   19/09/2021 9:57:46 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.usbcali.viajesusb.repository.UsuarioRepository;

/**
 * @ClassName: UsuarioServiceImpl
 * @Description: Implementación del servicio para Usuario
 * @author: Reyes98
 * @date: 19/09/2021 9:57:46 a. m.
 * @Copyright: USB
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;

}
