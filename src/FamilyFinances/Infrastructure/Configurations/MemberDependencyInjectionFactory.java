package FamilyFinances.Infrastructure.Configurations;

import FamilyFinances.Business.Handlers.Command.Members.CreateMemberCommandHandler;
import FamilyFinances.Business.Handlers.Command.Members.DeleteMemberCommandHandler;
import FamilyFinances.Business.Handlers.Command.Members.UpdateMemberCommandHandler;
import FamilyFinances.Business.Handlers.Queries.Members.FindMemberByIdQueryHandler;
import FamilyFinances.Business.Handlers.Queries.Members.GetMembersByParameterQueryHandler;
import FamilyFinances.Business.Interfaces.Commands.Members.ICreateMemberCommand;
import FamilyFinances.Business.Interfaces.Commands.Members.IDeleteMemberCommand;
import FamilyFinances.Business.Interfaces.Commands.Members.IUpdateMemberCommand;
import FamilyFinances.Business.Interfaces.Queries.Members.IFindMemberByIdQuery;
import FamilyFinances.Business.Interfaces.Queries.Members.IGetMembersByParameterQuery;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Business.Interfaces.Repositories.IMembershipRequestRepository;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamilyService;
import FamilyFinances.Business.Interfaces.UseCases.Members.ICreateMemberService;
import FamilyFinances.Business.Interfaces.UseCases.Members.IGetMemberService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;
import FamilyFinances.Business.UseCases.Members.CreateMemberService;
import FamilyFinances.Business.UseCases.Members.DeleteMemberService;
import FamilyFinances.Business.UseCases.Members.GetMemberService;
import FamilyFinances.Controllers.Implements.Members.CreateMemberController;
import FamilyFinances.Controllers.Implements.Members.GetMemberController;
import FamilyFinances.Controllers.Interfaces.Members.ICreateMemberController;
import FamilyFinances.Controllers.Interfaces.Members.IGetMemberController;
import FamilyFinances.Infrastructure.Persistence.Repositories.MemberMemoryRepository;
import FamilyFinances.Business.Interfaces.UseCases.Members.IDeleteMemberService;
import FamilyFinances.Business.Interfaces.UseCases.Members.IGetMembersByParameterService;
import FamilyFinances.Business.Interfaces.UseCases.Members.IUpdateMemberService;
import FamilyFinances.Business.UseCases.Members.GetMembersByParameterService;
import FamilyFinances.Business.UseCases.Members.UpdateMemberService;
import FamilyFinances.Controllers.Implements.Members.DeleteMemberController;
import FamilyFinances.Controllers.Implements.Members.GetMembersByParameterController;
import FamilyFinances.Controllers.Implements.Members.IDeleteMemberController;
import FamilyFinances.Controllers.Implements.Members.UpdateMemberController;
import FamilyFinances.Controllers.Interfaces.Families.IGetFamilyController;
import FamilyFinances.Controllers.Interfaces.Members.IGetMembersByParameterController;
import FamilyFinances.Controllers.Interfaces.Members.IUpdateMemberController;
import FamilyFinances.Controllers.Interfaces.Users.ILoginUserController;

/**
 *
 * @author johnarrieta
 */
public class MemberDependencyInjectionFactory {

    public static void registerDependencies(DependencyContainer container) {

        // Registrar la dependencia del respositorio de Miembros
        container.register(IMemberRepository.class, ()
                -> new MemberMemoryRepository(
                        container.resolve(IMembershipRequestRepository.class)
                ));

        // Registrar las dependencias del los Casos de Uso para crear Miembros
        container.register(ICreateMemberCommand.class, ()
                -> new CreateMemberCommandHandler(container.resolve(IMemberRepository.class)));

        container.register(ICreateMemberService.class, ()
                -> new CreateMemberService(
                        container.resolve(ICreateMemberCommand.class),
                        container.resolve(IGetUsersService.class),
                        container.resolve(IGetFamilyService.class)
                ));

        container.register(ICreateMemberController.class, ()
                -> new CreateMemberController(container.resolve(ICreateMemberService.class)));

        // Dependencias necesarias para el caso de uso Buscar Miembro
        container.register(IFindMemberByIdQuery.class, ()
                -> new FindMemberByIdQueryHandler(container.resolve(IMemberRepository.class)));

        container.register(IGetMemberService.class, ()
                -> new GetMemberService(container.resolve(IFindMemberByIdQuery.class)));

        container.register(IGetMemberController.class, ()
                -> new GetMemberController(container.resolve(IGetMemberService.class)));

        // Registrar dependencias de los casos de uso actualizar y eliminar Meiembro
        container.register(IUpdateMemberCommand.class, ()
                -> new UpdateMemberCommandHandler(container.resolve(IMemberRepository.class)));

        container.register(IDeleteMemberCommand.class, ()
                -> new DeleteMemberCommandHandler(container.resolve(IMemberRepository.class)));

        container.register(IDeleteMemberCommand.class, ()
                -> new DeleteMemberCommandHandler(container.resolve(IMemberRepository.class)));

        container.register(IDeleteMemberService.class, ()
                -> new DeleteMemberService(
                        container.resolve(IGetUsersService.class),
                        container.resolve(IDeleteMemberCommand.class),
                        container.resolve(IGetFamilyService.class)));

        container.register(IUpdateMemberService.class, ()
                -> new UpdateMemberService(
                        container.resolve(IUpdateMemberCommand.class)));

        container.register(IUpdateMemberController.class, ()
                -> new UpdateMemberController(
                        container.resolve(IUpdateMemberService.class),
                        container.resolve(ILoginUserController.class),
                        container.resolve(IGetFamilyController.class)));

        container.register(IDeleteMemberController.class, ()
                -> new DeleteMemberController(container.resolve(IDeleteMemberService.class)));

        // Dependencias de los Casos de de uso Reportes parametrizados
        container.register(IGetMembersByParameterQuery.class, ()
                -> new GetMembersByParameterQueryHandler(container.resolve(IMemberRepository.class)));
        
        container.register(IGetMembersByParameterService.class, () -> 
        new GetMembersByParameterService(container.resolve(IGetMembersByParameterQuery.class)));
        
        container.register(IGetMembersByParameterController.class, () ->
        new GetMembersByParameterController(container.resolve(IGetMembersByParameterService.class)));
        

    }
}
