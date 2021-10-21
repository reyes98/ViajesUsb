/**  
 * @Title:  ClienteMapper.java   
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

import co.edu.usbcali.viajesusb.domain.Cliente;
import co.edu.usbcali.viajesusb.dto.ClienteDTO;

/**
 * @ClassName: ClienteMapper
 * @Description: TODO
 * @author: Reyes98
 * @date: 17/10/2021 11:47:49 a. m.
 * @Copyright: USB
 */
@Mapper(componentModel = "spring")
public interface ClienteMapper {
	@Mapping(source = "tipoIdentificacion.idTiid", target = "idTiid")
	@Mapping(source = "tipoIdentificacion.codigo", target = "codigoTipoIdentificacion")
	public ClienteDTO clienteToClienteDTO(Cliente cliente);
	
	@Mapping(source = "idTiid", target = "tipoIdentificacion.idTiid")
	@Mapping(source = "codigoTipoIdentificacion", target = "tipoIdentificacion.codigo")
	public Cliente clienteDTOToCliente(ClienteDTO clienteDTO);
	
	@Mapping(source = "idTiid", target = "tipoIdentificacion.idTiid")
	@Mapping(source = "codigoTipoIdentificacion", target = "tipoIdentificacion.codigo")
	public List<Cliente> listClienteDTOToListCliente(List<ClienteDTO> listClienteDTO);
	
	@Mapping(source = "tipoIdentificacion.idTiid", target = "idTiid")
	@Mapping(source = "tipoIdentificacion.codigo", target = "codigoTipoIdentificacion")
	public List<ClienteDTO> listClienteToListClienteDTO(List<Cliente> listCliente);
	

}
