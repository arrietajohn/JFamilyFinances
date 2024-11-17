package FamilyFinances.Infrastructure.Configurations;

import FamilyFinances.Business.Handlers.Command.Families.CreateFamilyCommandHandler;
import FamilyFinances.Business.Handlers.Command.Families.DeleteFamilyByIdCommandHandler;
import FamilyFinances.Business.Handlers.Command.Families.UpdateFamilyCommandHandler;
import FamilyFinances.Business.Handlers.Queries.Families.FindFamiliesByNameQueryHandler;
import FamilyFinances.Business.Handlers.Queries.Families.FindFamilyByIdQueryHandler;
import FamilyFinances.Business.Handlers.Queries.Families.GetAllFamiliesQueryHandler;
import FamilyFinances.Business.Interfaces.Commands.Families.ICreateFamilyCommand;
import FamilyFinances.Business.Interfaces.Commands.Families.IDeleteFamilyCommand;
import FamilyFinances.Business.Interfaces.Commands.Families.IUpdateFamilyCommand;
import FamilyFinances.Business.Interfaces.Queries.Families.IFindFamiliesByNameQuery;
import FamilyFinances.Business.Interfaces.Queries.Families.IFindFamilyByIdQuery;
import FamilyFinances.Business.Interfaces.Queries.Families.IGetAllFamiliesQuery;
import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;
import FamilyFinances.Business.Interfaces.UseCases.Families.ICreateFamilyService;
import FamilyFinances.Business.Interfaces.UseCases.Families.IDeleteFamilyService;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamiliesService;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamilyService;
import FamilyFinances.Business.Interfaces.UseCases.Families.IUpdateFamilyService;
import FamilyFinances.Business.UseCases.Families.CreateFamilyService;
import FamilyFinances.Business.UseCases.Families.DeleteFamilyService;
import FamilyFinances.Business.UseCases.Families.GetFamiliesService;
import FamilyFinances.Business.UseCases.Families.GetFamilyService;
import FamilyFinances.Business.UseCases.Families.UpdateFamilyService;
import FamilyFinances.Controllers.Implements.Families.CreateFamilyController;
import FamilyFinances.Controllers.Implements.Families.DeleteFamilyController;
import FamilyFinances.Controllers.Implements.Families.GetFamiliesController;
import FamilyFinances.Controllers.Implements.Families.GetFamilyController;
import FamilyFinances.Controllers.Implements.Families.UpdateFamilyController;
import FamilyFinances.Controllers.Interfaces.Families.ICreateFamilyController;
import FamilyFinances.Controllers.Interfaces.Families.IDeleteFamilyController;
import FamilyFinances.Controllers.Interfaces.Families.IGetFamiliesController;
import FamilyFinances.Controllers.Interfaces.Families.IGetFamilyController;
import FamilyFinances.Controllers.Interfaces.Families.IUpdateFamilyController;
import FamilyFinances.Infrastructure.Persistence.Repositories.FamilyMemoryRepository;

/**
 *
 * @author johnarrieta
 */
public class FamilyDependencyInjectionFactory {

    public static void registerDependencies(DependencyContainer container) {

        // Registrar la dependencia del respositorio de Familia
        container.register(IFamilyRepository.class, FamilyMemoryRepository::new);

        // Registrar las dependencias del los Casos de Uso Obtener Familias
        container.register(IFindFamilyByIdQuery.class, ()
                -> new FindFamilyByIdQueryHandler(container.resolve(IFamilyRepository.class)));

        container.register(IFindFamiliesByNameQuery.class, ()
                -> new FindFamiliesByNameQueryHandler(container.resolve(IFamilyRepository.class)));

        container.register(IGetAllFamiliesQuery.class, ()
                -> new GetAllFamiliesQueryHandler(container.resolve(IFamilyRepository.class)));

        container.register(IGetFamilyService.class, ()
                -> new GetFamilyService(container.resolve(IFindFamilyByIdQuery.class)));

        container.register(IGetFamiliesService.class, ()
                -> new GetFamiliesService(
                        container.resolve(IFindFamiliesByNameQuery.class),
                        container.resolve(IGetAllFamiliesQuery.class)
                ));

        container.register(IGetFamilyController.class, ()
                -> new GetFamilyController(container.resolve(IGetFamilyService.class)));

        container.register(IGetFamiliesController.class, ()
                -> new GetFamiliesController(container.resolve(IGetFamiliesService.class)));

        // Registrar las dependencias del los Casos de Uso Crear  Familias
        container.register(ICreateFamilyCommand.class, ()
                -> new CreateFamilyCommandHandler(container.resolve(IFamilyRepository.class)));

        container.register(ICreateFamilyService.class, ()
                -> new CreateFamilyService(container.resolve(ICreateFamilyCommand.class)));

        container.register(ICreateFamilyController.class, ()
                -> new CreateFamilyController(container.resolve(ICreateFamilyService.class)));

        // Registrar las dependencias del los Casos de Uso Actualizar Familias
        container.register(IUpdateFamilyCommand.class, ()
                -> new UpdateFamilyCommandHandler(container.resolve(IFamilyRepository.class)));

        container.register(IUpdateFamilyService.class, ()
                -> new UpdateFamilyService(container.resolve(IUpdateFamilyCommand.class)));

        container.register(IUpdateFamilyController.class, () ->
        new UpdateFamilyController(container.resolve(IUpdateFamilyService.class)));
        
        // Registrar las dependencias del los Casos de Uso Eliminar Familias
        container.register(IDeleteFamilyCommand.class, ()
                -> new DeleteFamilyByIdCommandHandler(container.resolve(IFamilyRepository.class)));

        container.register(IDeleteFamilyService.class, ()
                -> new DeleteFamilyService(container.resolve(IDeleteFamilyCommand.class)));
        
        container.register(IDeleteFamilyController.class, () ->
        new DeleteFamilyController(container.resolve(IDeleteFamilyService.class)));
    }
}
