package FamilyFinances.Controllers.Interfaces.Families;

import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetFamiliesController {
    public List<Family> executeAction(String name) throws Exception;
    public List<Family> executeAction() throws Exception;
    
}
