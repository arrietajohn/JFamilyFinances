package FamilyFinances.Business.UseCases.Users;

import FamilyFinances.Business.Handlers.Command.Users.Dto.DeleteUserCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Users.IDeleteUserCommand;
import FamilyFinances.Business.Interfaces.UseCases.Users.IDeleteUserService;

/**
 *
 * @author johnarrieta
 */
public class DeleteUserService implements IDeleteUserService {

    private final IDeleteUserCommand deleteUserCommand;

    public DeleteUserService(IDeleteUserCommand deleteUserCommand) {
        this.deleteUserCommand = deleteUserCommand;
    }

    @Override
    public void deleteUser(Integer userId) throws Exception {
//        Es necesario validar si el usuario a eliminar esta relacionado
//      con alguna otra entidad, ya sea como miembro, como creador o como editor)
//      Esta validacion representa flujos de consulta para validaciones de negocio
//      lo que nos permite hacerlo en la capa de Servicio e implementarlo en Repository
        var request = new DeleteUserCommandRequest(userId);
        deleteUserCommand.handler(request);
    }

}
