
package FamilyFinances.Business.Interfaces.UseCases.Roles;

import FamilyFinances.Business.Handlers.Command.Roles.Dto.DeleteRoleCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteRoleService {
    public void deleteRole(DeleteRoleCommandRequest request) throws Exception;
}
