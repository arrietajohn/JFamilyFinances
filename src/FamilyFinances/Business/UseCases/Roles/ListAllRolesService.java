package FamilyFinances.Business.UseCases.Roles;

import FamilyFinances.Business.Interfaces.Queries.Roles.IGetAllRolesQuery;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IListAllRolesService;
import FamilyFinances.Domain.Models.Role;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class ListAllRolesService implements IListAllRolesService{

    private IGetAllRolesQuery getAllRolesQuery;

    public ListAllRolesService(IGetAllRolesQuery getAllRolesQuery) {
        this.getAllRolesQuery = getAllRolesQuery;
    }

    @Override
    public List<Role> listAll() throws Exception {
        return getAllRolesQuery.executeOperation();
    }
    
}



