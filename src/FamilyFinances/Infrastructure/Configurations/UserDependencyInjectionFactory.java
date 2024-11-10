package FamilyFinances.Infrastructure.Configurations;

import FamilyFinances.Business.Handlers.Command.Users.CreateUserCommandHandler;
import FamilyFinances.Business.Handlers.Command.Users.DeleteUserCommandHandler;
import FamilyFinances.Business.Handlers.Command.Users.UpdateUserCommandHandler;
import FamilyFinances.Business.Handlers.Queries.Users.FindUserByCodeQueryHandler;
import FamilyFinances.Business.Handlers.Queries.Users.FindUserByIdQueryHandler;
import FamilyFinances.Business.Handlers.Queries.Users.GetAllUsersQueryHandler;
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
import FamilyFinances.Controllers.Implements.Users.GetUsersController;
import FamilyFinances.Infrastructure.Persistence.Repositories.UserMemoryRepository;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;
import FamilyFinances.Business.Interfaces.UseCases.Users.ILoginUserService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IUpdateUserService;
import FamilyFinances.Business.UseCases.Users.CreateUserService;
import FamilyFinances.Business.UseCases.Users.DeleteUserService;
import FamilyFinances.Business.UseCases.Users.LoginUserService;
import FamilyFinances.Business.UseCases.Users.UpdateUserService;
import FamilyFinances.Controllers.Implements.Users.CreateUserController;
import FamilyFinances.Controllers.Implements.Users.DeleteUserController;
import FamilyFinances.Controllers.Implements.Users.LoginUserController;
import FamilyFinances.Controllers.Implements.Users.UpdateUserController;
import FamilyFinances.Controllers.Interfaces.Users.ICreateUserController;
import FamilyFinances.Controllers.Interfaces.Users.IDeleteUserController;
import FamilyFinances.Controllers.Interfaces.Users.IGetUsersController;
import FamilyFinances.Controllers.Interfaces.Users.ILoginUserController;
import FamilyFinances.Controllers.Interfaces.Users.IUpdateUserController;

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
        
        container.register(IGetAllUserQuery.class, () ->
        new GetAllUsersQueryHandler(container.resolve(IUserRepository.class)));

        container.register(IGetUsersService.class, ()
                -> new GetUserService(
                        container.resolve(IFindUserByCodeQuery.class),
                        container.resolve(IFindUserByIdQuery.class),
                        container.resolve(IGetAllUserQuery.class)
                ));

        container.register(IGetUsersController.class, ()
                -> new GetUsersController(container.resolve(IGetUsersService.class)));

        // Registrar las dependencias del caso de uso Crear Usuario
        container.register(ICreateUserCommand.class, ()
                -> new CreateUserCommandHandler(container.resolve(IUserRepository.class)));

        container.register(ICreateUserService.class, ()
                -> new CreateUserService(
                        container.resolve(ICreateUserCommand.class),
                        container.resolve(IGetRolService.class),
                        container.resolve(IGetUsersService.class)));

        container.register(ICreateUserController.class, ()
                -> new CreateUserController(container.resolve(ICreateUserService.class)));

        // Registrar las dependencias del caso de uso actualizaro usuario
        container.register(IUpdateUserCommand.class, ()
                -> new UpdateUserCommandHandler(container.resolve(IUserRepository.class)));

        container.register(IUpdateUserService.class, ()
                -> new UpdateUserService(
                        container.resolve(IUpdateUserCommand.class),
                        container.resolve(IGetRolService.class),
                        container.resolve(IGetUsersService.class)));

        container.register(IUpdateUserController.class, ()
                -> new UpdateUserController(container.resolve(IUpdateUserService.class)));

        // Registrar las dependencias del caso de uso  Eliminar Usuario
        container.register(IDeleteUserCommand.class, ()
                -> new DeleteUserCommandHandler(container.resolve(IUserRepository.class)));

        container.register(IDeleteUserService.class, ()
                -> new DeleteUserService(container.resolve(IDeleteUserCommand.class)));

        container.register(IDeleteUserController.class, ()
                -> new DeleteUserController(container.resolve(IDeleteUserService.class)));

        // Registrar las dependencias del caso de uso Login
        container.register(ILoginUserService.class, ()
                -> new LoginUserService(container.resolve(IGetUsersService.class)));

        container.register(ILoginUserController.class, ()
                -> new LoginUserController(container.resolve(ILoginUserService.class)));
    }
}
