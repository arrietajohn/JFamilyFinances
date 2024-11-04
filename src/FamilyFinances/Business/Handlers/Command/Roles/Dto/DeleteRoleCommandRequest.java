
package FamilyFinances.Business.Handlers.Command.Roles.Dto;

/**
 *
 * @author johnarrieta
 */
public class DeleteRoleCommandRequest {
    private final Integer roleId;

    public DeleteRoleCommandRequest(Integer roleId) {
        if(roleId == null || roleId.intValue() <= 0){
            var message = "El Id del Rol debe ser un numero positivo";
            throw new IllegalArgumentException(message);
        }
        
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }
    
}



