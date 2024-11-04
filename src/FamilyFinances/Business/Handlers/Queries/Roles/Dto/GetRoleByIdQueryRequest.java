
package FamilyFinances.Business.Handlers.Queries.Roles.Dto;

/**
 *
 * @author johnarrieta
 */
public class GetRoleByIdQueryRequest {
    private Integer roleId;
    

    public GetRoleByIdQueryRequest(Integer roleId) throws Exception {
        if(roleId == null || roleId <= 0)
            throw new Exception("El Id del Rol es requerido");
        this.roleId = roleId;
    }

    public Integer getRoleId() {
        return roleId;
    }  
}


