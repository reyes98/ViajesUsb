/**  
 * @Title:  TipoIdentificacionMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: Reyes98    
 * @date:   17/10/2021 11:53:29 a. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import co.edu.usbcali.viajesusb.domain.TipoIdentificacion;
import co.edu.usbcali.viajesusb.dto.TipoIdentificacionDTO;

/**
 * @ClassName: TipoIdentificacionMapper
 * @Description: TODO
 * @author: Reyes98
 * @date: 17/10/2021 11:53:29 a. m.
 * @Copyright: USB
 */
@Mapper(componentModel = "spring")
public interface TipoIdentificacionMapper {
	// from entity to dto
	public TipoIdentificacionDTO tipoIdentificacionToTipoIdentificacionDTO(TipoIdentificacion tipoIdentificacion);

	// from dto to entity
	public TipoIdentificacion tipoIdentificacionDTOToTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO);

	// from entity to dto
	public List<TipoIdentificacionDTO> listTipoIdentificacionTolistTipoIdentificacionDTO(List<TipoIdentificacion> listTipoIdentificacion);

	// from dto to entity
	public List<TipoIdentificacion> listTipoIdentificacionDTOTolistTipoIdentificacion(List<TipoIdentificacionDTO> listTipoIdentificacionDTO);

}
