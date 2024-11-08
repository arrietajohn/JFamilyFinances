package FamilyFinances.Business.Interfaces.UseCases.Users;

import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateUserService {
    void updateUser(Integer id, String code, String password, String name, String email, UserStatusEnum status, Role role, User updateBy) throws Exception;
}

