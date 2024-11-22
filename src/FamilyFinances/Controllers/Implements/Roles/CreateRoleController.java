
package FamilyFinances.Controllers.Implements.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.ICreateRoleService;
import FamilyFinances.Controllers.Interfaces.Roles.ICreateRoleController;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class CreateRoleController implements ICreateRoleController{

    private final ICreateRoleService roleService;

    public CreateRoleController(ICreateRoleService roleService) {
        this.roleService = roleService;
    }
    
    @Override
    public void executeAction(Role role) throws Exception{
        roleService.createRole(role);
    }
}



