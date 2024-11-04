
package FamilyFinances.Business.UseCases.Roles;

import FamilyFinances.Business.Handlers.Queries.Roles.Dto.GetRoleByIdQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Roles.IGetRoleByIdQuery;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IGetRolService;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class GetRoleService implements IGetRolService {
   private final IGetRoleByIdQuery getRoleQuery;

    public GetRoleService(IGetRoleByIdQuery getRoleQuery) {
        this.getRoleQuery = getRoleQuery;
    }
   
   
   public Role getRole(Integer roleId) throws Exception{
       GetRoleByIdQueryRequest request = new GetRoleByIdQueryRequest(roleId);
       return this.getRoleQuery.excuteAction(request);
   }
}

