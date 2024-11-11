package FamilyFinances.Controllers.Implements.Users;

import FamilyFinances.Business.Handlers.Command.Users.Dto.DeleteUserCommandRequest;
import FamilyFinances.Business.Interfaces.UseCases.Users.IDeleteUserService;
import FamilyFinances.Controllers.Interfaces.Users.IDeleteUserController;

/**
 *
 * @author johnarrieta
 */
public class DeleteUserController implements IDeleteUserController {
    private final IDeleteUserService deleteUserService;

    public DeleteUserController(IDeleteUserService deleteUserService) {
        this.deleteUserService = deleteUserService;
    }
    
    @Override
    public void executeAction(Integer userId) throws Exception{
       // 1) realizar validaciones mportante
       // ...
       // 2). Ejecutar la operacion
       var request = new DeleteUserCommandRequest(userId);
       deleteUserService.deleteUser(userId);
    }
}
