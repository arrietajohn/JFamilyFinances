package FamilyFinances.Business.Interfaces.Commands.Users;

import FamilyFinances.Business.Handlers.Command.Users.Dto.UpdateUserCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateUserCommand {
    public void handler(UpdateUserCommandRequest request) throws Exception;
}
