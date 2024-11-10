package FamilyFinances.Controllers.Implements.Users;

import FamilyFinances.Business.Interfaces.UseCases.Users.ILoginUserService;
import FamilyFinances.Controllers.Interfaces.Users.ILoginUserController;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public class LoginUserController implements ILoginUserController{

    private final ILoginUserService loginUserService;
    private User currentUser;

    public LoginUserController(ILoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    @Override
    public User executeAction(String code, String password) throws Exception {
        return loginUserService.login(code, password);
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }

}
