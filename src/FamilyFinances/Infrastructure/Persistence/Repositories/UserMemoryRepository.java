package FamilyFinances.Infrastructure.Persistence.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateUserEntityException;
import FamilyFinances.Business.Exceptions.UserEntityNotFoundException;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Infrastructure.Persistence.Data.InMemoryEntitiesStorage;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author johnarrieta
 */
public class UserMemoryRepository implements IUserRepository {

    private final InMemoryEntitiesStorage entityStorage;
    private static AtomicInteger incrementId;

    public UserMemoryRepository() {
        this.entityStorage = InMemoryEntitiesStorage.getInstance();
        if (incrementId == null) {
            incrementId = new AtomicInteger();
        }

    }

    @Override
    public User findById(Integer id) throws UserEntityNotFoundException, Exception {
        var user = entityStorage.getUsers().get(id);
        if (user == null) {
            var message = "El Usuario con ID: " + id + " no existe";
            throw new UserEntityNotFoundException(message);
        }
        return user;
    }

    @Override
    public User findByCode(String code) throws UserEntityNotFoundException, IllegalArgumentException, Exception  {
        if (code == null || code.trim().isEmpty()) {
            var message = "El Codigo del usuario es requerido";
            throw new IllegalArgumentException(message);
        }
        var userFound = getUserByCode(code);
        if (!userFound.isPresent()) {
            var message = "El Usuario: " + code + " no existe";
            throw new UserEntityNotFoundException(message);
        }
        return userFound.get();
    }

    @Override
    public List<User> getAll() throws UserEntityNotFoundException, Exception  {
        if (entityStorage.getUsers().isEmpty()) {
            var message = "No existen Usuarios disponibles en el sistema";
            throw new UserEntityNotFoundException(message);
        }
        return new ArrayList<User>(entityStorage.getUsers().values());
    }

    @Override
    public void save(User user) throws DuplicateUserEntityException, IllegalArgumentException, Exception {
        if (user == null) {
            var message = "El Usuario no puede ser null";
            throw new IllegalArgumentException(message);
        }

        if (user.getCode() == null || user.getCode().isBlank()) {
            var message = "El Codigo de Usuario es requerido";
            throw new IllegalArgumentException(message);
        }

        if (user.getRole() == null) {
            var message = "El usuario debe tener un rol valido";
            throw new IllegalArgumentException(message);
        }

        var userFound = getUserByCode(user.getCode());
        if (userFound.isPresent()) {
            var message = "Existe un Usuario con codigo: " + user.getCode();
            throw new DuplicateUserEntityException(message);
        }
        
        userFound = getUserByCode(user.getEmail());
        if (userFound.isPresent()) {
            var message = "Existe un Usuario con email: " + user.getEmail();
            throw new DuplicateUserEntityException(message);
        }
        user.setId(getNextId());
        entityStorage.getUsers().put(user.getId(), user);
    }

    @Override
    public void edit(User user) throws UserEntityNotFoundException, IllegalArgumentException, Exception {
        if (user == null) {
            var message = "El Usuario no puede ser null";
            throw new IllegalArgumentException(message);
        }
        var userFound = entityStorage.getUsers().get(user.getId());
        if (userFound == null) {
            var message = "El Usuario: " + user.getId() + " no existe";
            throw new UserEntityNotFoundException(message);
        }
        userFound.setPassword(user.getPassword());
        userFound.setName(user.getName());
        userFound.setEmail(user.getEmail());
        userFound.setStatus(user.getStatus());
        userFound.setUpdateBy(user.getUpdateBy());
        userFound.setRole(user.getRole());
        userFound.setUpdateDate(user.getUpdateDate());
        //  entityStorage.getUsers().put(user.getId(), user);
    }

    @Override
    public void deleteById(Integer id) throws  UserEntityNotFoundException, Exception {

        if (!entityStorage.getUsers().containsKey(id)) {
            var message = "El Usuario: " + id + " no existe";
            throw new UserEntityNotFoundException(message);
        }
        entityStorage.getUsers().remove(id);
    }

    private Optional<User> getUserByCode(String code) {
        return entityStorage.getUsers()
                .values()
                .stream()
                .filter(u -> u.getCode().equalsIgnoreCase(code))
                .findFirst();
    }
    
     private Optional<User> getUserByEmail(String email) {
        return entityStorage.getUsers()
                .values()
                .stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }
    
    private int getNextId(){
        return entityStorage.getUsers()
                .values()
                .stream()
                .map(User::getId)
                .max(Comparator.naturalOrder())
                .orElse(1);
    }
}
