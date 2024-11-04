
package FamilyFinances.Business.Handlers.Command.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.DeleteRoleCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Roles.IDeleteRoleCommand;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;

/**
 *
 * @author johnarrieta
 */
public class DeleteRoleCommandHandler implements IDeleteRoleCommand{

    private final IRoleRepository roleRepository;

    public DeleteRoleCommandHandler(IRoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void executeOperation(DeleteRoleCommandRequest request) throws Exception {
        roleRepository.deleteById(request.getRoleId());
    }
  
}



