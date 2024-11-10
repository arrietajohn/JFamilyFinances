package FamilyFinances.Business.Handlers.Queries.Users;

import FamilyFinances.Business.Interfaces.Queries.Users.IGetAllUserQuery;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Domain.Models.User;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class GetAllUsersQueryHandler implements IGetAllUserQuery {

    private final IUserRepository userRepository;

    public GetAllUsersQueryHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> handler() throws Exception {
        return userRepository.getAll();
    }

}
