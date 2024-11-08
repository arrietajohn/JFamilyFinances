package FamilyFinances.Business.Handlers.Command.Users;

import FamilyFinances.Business.Handlers.Command.Users.Dto.CreateUserCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Users.ICreateUserCommand;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public class CreateUserCommandHandler implements ICreateUserCommand{

    private final IUserRepository userRepository;

    public CreateUserCommandHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    @Override
    public void handler(CreateUserCommandRequest request) throws Exception {
        var user = new User(
                request.getCode(),
                request.getPassword(),
                request.getName(),
                request.getEmail(),
                request.getRole()
        );
        user.setStatus(request.getStatus());
        user.setCreatedBy(request.getCreatedBy());
        user.setCreationDate(request.getCreatedDate());
        userRepository.save(user);
    }

}
