
package FamilyFinances.Controllers.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.DeleteRoleCommandRequest;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IDeleteRoleService;

/**
 *
 * @author johnarrieta
 */
public class DeleteRoleController {
    
    private final IDeleteRoleService deleteRoleService;

    public DeleteRoleController(IDeleteRoleService deleteRoleService) {
        this.deleteRoleService = deleteRoleService;
    }
    
    public void executeAction(Integer roleId) throws Exception{
        var request = new DeleteRoleCommandRequest(roleId);
        deleteRoleService.deleteRole(request);
    }
}
