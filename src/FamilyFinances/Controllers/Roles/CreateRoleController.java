
package FamilyFinances.Controllers.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.ICreateRoleService;

/**
 *
 * @author johnarrieta
 */
public class CreateRoleController {

    private final ICreateRoleService roleService;

    public CreateRoleController(ICreateRoleService roleService) {
        this.roleService = roleService;
    }
    
    public void executeAction(Integer id, String name, String description) throws Exception{
        roleService.createRole(id, name, description);
    }
}



