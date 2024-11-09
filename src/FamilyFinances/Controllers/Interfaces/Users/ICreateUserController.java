package FamilyFinances.Controllers.Interfaces.Users;

import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public interface ICreateUserController {
    public void executeAction(String code, String password, String name, String email, UserStatusEnum status, Role role, User createdBy) throws Exception ;

}
