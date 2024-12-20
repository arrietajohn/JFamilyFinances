
package FamilyFinances.Infrastructure.Configurations;

import FamilyFinances.Business.Handlers.Command.Roles.CreateRoleCommandHandler;
import FamilyFinances.Business.Handlers.Command.Roles.DeleteRoleCommandHandler;
import FamilyFinances.Business.Handlers.Command.Roles.UpdateRoleCommandHandler;
import FamilyFinances.Business.Handlers.Queries.Roles.GetAllRolesQueryHandler;
import FamilyFinances.Business.Interfaces.Queries.Roles.IGetRoleByIdQuery;
import FamilyFinances.Business.Handlers.Queries.Roles.GetRoleByIdQueryHandler;
import FamilyFinances.Business.Interfaces.Commands.Roles.ICreateRoleCommand;
import FamilyFinances.Business.Interfaces.Commands.Roles.IDeleteRoleCommand;
import FamilyFinances.Business.Interfaces.Commands.Roles.IUpdateRoleCommand;
import FamilyFinances.Business.Interfaces.Queries.Roles.IGetAllRolesQuery;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
import FamilyFinances.Business.Interfaces.UseCases.Roles.ICreateRoleService;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IDeleteRoleService;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IGetRolService;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IListAllRolesService;
import FamilyFinances.Business.Interfaces.UseCases.Roles.IUpdateRoleService;
import FamilyFinances.Business.UseCases.Roles.CreateRolService;
import FamilyFinances.Business.UseCases.Roles.DeleteRoleService;
import FamilyFinances.Business.UseCases.Roles.GetRoleService;
import FamilyFinances.Business.UseCases.Roles.ListAllRolesService;
import FamilyFinances.Business.UseCases.Roles.UpdateRoleService;
import FamilyFinances.Controllers.Implements.Roles.CreateRoleController;
import FamilyFinances.Controllers.Implements.Roles.DeleteRoleController;
import FamilyFinances.Controllers.Implements.Roles.GetRoleController;
import FamilyFinances.Controllers.Implements.Roles.ListAllRolesController;
import FamilyFinances.Controllers.Implements.Roles.UpdateRoleController;
import FamilyFinances.Controllers.Interfaces.Roles.ICreateRoleController;
import FamilyFinances.Controllers.Interfaces.Roles.IDeleteRoleController;
import FamilyFinances.Controllers.Interfaces.Roles.IGetRoleController;
import FamilyFinances.Controllers.Interfaces.Roles.IListAllRolesController;
import FamilyFinances.Controllers.Interfaces.Roles.IUpdateRoleController;
import FamilyFinances.Infrastructure.Persistence.Repositories.RoleMemoryRepository;

/**
 *
 * @author johnarrieta
 */
public class RoleDependencyInjectionFactory {
    
    public static void registerDependencies(DependencyContainer container) {
        
        // Registrar la dependencia del respositorio de Roles
        container.register(IRoleRepository.class, RoleMemoryRepository::new);
        
        // Registrar las dependencias de la Query GetRoleById
        
        container.register(IGetRoleByIdQuery.class, () -> 
            new GetRoleByIdQueryHandler(container.resolve(IRoleRepository.class)));
        
        container.register(IGetRolService.class, () -> 
            new GetRoleService(container.resolve(IGetRoleByIdQuery.class)));
        
        container.register(IGetRoleController.class, () ->
            new GetRoleController(container.resolve(IGetRolService.class)));
        
        // Registrar las dependencias del Command CreateRole
        
        container.register(ICreateRoleCommand.class, () -> 
            new CreateRoleCommandHandler(container.resolve(IRoleRepository.class)));
        
        container.register(ICreateRoleService.class, () -> 
            new CreateRolService(container.resolve(ICreateRoleCommand.class)));
        
        container.register(ICreateRoleController.class, () -> 
                new CreateRoleController(container.resolve(ICreateRoleService.class)));
        
        // Registrar las dependencias del Command UpdateRole
        
        container.register(IUpdateRoleCommand.class, () -> 
                new UpdateRoleCommandHandler(container.resolve(IRoleRepository.class)));
        
         container.register(IUpdateRoleService.class, () -> 
                new UpdateRoleService(container.resolve(IUpdateRoleCommand.class)));
         
         container.register(IUpdateRoleController.class, () -> 
                 new UpdateRoleController(container.resolve(IUpdateRoleService.class)));
         
         // Registrar las dependencias del Command DeleteRole
         
         container.register(IDeleteRoleCommand.class, () -> 
                    new DeleteRoleCommandHandler(container.resolve(IRoleRepository.class)));
         
          container.register(IDeleteRoleService.class, () -> 
                    new DeleteRoleService(container.resolve(IDeleteRoleCommand.class)));
          
          container.register(IDeleteRoleController.class, () -> 
                    new DeleteRoleController(container.resolve(IDeleteRoleService.class)));
          
          // Registrar las dependencias del Query GetAllRoles
          
          container.register(IGetAllRolesQuery.class, () -> 
                  new GetAllRolesQueryHandler(container.resolve(IRoleRepository.class)));
          
          container.register(IListAllRolesService.class, () ->
                  new ListAllRolesService(container.resolve(IGetAllRolesQuery.class)));
                    
           container.register(IListAllRolesController.class, () ->
                  new ListAllRolesController(container.resolve(IListAllRolesService.class)));
          
    }
}





