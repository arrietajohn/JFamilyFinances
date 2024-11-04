
package FamilyFinances.Business.Handlers.Command.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.CreateRoleCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Roles.ICreateRoleCommand;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class CreateRoleCommandHandler implements ICreateRoleCommand{
    
    private final IRoleRepository roleRepository;

    public CreateRoleCommandHandler(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void excuteAction(CreateRoleCommandRequest request) throws Exception {
        var role = new Role(request.getName(), request.getDescription());
        role.setId(request.getId());
        roleRepository.save(role);
    }
    
}



