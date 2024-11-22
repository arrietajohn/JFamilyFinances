
package FamilyFinances.Business.UseCases.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.CreateRoleCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Roles.IUpdateRoleCommand;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IUpdateRoleService;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class UpdateRoleService implements IUpdateRoleService{

    private final IUpdateRoleCommand updateRoleCommand;

    public UpdateRoleService(IUpdateRoleCommand updateRoleCommand) {
        this.updateRoleCommand = updateRoleCommand;
    }

    @Override
    public void updateRole(Role role) throws Exception {
        var request = new CreateRoleCommandRequest(role);
        updateRoleCommand.executeAction(request);
    }
    
}


