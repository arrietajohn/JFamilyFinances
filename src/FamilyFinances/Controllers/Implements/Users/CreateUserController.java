package FamilyFinances.Controllers.Implements.Users;

import FamilyFinances.Business.Interfaces.UseCases.Users.ICreateUserService;
import FamilyFinances.Business.UseCases.Users.CreateUserService;
import FamilyFinances.Controllers.Interfaces.Users.ICreateUserController;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public class CreateUserController implements ICreateUserController{
    private final ICreateUserService createUserService;

    public CreateUserController(ICreateUserService createUserService) {
        this.createUserService = createUserService;
    }
    
    @Override
    public void executeAction(String code, String password, String name, String email, UserStatusEnum status, Role role, User createdBy) throws Exception {
       // 1) realizar validaciones mportante
       // ...
       // 2). Ejecutar la operacion
       createUserService.createUser(code, password, name, email, status, role, createdBy);
    }

    
}
