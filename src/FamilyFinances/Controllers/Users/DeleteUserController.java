package FamilyFinances.Controllers.Users;

import FamilyFinances.Business.Handlers.Command.Users.DeleteUserCommandHandler;
import FamilyFinances.Business.Handlers.Command.Users.Dto.DeleteUserCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Users.IDeleteUserCommand;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IDeleteRoleService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IDeleteUserService;

/**
 *
 * @author johnarrieta
 */
public class DeleteUserController {
    private final IDeleteUserService deleteUserService;

    public DeleteUserController(IDeleteUserService deleteUserService) {
        this.deleteUserService = deleteUserService;
    }
    
    public void executeOperation(Integer userId) throws Exception{
       // 1) realizar validaciones mportante
       // ...
       // 2). Ejecutar la operacion
       var request = new DeleteUserCommandRequest(userId);
       deleteUserService.deleteUser(userId);
    }
}
