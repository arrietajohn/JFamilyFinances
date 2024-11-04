package FamilyFinances.Controllers.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.IListAllRolesService;
import FamilyFinances.Domain.Models.Role;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class ListAllRoleController {

    private final IListAllRolesService listAllRolesService;

    public ListAllRoleController(IListAllRolesService listAllRolesService) {
        this.listAllRolesService = listAllRolesService;
    }
    
    public List<Role> executeAction() throws Exception{
        return listAllRolesService.listAll();
    }
}




