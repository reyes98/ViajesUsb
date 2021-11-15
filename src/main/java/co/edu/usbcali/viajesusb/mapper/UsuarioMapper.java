/**  
 * @Title:  UsuarioMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: Reyes98    
 * @date:   17/10/2021 11:47:49 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.viajesusb.domain.Usuario;
import co.edu.usbcali.viajesusb.dto.UsuarioDTO;

/**
 * @ClassName: UsuarioMapper
 * @Description: TODO
 * @author: Reyes98
 * @date: 17/10/2021 11:47:49 a. m.
 * @Copyright: USB
 */
@Mapper(componentModel = "spring")
public interface UsuarioMapper {

	@Mapping(source = "usuario.login", target = "password")
	public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

	public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);

	public List<Usuario> listUsuarioDTOToListUsuario(List<UsuarioDTO> listUsuarioDTO);

	public List<UsuarioDTO> listUsuarioToListUsuarioDTO(List<Usuario> listUsuario);

}
