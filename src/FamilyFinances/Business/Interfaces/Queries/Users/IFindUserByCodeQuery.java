package FamilyFinances.Business.Interfaces.Queries.Users;

import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByCodeQueryRequest;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public interface IFindUserByCodeQuery {
    public User handler(FindUserByCodeQueryRequest request) throws Exception;
}
