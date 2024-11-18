
package FamilyFinances.Business.UseCases.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.CreateRoleCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Roles.ICreateRoleCommand;
import FamilyFinances.Business.Interfaces.UseCases.Roles.ICreateRoleService;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class CreateRolService implements ICreateRoleService{

    private final ICreateRoleCommand createRolCommand;

    public CreateRolService(ICreateRoleCommand createRolCommand) {
        this.createRolCommand = createRolCommand;
    }

    @Override
    public void createRole(Role role) throws Exception {
        var request = new CreateRoleCommandRequest(role);
        createRolCommand.excuteAction(request);
    }
   
}


