package FamilyFinances.Business.UseCases.Users;

import FamilyFinances.Business.Exceptions.RoleEntityNotFoundException;
import FamilyFinances.Business.Exceptions.UserEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Users.Dto.CreateUserCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Users.ICreateUserCommand;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IGetRolService;
import FamilyFinances.Business.Interfaces.UseCases.Users.ICreateUserService;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;

/**
 *
 * @author johnarrieta
 */
public class CreateUserService implements ICreateUserService {

    private final ICreateUserCommand createUserCommand;
    private final IGetRolService getRolService;
    private final IGetUsersService getUserService;

    public CreateUserService(ICreateUserCommand createUserCommand, IGetRolService getRolService, IGetUsersService getUserService) {
        this.createUserCommand = createUserCommand;
        this.getRolService = getRolService;
        this.getUserService = getUserService;
    }

    @Override
    public void createUser(String code, String password, String name, String email, UserStatusEnum status, Role role, User createdBy) throws Exception {

        if (createdBy == null) {
            throw new IllegalArgumentException("El Usuario creador es requerido");
        }

        if (role == null) {
            throw new IllegalArgumentException("El Rol es requerido");
        }
        try {
            
            var rolValid = getRolService.getRole(role.getId());
            var createdByValid = getUserService.getUser(createdBy.getId());
            var request = new CreateUserCommandRequest(
                    code,
                    password,
                    name,
                    email,
                    status,
                    rolValid,
                    createdByValid);
            createUserCommand.handler(request);
            
        } catch (RoleEntityNotFoundException ex) {
            throw new Exception("No existe el Rol asignado al nuevo usuario");
        } catch (UserEntityNotFoundException ex) {
            throw new Exception("No existe el Usuario creador del nuevo usuario");
        } catch (Exception ex) {
            throw ex;
        }

    }

}
