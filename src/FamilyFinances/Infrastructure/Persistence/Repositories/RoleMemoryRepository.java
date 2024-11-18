package FamilyFinances.Infrastructure.Persistence.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateRoleEntityException;
import FamilyFinances.Business.Exceptions.RoleEntityNotFoundException;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
import FamilyFinances.Domain.Constants.EntityStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Infrastructure.Persistence.Data.InMemoryEntitiesStorage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
    public Role findById(Integer id) throws RoleEntityNotFoundException, Exception {
        var role = entityStorage.getRoles().get(id);
        if (role == null) {
            var message = "El Rol con ID: " + id + " no existe";
            throw new RoleEntityNotFoundException(message);
        }
        return role;
    }

    @Override
    public List<Role> getAll() throws Exception {
        if (entityStorage.getRoles().isEmpty()) {
            var message = "No existen roles disponibles en el sistema";
            throw new RoleEntityNotFoundException(message);
        }
        return new ArrayList<Role>(entityStorage.getRoles().values());
    }

    @Override
    public void save(Role role) throws DuplicateRoleEntityException, Exception {
        if (role == null) {
            var message = "El Rol no puede ser null";
            throw new Exception(message);
        }

        if (entityStorage.getRoles().containsKey(role.getId())) {
            var message = "El Rol: " + role.getId() + " ya existe";
            throw new DuplicateRoleEntityException(message);
        }

        var roleFound = getRoleByName(role.getName());
        if (roleFound.isPresent()) {
            var message = "El Rol: " + role.getName() + " ya existe";
            throw new DuplicateRoleEntityException(message);
        }
        entityStorage.getRoles().put(role.getId(), role);
    }

    @Override
    public void edit(Role role) throws RoleEntityNotFoundException, Exception {
        if (role == null) {
            var message = "El Rol no puede ser null";
            throw new Exception(message);
        }

        if (!entityStorage.getRoles().containsKey(role.getId())) {
            var message = "El Rol: " + role.getId() + " no existe";
            throw new RoleEntityNotFoundException(message);
        }

        var roleFound = getRoleByName(role.getName());
        if (roleFound.isPresent() && role.getId() != roleFound.get().getId()) {
            var message = "El Rol: " + role.getId() + " ya existe";
            throw new DuplicateRoleEntityException(message);
        }
        entityStorage.getRoles().replace(role.getId(), role);
    }

    @Override
    public void deleteById(Integer id) throws RoleEntityNotFoundException, Exception {

        if (!entityStorage.getRoles().containsKey(id)) {
            var message = "El Rol: " + id + " no existe";
            throw new RoleEntityNotFoundException(message);
        }
        entityStorage.getRoles().remove(id);
    }

    private Optional<Role> getRoleByName(String name) {
        return entityStorage.getRoles()
                .values()
                .stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .findAny();
    }

    @Override
    public List<Role> findRoleByName(String name) throws RoleEntityNotFoundException, Exception {
        var roles = entityStorage.getRoles()
                .values()
                .stream()
                .filter(r -> r.getName().equalsIgnoreCase(name))
                .toList();
        
        if (roles.isEmpty()) {
            throw new RoleEntityNotFoundException("No existe un con con nombre: " + name);
        }
        return roles;
    }

    @Override
    public List<Role> findRoleByDescripcion(String description) throws RoleEntityNotFoundException, Exception {
         var roles = entityStorage.getRoles()
                .values()
                .stream()
                .filter(r -> r.getDescription()
                        .toLowerCase()
                        .contains(description.toLowerCase()))
                 .toList();
        
        if (roles.isEmpty()) {
            throw new RoleEntityNotFoundException("No existe un con descricion: " + description);
        }
        return roles;
    }

    @Override
    public List<Role> findRoleByStatus(EntityStatusEnum status) throws RoleEntityNotFoundException, Exception {
         var roles = entityStorage.getRoles()
                .values()
                .stream()
                .filter(r -> r.getStatus()== status)
                 .toList();
        
        if (roles.isEmpty()) {
            throw new RoleEntityNotFoundException("No existe un con con nombre: " + status);
        }
        return roles;
    }
}
