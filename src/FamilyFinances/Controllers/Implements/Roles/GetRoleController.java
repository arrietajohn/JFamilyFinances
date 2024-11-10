package FamilyFinances.Controllers.Implements.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.IGetRolService;
import FamilyFinances.Controllers.Interfaces.Roles.IGetRoleController;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class GetRoleController implements IGetRoleController{
    
    private final IGetRolService service;
    private Role currentRole;

    public GetRoleController(IGetRolService service) {
         
        this.service = service;
    }
    
    @Override
    public Role executeAction(Integer roleId) throws Exception{
       currentRole = service.getRole(roleId);
       return currentRole;
    }
    
    public Role getCurrentRole(){
        return currentRole;
    }

    public void clearCurrentRole() {
        this.currentRole = null;    
    }
}










    