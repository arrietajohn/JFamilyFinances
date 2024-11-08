package FamilyFinances.Business.Handlers.Command.Users;

import FamilyFinances.Business.Handlers.Command.Users.Dto.DeleteUserCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Users.IDeleteUserCommand;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;

/**
 *
 * @author johnarrieta
 */
public class DeleteUserCommandHandler implements IDeleteUserCommand{

    private final IUserRepository userRepository;

    public DeleteUserCommandHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public void handler(DeleteUserCommandRequest request) throws Exception {
        userRepository.deleteById(request.getUserId());
    }

}
