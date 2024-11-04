
package FamilyFinances.Business.Interfaces.UseCases.Roles;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateRoleService {
    public void updateRole(Integer id, String name, String descripcion) throws Exception;
}


