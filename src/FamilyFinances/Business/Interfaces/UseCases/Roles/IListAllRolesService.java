package FamilyFinances.Business.Interfaces.UseCases.Roles;

import FamilyFinances.Domain.Models.Role;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IListAllRolesService {
    public List<Role> listAll() throws Exception;
}









