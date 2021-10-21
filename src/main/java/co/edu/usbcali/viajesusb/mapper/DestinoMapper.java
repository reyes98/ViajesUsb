/**  
 * @Title:  DestinoMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: Reyes98    
 * @date:   12/10/2021 12:01:09 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.viajesusb.domain.Destino;
import co.edu.usbcali.viajesusb.dto.DestinoDTO;

/**   
 * @ClassName:  DestinoMapper   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   12/10/2021 12:01:09 p. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel = "spring")
public interface DestinoMapper {
	@Mapping(source = "tipoDestino.idTide", target = "idTide")
	@Mapping(source = "tipoDestino.codigo", target = "codigoTipoDestino")
	@Mapping(source = "tipoDestino.nombre", target = "nombreTipoDestino")
	@Mapping(source = "tipoDestino.estado", target = "estadoTipoDestino")
	public DestinoDTO destinoToDestinoDTO(Destino destino);
}
