package FamilyFinances.Controllers.Implements.Users;

import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Business.Interfaces.UseCases.Users.IUpdateUserService;
import FamilyFinances.Controllers.Interfaces.Users.IUpdateUserController;

/**
 *
 * @author johnarrieta
 */
public class UpdateUserController implements IUpdateUserController{
    private final IUpdateUserService updateUserService;

    public UpdateUserController(IUpdateUserService updateUserService) {
        this.updateUserService = updateUserService;
    }
    
    @Override
    public void executeAction(Integer id, String code, String password, String name, String email, UserStatusEnum status, Role role, User updateBy) throws Exception {

        // 1. Realizar operaciones de validación
        // ...
        // 2. ejecutar la operacion
        updateUserService.updateUser(id, code, password, name, email, status, role, updateBy);
    }
  
}
