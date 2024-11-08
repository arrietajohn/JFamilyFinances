package FamilyFinances.Controllers.Users;

import FamilyFinances.Business.UseCases.Users.CreateUserService;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public class CreateUserController {
    private final CreateUserService createUserService;

    public CreateUserController(CreateUserService createUserService) {
        this.createUserService = createUserService;
    }
    
    public void executeOperation(String code, String password, String name, String email, UserStatusEnum status, Role role, User createdBy) throws Exception {
       // 1) realizar validaciones mportante
       // ...
       // 2). Ejecutar la operacion
       createUserService.createUser(code, password, name, email, status, role, createdBy);
    }

    
}
