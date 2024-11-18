
package FamilyFinances.Controllers.Implements.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.IUpdateRoleService;
import FamilyFinances.Controllers.Interfaces.Roles.IUpdateRoleController;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class UpdateRoleController implements IUpdateRoleController{

    private final IUpdateRoleService updateRoleService;

    public UpdateRoleController(IUpdateRoleService updateRoleService) {
        this.updateRoleService = updateRoleService;
    }
    
    @Override
    public void executeAction(Role role) throws Exception{
        updateRoleService.updateRole(role);
    }
}


