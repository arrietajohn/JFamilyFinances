
package FamilyFinances.Business.Interfaces.Commands.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.CreateRoleCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface ICreateRoleCommand {
      
    public void excuteAction(CreateRoleCommandRequest request) throws Exception;
    
}

