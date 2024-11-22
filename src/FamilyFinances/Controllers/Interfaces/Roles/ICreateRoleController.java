package FamilyFinances.Controllers.Interfaces.Roles;

import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public interface ICreateRoleController {
    public void executeAction(Role role) throws Exception;
}
