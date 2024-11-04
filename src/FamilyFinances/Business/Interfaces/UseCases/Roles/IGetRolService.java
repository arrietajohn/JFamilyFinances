
package FamilyFinances.Business.Interfaces.UseCases.Roles;

import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public interface IGetRolService {
    public Role getRole(Integer roleId) throws Exception;
}
