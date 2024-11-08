package FamilyFinances.Business.Handlers.Command.Users;

import FamilyFinances.Business.Handlers.Command.Users.Dto.UpdateUserCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Users.IUpdateUserCommand;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public class UpdateUserCommandHandler implements IUpdateUserCommand{

    private final IUserRepository userRepository;

    public UpdateUserCommandHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    
    @Override
    public void handler(UpdateUserCommandRequest request) throws Exception {
        var user = new User(
                request.getCode(),
                request.getPassword(),
                request.getName(),
                request.getEmail(),
                request.getRole()
        );
        user.setId(request.getId());
        user.setStatus(request.getStatus());
        user.setUpdateBy(request.getUpdateBy());
        user.setUpdateDate(request.getUpdateDate());
        userRepository.edit(user);
    }

}
