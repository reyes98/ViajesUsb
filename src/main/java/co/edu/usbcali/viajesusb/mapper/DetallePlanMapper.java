/**  
 * @Title:  DetallePlanMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: Reyes98    
 * @date:   11/11/2021 4:22:57 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.viajesusb.domain.DetallePlan;
import co.edu.usbcali.viajesusb.dto.DetallePlanDTO;

/**   
 * @ClassName:  DetallePlanMapper   
 * @Description: Mapper DetallePlan  
 * @author: Reyes98   
 * @date:   11/11/2021 4:22:57 p. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel = "spring")
public interface DetallePlanMapper {

	@Mapping(source = "destino.idDest", target = "idDest")
	@Mapping(source = "plan.idPlan", target = "idPlan")
	public DetallePlanDTO detallePlanToDetallePlanDTO(DetallePlan detallePlan);
	
	@Mapping(source = "idDest", target = "destino.idDest")
	@Mapping(source = "idPlan", target = "plan.idPlan")
	public DetallePlan detallePlanDTOToDetallePlan(DetallePlanDTO detallePlanDTO);
	
	@Mapping(source = "destino.idDest", target = "idDest")
	@Mapping(source = "plan.idPlan", target = "idPlan")
	public List<DetallePlanDTO> listDetallePlanToListDetallePlanDTO(List<DetallePlan> listDetallePlan);

	@Mapping(source = "idDest", target = "destino.idDest")
	@Mapping(source = "idPlan", target = "plan.idPlan")
	public List<DetallePlan> listDetallePlanDTOToListDetallePlan(List<DetallePlanDTO> listDetallePlanDTO);
}
