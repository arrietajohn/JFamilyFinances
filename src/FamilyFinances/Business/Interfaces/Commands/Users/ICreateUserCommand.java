package FamilyFinances.Business.Interfaces.Commands.Users;

import FamilyFinances.Business.Handlers.Command.Users.Dto.CreateUserCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface ICreateUserCommand {
    public void handler(CreateUserCommandRequest user) throws Exception;
}
