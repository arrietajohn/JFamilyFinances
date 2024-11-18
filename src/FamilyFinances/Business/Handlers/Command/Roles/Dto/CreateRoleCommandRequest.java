
package FamilyFinances.Business.Handlers.Command.Roles.Dto;

import FamilyFinances.Domain.Models.Role;

/**
 * @author johnarrieta
 */
public class CreateRoleCommandRequest {
    
    private Role role;

    public CreateRoleCommandRequest(Role role) {
        if(role == null){
            throw new IllegalArgumentException("El rol es requerido");
        }
        this.role = role;
    }

  
    public Role getRole() {
        return role;
    }
}






