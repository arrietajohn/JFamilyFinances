
package FamilyFinances.Business.UseCases.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.DeleteRoleCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Roles.IDeleteRoleCommand;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IDeleteRoleService;

/**
 *
 * @author johnarrieta
 */
public class DeleteRoleService implements IDeleteRoleService{

    private final IDeleteRoleCommand deleteRoleCommand;

    public DeleteRoleService(IDeleteRoleCommand deleteRoleCommand) {
        this.deleteRoleCommand = deleteRoleCommand;
    }

    @Override
    public void deleteRole(DeleteRoleCommandRequest request) throws Exception {
        deleteRoleCommand.executeOperation(request);
    }
    
    
}


