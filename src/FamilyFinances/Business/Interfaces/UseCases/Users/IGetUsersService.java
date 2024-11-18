package FamilyFinances.Business.Interfaces.UseCases.Users;

import FamilyFinances.Domain.Models.User;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetUsersService {

    public User getUserById(Integer userId) throws Exception;

    public User getUserByCode(String userCode) throws Exception;

    public User getUserByEmail(String userEmail) throws Exception;
    
    public List<User> getAllUsers() throws Exception;

}
