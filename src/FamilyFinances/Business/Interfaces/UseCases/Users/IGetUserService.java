package FamilyFinances.Business.Interfaces.UseCases.Users;

import FamilyFinances.Domain.Models.User;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetUserService {

    public User getUser(Integer userId) throws Exception;

    public User getUser(String userCode) throws Exception;

    public List<User> getAllUsers() throws Exception;
    
}
