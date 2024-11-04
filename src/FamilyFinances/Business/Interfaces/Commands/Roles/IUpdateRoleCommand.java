
package FamilyFinances.Business.Interfaces.Commands.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.CreateRoleCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateRoleCommand {
    public void executeAction(CreateRoleCommandRequest request) throws Exception;
}


