
package FamilyFinances.Business.Interfaces.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateEntityException;
import FamilyFinances.Business.Exceptions.EntityNotFoundException;
import FamilyFinances.Domain.Models.Role;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IRoleRepository {
    public Role findById(Integer id) throws EntityNotFoundException, Exception;
    public List<Role> getAll() throws Exception;
    public void save(Role role) throws DuplicateEntityException, Exception;
    public void edit(Role role) throws EntityNotFoundException, Exception;
    public void deleteById(Integer id) throws EntityNotFoundException, Exception;
    
}



