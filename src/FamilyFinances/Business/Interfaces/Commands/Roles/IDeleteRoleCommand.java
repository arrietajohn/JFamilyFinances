
package FamilyFinances.Business.Interfaces.Commands.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.DeleteRoleCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteRoleCommand {
    public void executeOperation(DeleteRoleCommandRequest request) throws Exception;
}





