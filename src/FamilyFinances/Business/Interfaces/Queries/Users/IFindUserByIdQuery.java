package FamilyFinances.Business.Interfaces.Queries.Users;

import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByIdQueryRequest;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public interface IFindUserByIdQuery {
    public User handler(FindUserByIdQueryRequest request) throws Exception;
}
