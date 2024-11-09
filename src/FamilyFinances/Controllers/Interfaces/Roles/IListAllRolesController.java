package FamilyFinances.Controllers.Interfaces.Roles;

import FamilyFinances.Domain.Models.Role;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IListAllRolesController {
    public List<Role> executeAction() throws Exception; 
}
