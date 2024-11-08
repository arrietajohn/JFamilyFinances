package FamilyFinances.Controllers.Users;

import FamilyFinances.Business.Interfaces.Commands.Users.IUpdateUserCommand;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IGetRolService;
import FamilyFinances.Business.UseCases.Users.UpdateUserService;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IUpdateUserService;

/**
 *
 * @author johnarrieta
 */
public class UpdateUserController {
    private final IUpdateUserService updateUserService;

    public UpdateUserController(IUpdateUserService updateUserService) {
        this.updateUserService = updateUserService;
    }
    
    public void executeOperation(Integer id, String code, String password, String name, String email, UserStatusEnum status, Role role, User updateBy) throws Exception {

        // 1. Realizar operaciones de validación
        // ...
        // 2. ejecutar la operacion
        updateUserService.updateUser(id, code, password, name, email, status, role, updateBy);
    }
  
}
