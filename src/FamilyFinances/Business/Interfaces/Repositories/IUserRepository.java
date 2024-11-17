package FamilyFinances.Business.Interfaces.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateRoleEntityException;
import FamilyFinances.Business.Exceptions.RoleEntityNotFoundException;
import FamilyFinances.Domain.Models.User;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IUserRepository {

    public User findById(Integer id) throws RoleEntityNotFoundException, Exception;
    
    public User findByCode(String code) throws RoleEntityNotFoundException, Exception;

    public List<User> getAll() throws Exception;

    public void save(User user) throws DuplicateRoleEntityException, Exception;

    public void edit(User user) throws RoleEntityNotFoundException, Exception;

    public void deleteById(Integer id) throws RoleEntityNotFoundException, Exception;
}
