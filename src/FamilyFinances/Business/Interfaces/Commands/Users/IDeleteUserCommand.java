package FamilyFinances.Business.Interfaces.Commands.Users;

import FamilyFinances.Business.Handlers.Command.Users.Dto.DeleteUserCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteUserCommand {
    public void handler(DeleteUserCommandRequest request) throws Exception;
}
