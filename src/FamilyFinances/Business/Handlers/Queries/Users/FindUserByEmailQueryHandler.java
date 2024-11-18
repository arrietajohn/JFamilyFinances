package FamilyFinances.Business.Handlers.Queries.Users;

import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByCodeQueryRequest;
import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByEmailQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Users.IFindUserByCodeQuery;
import FamilyFinances.Business.Interfaces.Queries.Users.IFindUserByEmailQuery;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public class FindUserByEmailQueryHandler implements IFindUserByEmailQuery{

    private final IUserRepository userRepository; 

    public FindUserByEmailQueryHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public User handler(FindUserByEmailQueryRequest request) throws Exception {
        return userRepository.findByEmail(request.getUserEmail());
    }

}
