package FamilyFinances.Controllers.Interfaces.Roles;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateRoleController {

    public void executeAction(Integer id, String name, String description) throws Exception;
}
