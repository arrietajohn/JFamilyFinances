
package FamilyFinances.Business.Interfaces.Queries.Roles;

import FamilyFinances.Business.Handlers.Queries.Roles.Dto.GetRoleByIdQueryRequest;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public interface IGetRoleByIdQuery {
    public Role excuteAction(GetRoleByIdQueryRequest request) throws Exception;
}


