package FamilyFinances.Business.Interfaces.Queries.Users;

import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByEmailQueryRequest;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public interface IFindUserByEmailQuery {
    public User handler(FindUserByEmailQueryRequest request) throws Exception;
}
