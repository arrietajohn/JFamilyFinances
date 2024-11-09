package FamilyFinances.Controllers.Interfaces.Users;

import FamilyFinances.Domain.Models.User;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetUsersController {

    public User executeActionGetUser(Integer userId) throws Exception;

    public User executeActionGetUser(String userCode) throws Exception;

    public List<User> executeActionGetAllUsers() throws Exception;
    
    public User getCurrentUser();
}
