package FamilyFinances.Controllers.Users;

import FamilyFinances.Business.Interfaces.UseCases.Users.ILoginUserService;
import FamilyFinances.Business.UseCases.Users.LoginUserService;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public class LoginUserController {

    private final ILoginUserService loginUserService;
    private User currentUser;

    public LoginUserController(ILoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    public User executeOperation(String code, String password) throws Exception {
        currentUser = loginUserService.login(code, password);
        return currentUser;
    }

}
