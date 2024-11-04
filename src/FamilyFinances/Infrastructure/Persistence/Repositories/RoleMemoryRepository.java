
package FamilyFinances.Infrastructure.Persistence.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateEntityException;
import FamilyFinances.Business.Exceptions.EntityNotFoundException;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Infrastructure.Persistence.Data.InMemoryEntitiesStorage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class RoleMemoryRepository implements IRoleRepository {
    
    private final InMemoryEntitiesStorage entityStorage;

    public RoleMemoryRepository() {
        this.entityStorage = InMemoryEntitiesStorage.getInstance();
    }
    
    @Override
    public Role findById(Integer id) throws EntityNotFoundException, Exception {
        var role = entityStorage.getRoles().get(id);
        if(role == null){
            var message = "El Rol con ID: " +id + " no existe";
            throw new EntityNotFoundException(message);
        }
        return role;
    }

    @Override
    public List<Role> getAll() throws Exception {
        if(entityStorage.getRoles().isEmpty()){
            var message = "No existen roles disponibles en el sistema";
            throw new EntityNotFoundException(message);
        }
        return new ArrayList<Role>(entityStorage.getRoles().values()) ;
    }

    @Override
    public void save(Role role) throws DuplicateEntityException, Exception {
        if(role == null){
            var message = "El Rol no puede ser null";
            throw new Exception(message);
        }
        
        if(entityStorage.getRoles().containsKey(role.getId())){
            var message = "El Rol: "+role.getId() + " ya existe";
            throw new DuplicateEntityException(message);
        }
        
        entityStorage.getRoles().put(role.getId(), role);
    }

    @Override
    public void edit(Role role) throws EntityNotFoundException, Exception {
        if(role == null){
            var message = "El Rol no puede ser null";
            throw new Exception(message);
        }
        
        if(!entityStorage.getRoles().containsKey(role.getId())){
            var message = "El Rol: "+role.getId() + " no existe";
            throw new EntityNotFoundException(message);
        }
        entityStorage.getRoles().put(role.getId(), role);
    }

    @Override
    public void deleteById(Integer id) throws EntityNotFoundException, Exception {
        
        if(!entityStorage.getRoles().containsKey(id)){
            var message = "El Rol: "+id+ " no existe";
            throw new EntityNotFoundException(message);
        }
        entityStorage.getRoles().remove(id);
    }
}


    