
package FamilyFinances.Controllers.Implements.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.IUpdateRoleService;
import FamilyFinances.Controllers.Interfaces.Roles.IUpdateRoleController;

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
    public void executeAction(Integer id, String name, String description) throws Exception{
        updateRoleService.updateRole(id, name, description);
    }
}


