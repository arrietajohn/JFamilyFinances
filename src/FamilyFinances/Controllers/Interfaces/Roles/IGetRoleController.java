package FamilyFinances.Controllers.Interfaces.Roles;

import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public interface IGetRoleController {
     public Role executeAction(Integer roleId) throws Exception;
     public void clearCurrentRole();
     public Role getCurrentRole();
}
