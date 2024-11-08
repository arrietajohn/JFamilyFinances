package FamilyFinances.Business.UseCases.Users;

import FamilyFinances.Business.Exceptions.RoleEntityNotFoundException;
import FamilyFinances.Business.Exceptions.UserEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Users.Dto.UpdateUserCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Users.IUpdateUserCommand;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IGetRolService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IUpdateUserService;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;

/**
 *
 * @author johnarrieta
 */
public class UpdateUserService implements IUpdateUserService {

    private final IUpdateUserCommand updateUserCommand;
    private final IGetRolService getRolService;
    private final IGetUsersService getUserService;

    public UpdateUserService(IUpdateUserCommand updateUserCommand, IGetRolService getRolService, IGetUsersService getUserService) {
        this.updateUserCommand = updateUserCommand;
        this.getRolService = getRolService;
        this.getUserService = getUserService;
    }

    @Override
    public void updateUser(Integer id, String code, String password, String name, String email, UserStatusEnum status, Role role, User updateBy) throws Exception {
        if (updateBy == null) {
            throw new IllegalArgumentException("El Usuario editor es requerido");
        }

        if (role == null) {
            throw new IllegalArgumentException("El Rol es requerido");
        }
        try {
            
            var rolValid = getRolService.getRole(role.getId());
            var updatedByValid = getUserService.getUser(updateBy.getId());
            var request = new UpdateUserCommandRequest(
                    id,
                    code,
                    password,
                    name,
                    email,
                    status,
                    rolValid,
                    updatedByValid);
            updateUserCommand.handler(request);
            
        } catch (RoleEntityNotFoundException ex) {
            throw new Exception("No existe el Rol asignado al usuario que desea modificar");
        } catch (UserEntityNotFoundException ex) {
            throw new Exception("No existe el Usuario que esta intentando modificar a otro usuario");
        } catch (Exception ex) {
            throw ex;
        }

    }

}
