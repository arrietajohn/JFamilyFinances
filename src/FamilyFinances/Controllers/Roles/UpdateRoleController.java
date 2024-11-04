
package FamilyFinances.Controllers.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.IUpdateRoleService;

/**
 *
 * @author johnarrieta
 */
public class UpdateRoleController {

    private final IUpdateRoleService updateRoleService;

    public UpdateRoleController(IUpdateRoleService updateRoleService) {
        this.updateRoleService = updateRoleService;
    }
    
    public void executeAction(Integer id, String name, String description) throws Exception{
        updateRoleService.updateRole(id, name, description);
    }
}


