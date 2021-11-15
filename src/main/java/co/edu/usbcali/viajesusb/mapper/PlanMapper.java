/**  
 * @Title:  PlanMapper.java   
 * @Package co.edu.usbcali.viajesusb.mapper   
 * @Description: description   
 * @author: Reyes98    
 * @date:   11/11/2021 4:01:36 p. m.   
 * @version V1.0 
 * @Copyright: Universidad San de Buenaventura
 */
package co.edu.usbcali.viajesusb.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import co.edu.usbcali.viajesusb.domain.Plan;
import co.edu.usbcali.viajesusb.dto.PlanDTO;

/**   
 * @ClassName:  PlanMapper   
 * @Description: TODO   
 * @author: Reyes98   
 * @date:   11/11/2021 4:01:36 p. m.      
 * @Copyright:  USB
 */
@Mapper(componentModel = "spring")
public interface PlanMapper {

	@Mapping(source = "cliente.idClie", target = "idClie")
	@Mapping(source = "usuario.idUsua", target = "idUsua")
	public PlanDTO planToPlanDTO(Plan plan);
	
	@Mapping(source = "idClie", target = "cliente.idClie")
	@Mapping(source = "idUsua", target = "usuario.idUsua")
	public Plan planDTOToPlan(PlanDTO planDTO);
	
	@Mapping(source = "cliente.idClie", target = "idClie")
	@Mapping(source = "usuario.idUsua", target = "idUsua")
	public List<PlanDTO> listPlanToListPlanDTO(List<Plan> listPlan);

	@Mapping(source = "idClie", target = "cliente.idClie")
	@Mapping(source = "idUsua", target = "usuario.idUsua")
	public List<Plan> listPlanDTOToListPlan(List<PlanDTO> listPlanDTO);
	
	
}
