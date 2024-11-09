
package FamilyFinances.Controllers.Implements.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.DeleteRoleCommandRequest;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IDeleteRoleService;
import FamilyFinances.Controllers.Interfaces.Roles.IDeleteRoleController;

/**
 *
 * @author johnarrieta
 */
public class DeleteRoleController implements IDeleteRoleController{
    
    private final IDeleteRoleService deleteRoleService;

    public DeleteRoleController(IDeleteRoleService deleteRoleService) {
        this.deleteRoleService = deleteRoleService;
    }
    
    @Override
    public void executeAction(Integer roleId) throws Exception{
        var request = new DeleteRoleCommandRequest(roleId);
        deleteRoleService.deleteRole(request);
    }
}
