package FamilyFinances.Business.Interfaces.Queries.Users;

import FamilyFinances.Domain.Models.User;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetAllUserQuery {
    public List<User> handler() throws Exception;
}
