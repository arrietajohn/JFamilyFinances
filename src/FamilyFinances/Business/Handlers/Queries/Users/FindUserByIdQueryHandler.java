package FamilyFinances.Business.Handlers.Queries.Users;

import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByIdQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Users.IFindUserByIdQuery;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public class FindUserByIdQueryHandler implements IFindUserByIdQuery {

    private final IUserRepository userRepository;

    public FindUserByIdQueryHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User handler(FindUserByIdQueryRequest request) throws Exception {
        return userRepository.findById(request.getUserId());
    }

}
