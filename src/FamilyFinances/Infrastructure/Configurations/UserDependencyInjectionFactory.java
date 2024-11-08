package FamilyFinances.Infrastructure.Configurations;

import FamilyFinances.Business.Handlers.Command.Users.CreateUserCommandHandler;
import FamilyFinances.Business.Handlers.Command.Users.DeleteUserCommandHandler;
import FamilyFinances.Business.Handlers.Command.Users.UpdateUserCommandHandler;
import FamilyFinances.Business.Handlers.Queries.Users.FindUserByCodeQueryHandler;
import FamilyFinances.Business.Handlers.Queries.Users.FindUserByIdQueryHandler;
import FamilyFinances.Business.Interfaces.Commands.Users.ICreateUserCommand;
import FamilyFinances.Business.Interfaces.Commands.Users.IDeleteUserCommand;
import FamilyFinances.Business.Interfaces.Commands.Users.IUpdateUserCommand;
import FamilyFinances.Business.Interfaces.Queries.Users.IFindUserByCodeQuery;
import FamilyFinances.Business.Interfaces.Queries.Users.IFindUserByIdQuery;
import FamilyFinances.Business.Interfaces.Queries.Users.IGetAllUserQuery;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IGetRolService;
import FamilyFinances.Business.Interfaces.UseCases.Users.ICreateUserService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IDeleteUserService;
import FamilyFinances.Business.UseCases.Users.GetUserService;
import FamilyFinances.Controllers.Users.GetUserController;
import FamilyFinances.Infrastructure.Persistence.Repositories.UserMemoryRepository;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;
import FamilyFinances.Business.Interfaces.UseCases.Users.ILoginUserService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IUpdateUserService;
import FamilyFinances.Business.UseCases.Users.CreateUserService;
import FamilyFinances.Business.UseCases.Users.DeleteUserService;
import FamilyFinances.Business.UseCases.Users.LoginUserService;
import FamilyFinances.Business.UseCases.Users.UpdateUserService;
import FamilyFinances.Controllers.Users.DeleteUserController;
import FamilyFinances.Controllers.Users.LoginUserController;
import FamilyFinances.Controllers.Users.UpdateUserController;

/**
 *
 * @author johnarrieta
 */
public class UserDependencyInjectionFactory {

    public static void registerDependencies(DependencyContainer container) {

        // Registrar la dependencia del respositorio de Usuario
        container.register(IUserRepository.class, UserMemoryRepository::new);

        // Registrar las dependencias del Caso de Uso GetUser
        container.register(IFindUserByCodeQuery.class, ()
                -> new FindUserByCodeQueryHandler(container.resolve(IUserRepository.class)));

        container.register(IFindUserByIdQuery.class, ()
                -> new FindUserByIdQueryHandler(container.resolve(IUserRepository.class)));

        container.register(IGetUsersService.class, ()
                -> new GetUserService(
                        container.resolve(IFindUserByCodeQuery.class),
                        container.resolve(IFindUserByIdQuery.class),
                        container.resolve(IGetAllUserQuery.class)
                ));

        container.register(GetUserController.class, ()
                -> new GetUserController(container.resolve(IGetUsersService.class)));

        // Registrar las dependencias del caso de uso Crear Usuario
        container.register(ICreateUserCommand.class, ()
                -> new CreateUserCommandHandler(container.resolve(IUserRepository.class)));

        container.register(ICreateUserService.class, ()
                -> new CreateUserService(
                        container.resolve(ICreateUserCommand.class),
                        container.resolve(IGetRolService.class),
                        container.resolve(IGetUsersService.class)));

        container.register(GetUserController.class, ()
                -> new GetUserController(container.resolve(IGetUsersService.class)));

        // Registrar las dependencias del caso de uso actualizaro usuario
        container.register(IUpdateUserCommand.class, ()
                -> new UpdateUserCommandHandler(container.resolve(IUserRepository.class)));

        container.register(IUpdateUserService.class, ()
                -> new UpdateUserService(
                        container.resolve(IUpdateUserCommand.class),
                        container.resolve(IGetRolService.class),
                        container.resolve(IGetUsersService.class)));

        container.register(UpdateUserController.class, ()
                -> new UpdateUserController(container.resolve(IUpdateUserService.class)));

        // Registrar las dependencias del caso de uso  Eliminar Usuario
        container.register(IDeleteUserCommand.class, ()
                -> new DeleteUserCommandHandler(container.resolve(IUserRepository.class)));

        container.register(IDeleteUserService.class, ()
                -> new DeleteUserService(container.resolve(IDeleteUserCommand.class)));

        container.register(DeleteUserController.class, ()
                -> new DeleteUserController(container.resolve(IDeleteUserService.class)));

        // Registrar las dependencias del caso de uso Login
        container.register(ILoginUserService.class, ()
                -> new LoginUserService(container.resolve(IGetUsersService.class)));

        container.register(LoginUserController.class, ()
                -> new LoginUserController(container.resolve(ILoginUserService.class)));
    }
}
