
package FamilyFinances.Infrastructure.Configurations;

import FamilyFinances.Business.Handlers.Command.Roles.CreateRoleCommandHandler;
import FamilyFinances.Business.Handlers.Command.Roles.DeleteRoleCommandHandler;
import FamilyFinances.Business.Handlers.Command.Roles.UpdateRoleCommandHandler;
import FamilyFinances.Business.Interfaces.Queries.Roles.IGetRoleByIdQuery;
import FamilyFinances.Business.Handlers.Queries.Roles.GetRoleByIdQueryHandler;
import FamilyFinances.Business.Interfaces.Commands.Roles.ICreateRoleCommand;
import FamilyFinances.Business.Interfaces.Commands.Roles.IDeleteRoleCommand;
import FamilyFinances.Business.Interfaces.Commands.Roles.IUpdateRoleCommand;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
import FamilyFinances.Business.Interfaces.UseCases.Roles.ICreateRoleService;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IDeleteRoleService;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IGetRolService;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IUpdateRoleService;
import FamilyFinances.Business.UseCases.Roles.CreateRolService;
import FamilyFinances.Business.UseCases.Roles.DeleteRoleService;
import FamilyFinances.Business.UseCases.Roles.GetRoleService;
import FamilyFinances.Business.UseCases.Roles.UpdateRoleService;
import FamilyFinances.Controllers.Roles.CreateRoleController;
import FamilyFinances.Controllers.Roles.DeleteRoleController;
import FamilyFinances.Controllers.Roles.GetRoleController;
import FamilyFinances.Controllers.Roles.UpdateRoleController;
import FamilyFinances.Infrastructure.Persistence.Repositories.RoleMemoryRepository;
import com.sun.source.tree.ContinueTree;

/**
 *
 * @author johnarrieta
 */
public class DependencyInjectionConfiguration {
    
    public static void registerDependencies(DependencyContainer container) {
        
        // Registrar la dependencia del respositorio de Roles
        container.register(IRoleRepository.class, RoleMemoryRepository::new);
        
        // Registrar las dependencias de la Query GetRoleById
        
        container.register(IGetRoleByIdQuery.class, () -> 
            new GetRoleByIdQueryHandler(container.resolve(IRoleRepository.class)));
        
        container.register(IGetRolService.class, () -> 
            new GetRoleService(container.resolve(IGetRoleByIdQuery.class)));
        
        container.register(GetRoleController.class, () ->
            new GetRoleController(container.resolve(IGetRolService.class)));
        
        // Registrar las dependencias del Command CreateRole
        
        container.register(ICreateRoleCommand.class, () -> 
            new CreateRoleCommandHandler(container.resolve(IRoleRepository.class)));
        
        container.register(ICreateRoleService.class, () -> 
            new CreateRolService(container.resolve(ICreateRoleCommand.class)));
        
        container.register(CreateRoleController.class, () -> 
                new CreateRoleController(container.resolve(ICreateRoleService.class)));
        
        // Registrar las dependencias del Command UpdateRole
        
        container.register(IUpdateRoleCommand.class, () -> 
                new UpdateRoleCommandHandler(container.resolve(IRoleRepository.class)));
        
         container.register(IUpdateRoleService.class, () -> 
                new UpdateRoleService(container.resolve(IUpdateRoleCommand.class)));
         
         container.register(UpdateRoleController.class, () -> 
                 new UpdateRoleController(container.resolve(IUpdateRoleService.class)));
         
         // Registrar las deperencias del Command DeleteRole
         
         container.register(IDeleteRoleCommand.class, () -> 
                    new DeleteRoleCommandHandler(container.resolve(IRoleRepository.class)));
         
          container.register(IDeleteRoleService.class, () -> 
                    new DeleteRoleService(container.resolve(IDeleteRoleCommand.class)));
          
          container.register(DeleteRoleController.class, () -> 
                    new DeleteRoleController(container.resolve(IDeleteRoleService.class)));
          
    }
}





