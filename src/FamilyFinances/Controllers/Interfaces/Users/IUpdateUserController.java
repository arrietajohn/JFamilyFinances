package FamilyFinances.Controllers.Interfaces.Users;

import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateUserController {
    public void executeAction(Integer id, String code, String password, String name, String email, UserStatusEnum status, Role role, User updateBy) throws Exception;
}
