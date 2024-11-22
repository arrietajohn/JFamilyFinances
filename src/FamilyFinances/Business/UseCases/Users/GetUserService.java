package FamilyFinances.Business.UseCases.Users;

import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByCodeQueryRequest;
import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByEmailQueryRequest;
import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByIdQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Users.IFindUserByCodeQuery;
import FamilyFinances.Business.Interfaces.Queries.Users.IFindUserByEmailQuery;
import FamilyFinances.Business.Interfaces.Queries.Users.IFindUserByIdQuery;
import FamilyFinances.Business.Interfaces.Queries.Users.IGetAllUserQuery;
import FamilyFinances.Domain.Models.User;
import java.util.List;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;

/**
 *
 * @author johnarrieta
 */
public class GetUserService implements IGetUsersService {

    private final IFindUserByCodeQuery findByCodeQuery;
    private final IFindUserByIdQuery findByIdQuery;
    private final IFindUserByEmailQuery findByEmailQuery;
    private final IGetAllUserQuery getAllUsersQuery;

    public GetUserService(IFindUserByCodeQuery findByCodeQuery, IFindUserByIdQuery findByIdQuery, IFindUserByEmailQuery findByEmailQuery, IGetAllUserQuery getAllUsersQuery) {
        this.findByCodeQuery = findByCodeQuery;
        this.findByIdQuery = findByIdQuery;
        this.findByEmailQuery = findByEmailQuery;
        this.getAllUsersQuery = getAllUsersQuery;
    }

    @Override
    public User getUserById(Integer userId) throws Exception {
        var request = new FindUserByIdQueryRequest(userId);
        return findByIdQuery.handler(request);
    }

    @Override
    public User getUserByCode(String userCode) throws Exception {
        var request = new FindUserByCodeQueryRequest(userCode);
        return findByCodeQuery.handler(request);
    }

    @Override
    public User getUserByEmail(String userEmail) throws Exception {
        var request = new FindUserByEmailQueryRequest(userEmail);
        return findByEmailQuery.handler(request);
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return getAllUsersQuery.handler();
    }

}
