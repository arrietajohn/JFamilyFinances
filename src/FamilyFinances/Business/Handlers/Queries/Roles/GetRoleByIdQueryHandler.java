
package FamilyFinances.Business.Handlers.Queries.Roles;

import FamilyFinances.Business.Handlers.Queries.Roles.Dto.GetRoleByIdQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Roles.IGetRoleByIdQuery;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class GetRoleByIdQueryHandler implements IGetRoleByIdQuery{
    
    private  IRoleRepository roleRepository;
    
    public GetRoleByIdQueryHandler(IRoleRepository repository){
        
        this.roleRepository = repository; 
    }

    @Override
    public Role excuteAction(GetRoleByIdQueryRequest request) throws Exception {
        return roleRepository.findById(request.getRoleId());
    }  
}



