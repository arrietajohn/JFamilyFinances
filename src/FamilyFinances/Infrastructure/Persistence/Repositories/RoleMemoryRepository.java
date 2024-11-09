package FamilyFinances.Infrastructure.Persistence.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateRoleEntityException;
import FamilyFinances.Business.Exceptions.RoleEntityNotFoundException;
import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
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
            var message = "El Rol: " + role.getName()+ " ya existe";
            throw new DuplicateRoleEntityException(message);
        }
        var nextId = getNextId();
        role.setId(nextId);
        entityStorage.getRoles().put(nextId, role);
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
        entityStorage.getRoles().put(role.getId(), role);
    }

    @Override
    public void deleteById(Integer id) throws RoleEntityNotFoundException, Exception {

        if (!entityStorage.getRoles().containsKey(id)) {
            var message = "El Rol: " + id + " no existe";
            throw new RoleEntityNotFoundException(message);
        }
        entityStorage.getRoles().remove(id);
    }

    private int getNextId() {
        return entityStorage.getRoles()
                .values()
                .stream()
                .map(Role::getId)
                .max(Comparator.naturalOrder())
                .orElse(1);
    }

    private Optional<Role> getRoleByName(String name) {
        return entityStorage.getRoles()
                .values()
                .stream()
                .filter(r -> r.getName().equalsIgnoreCase(name)).findAny();
    }
}
