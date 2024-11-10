package FamilyFinances.Controllers.Implements.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.IListAllRolesService;
import FamilyFinances.Domain.Models.Role;
import java.util.List;
import FamilyFinances.Controllers.Interfaces.Roles.IListAllRolesController;

/**
 *
 * @author johnarrieta
 */
public class ListAllRolesController implements IListAllRolesController {

    private final IListAllRolesService listAllRolesService;

    public ListAllRolesController(IListAllRolesService listAllRolesService) {
        this.listAllRolesService = listAllRolesService;
    }
    
    @Override
    public List<Role> executeAction() throws Exception{
        return listAllRolesService.listAll();
    }
}




