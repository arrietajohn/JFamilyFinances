
package FamilyFinances.Business.UseCases.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.CreateRoleCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Roles.IUpdateRoleCommand;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IUpdateRoleService;

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
    public void updateRole(Integer id, String name, String descripcion) throws Exception {
        var request = new CreateRoleCommandRequest(id, name, descripcion);
        updateRoleCommand.executeAction(request);
    }
    
}


