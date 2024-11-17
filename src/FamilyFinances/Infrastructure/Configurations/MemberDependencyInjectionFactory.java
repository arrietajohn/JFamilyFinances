package FamilyFinances.Infrastructure.Configurations;

import FamilyFinances.Business.Handlers.Command.Members.CreateMemberCommandHandler;
import FamilyFinances.Business.Interfaces.Commands.Members.ICreateMemberCommand;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamilyService;
import FamilyFinances.Business.Interfaces.UseCases.Members.ICreateMemberService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;
import FamilyFinances.Business.UseCases.Members.CreateMemberService;
import FamilyFinances.Controllers.ImplementsMembers.CreateMemberController;
import FamilyFinances.Controllers.Interfaces.Members.ICreateMemberController;
import FamilyFinances.Infrastructure.Persistence.Repositories.MemberRepository;

/**
 *
 * @author johnarrieta
 */
public class MemberDependencyInjectionFactory {

    public static void registerDependencies(DependencyContainer container) {

        // Registrar la dependencia del respositorio de Miembros
        container.register(IMemberRepository.class, MemberRepository::new);

        // Registrar las dependencias del los Casos de Uso para crear Miembros
        container.register(ICreateMemberCommand.class, ()
                -> new CreateMemberCommandHandler(container.resolve(IMemberRepository.class)));

        container.register(ICreateMemberService.class, ()
                -> new CreateMemberService(
                        container.resolve(ICreateMemberCommand.class),
                        container.resolve(IGetUsersService.class),
                        container.resolve(IGetFamilyService.class)
                
                ));
        
        container.register(ICreateMemberController.class, ()->
        new CreateMemberController(container.resolve(ICreateMemberService.class)));
    }
}
