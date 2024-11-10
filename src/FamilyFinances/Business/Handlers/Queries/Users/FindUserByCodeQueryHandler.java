package FamilyFinances.Business.Handlers.Queries.Users;

import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByCodeQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Users.IFindUserByCodeQuery;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public class FindUserByCodeQueryHandler implements IFindUserByCodeQuery{

    private final IUserRepository userRepository; 

    public FindUserByCodeQueryHandler(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public User handler(FindUserByCodeQueryRequest request) throws Exception {
        return userRepository.findByCode(request.getUserCode());
    }

}
