
package FamilyFinances.Controllers.Implements.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.ICreateRoleService;
import FamilyFinances.Controllers.Interfaces.Roles.ICreateRoleController;

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
    public void executeAction(Integer id, String name, String description) throws Exception{
        roleService.createRole(id, name, description);
    }
}



