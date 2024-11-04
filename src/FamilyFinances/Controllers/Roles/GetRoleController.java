package FamilyFinances.Controllers.Roles;

import FamilyFinances.Business.Interfaces.UseCases.Roles.IGetRolService;
import FamilyFinances.Domain.Models.Role;

/**
 *
 * @author johnarrieta
 */
public class GetRoleController {
    
    private final IGetRolService service;
    private Role currentRole;

    public GetRoleController(IGetRolService service) {
         
        this.service = service;
    }
    
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










    