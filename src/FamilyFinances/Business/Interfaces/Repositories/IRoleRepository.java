
package FamilyFinances.Business.Interfaces.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateRoleEntityException;
import FamilyFinances.Business.Exceptions.RoleEntityNotFoundException;
import FamilyFinances.Domain.Constants.EntityStatusEnum;
import FamilyFinances.Domain.Models.Role;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IRoleRepository {
    public Role findById(Integer id) throws RoleEntityNotFoundException, Exception;
    public List<Role> getAll() throws Exception;
    public void save(Role role) throws DuplicateRoleEntityException, Exception;
    public void edit(Role role) throws RoleEntityNotFoundException, Exception;
    public void deleteById(Integer id) throws RoleEntityNotFoundException, Exception;
    public List<Role> findRoleByName(String name) throws RoleEntityNotFoundException, Exception;
    public List<Role> findRoleByDescripcion(String description) throws RoleEntityNotFoundException, Exception;
    public List<Role> findRoleByStatus(EntityStatusEnum status) throws RoleEntityNotFoundException, Exception;
    
}



