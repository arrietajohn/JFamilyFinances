
package FamilyFinances.Business.Handlers.Command.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.CreateRoleCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Roles.IUpdateRoleCommand;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class UpdateRoleCommandHandler implements IUpdateRoleCommand{
    
    private final IRoleRepository roleRepository;

    public UpdateRoleCommandHandler(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public void executeAction(CreateRoleCommandRequest request) throws Exception {
        var role = new Role(request.getName(), request.getDescription());
        role.setId(request.getId());
        roleRepository.edit(role);
    }
    
}


