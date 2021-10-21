/**  
 * @Title:  TipoDestinoMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: Reyes98    
 * @date:   12/10/2021 11:32:43 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.viajesusb.domain.TipoDestino;
import co.edu.usbcali.viajesusb.dto.TipoDestinoDTO;

/**   
 * @ClassName:  TipoDestinoMapper   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   12/10/2021 11:32:43 a. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel = "spring")
public interface TipoDestinoMapper {
	
	//from entity to dto
	public TipoDestinoDTO tipoDestinoToTipoDestinoDTO(TipoDestino tipoDestino);
	
	//from dto to entity
	public TipoDestino tipoDestinoDTOToTipoDestino(TipoDestinoDTO tipoDestinoDTO);
	
	//from entity to dto
	public List<TipoDestinoDTO> listTipoDestinoTolistTipoDestinoDTO(List<TipoDestino> listTipoDestino);
	
	//from dto to entity
	public List<TipoDestino> listTipoDestinoDTOTolistTipoDestino(List<TipoDestinoDTO> listTipoDestinoDTO);

}
