
package FamilyFinances.Business.Interfaces.Queries.Roles;

import FamilyFinances.Domain.Models.Role;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetAllRolesQuery {
    public List<Role> executeOperation() throws Exception;
}



