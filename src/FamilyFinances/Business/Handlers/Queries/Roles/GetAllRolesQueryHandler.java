
package FamilyFinances.Business.Handlers.Queries.Roles;

import FamilyFinances.Business.Interfaces.Queries.Roles.IGetAllRolesQuery;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
import FamilyFinances.Domain.Models.Role;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class GetAllRolesQueryHandler implements IGetAllRolesQuery{
    
    private final IRoleRepository rolRepository;

    public GetAllRolesQueryHandler(IRoleRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Role> executeOperation() throws Exception {
        return rolRepository.getAll();
    }
}


