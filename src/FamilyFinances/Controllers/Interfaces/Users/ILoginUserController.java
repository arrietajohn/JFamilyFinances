package FamilyFinances.Controllers.Interfaces.Users;

import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public interface ILoginUserController {
     public User executeAction(String code, String password) throws Exception;
     public User getCurrentUser();
}
