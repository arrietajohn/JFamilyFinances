package FamilyFinances.Controllers.Interfaces.Roles;

import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateRoleController {

    public void executeAction(Role rolen) throws Exception;
}
