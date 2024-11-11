package FamilyFinances.Infrastructure.Persistence.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateFamilyEntityException;
import FamilyFinances.Business.Exceptions.FamilyEntityNotFoundException;
import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Infrastructure.Persistence.Data.InMemoryEntitiesStorage;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class FamilyMemoryRepository implements IFamilyRepository {

    private final InMemoryEntitiesStorage memoryEntitiesStorage;

    public FamilyMemoryRepository() {
         this.memoryEntitiesStorage = InMemoryEntitiesStorage.getInstance();
    }

    @Override
    public Family findById(Integer id) throws FamilyEntityNotFoundException, Exception {
        if (memoryEntitiesStorage.getFamilies().isEmpty()) {
            var message = "La familia con Id: " + id + " no existe";
            throw new FamilyEntityNotFoundException(message);
        }

        var family = getFamilyById(id);
        if (family == null) {
            var message = "La familia con Id: " + id + " no existe";
            throw new FamilyEntityNotFoundException(message);
        }
        return family;
    }

    @Override
    public List<Family> findByName(String name) throws FamilyEntityNotFoundException, Exception {
        if (memoryEntitiesStorage.getFamilies().isEmpty()) {
            var message = "La familia con : " + name + " no existe";
            throw new FamilyEntityNotFoundException(message);
        }

        var families = memoryEntitiesStorage.getFamilies()
                .values()
                .stream()
                .filter(f -> f.getName().toUpperCase().contains(name.toUpperCase())).toList();

        if (families.isEmpty()) {
            var message = "No existen familias con el nombre: "+name;
            throw new FamilyEntityNotFoundException(message);
        }
        
        return families;
    }

    @Override
    public List<Family> getAll() throws Exception {
        if (memoryEntitiesStorage.getFamilies().isEmpty()) {
            var message = "No existen familias en el sistema";
            throw new FamilyEntityNotFoundException(message);
        }
        return memoryEntitiesStorage.getFamilies()
                .values()
                .stream()
                .toList();
    }

    @Override
    public void save(Family family) throws DuplicateFamilyEntityException, Exception {
        
        if (family == null) {
            var message = "La Familia es requerida";
            throw new IllegalArgumentException(message);
        }
        if((family.getId() != null && family.getId() > 0) && existFamily(family.getId()) ){
            var message = "Ya existe una familia con el ID: "+family.getId();
            throw new DuplicateFamilyEntityException(message);
        }
        
        var familiId = getNextId();
        family.setId(familiId);
        memoryEntitiesStorage.getFamilies().put(familiId, family);        
    }

    @Override
    public void edit(Family family) throws FamilyEntityNotFoundException, Exception {
        
        if (family == null) {
            var message = "La Familia es requerida";
            throw new IllegalArgumentException(message);
        }
        
        if(family.getId() == null || family.getId() <= 0) {
            var message = "El Id de la familia es requerido:";
            throw new FamilyEntityNotFoundException(message);
        }
        
        var familyFound =  getFamilyById(family.getId());
        if(familyFound == null){
            var message = "No existe una familia con id: "+family.getId();
            throw new FamilyEntityNotFoundException(message);
        }
        familyFound.setName(family.getName());
        familyFound.setAddress(family.getAddress());
        familyFound.setPhoneNumber(family.getPhoneNumber());
        familyFound.setStatus(family.getStatus());
        familyFound.setUpdateBy(family.getUpdateBy());
        familyFound.setUpdateDate(family.getUpdateDate());
        memoryEntitiesStorage.getFamilies().replace(familyFound.getId(), familyFound); 
    }

    @Override
    public void deleteById(Integer id) throws FamilyEntityNotFoundException, Exception {
       
        
        if(id == null || id <= 0  || !existFamily(id) ){
            var message = "No existe una familia con id: "+id;
            throw new FamilyEntityNotFoundException(message);
        }

        memoryEntitiesStorage.getFamilies().remove(id); 
    }

    
    private int getNextId(){
        return (memoryEntitiesStorage.getFamilies()
                .values()
                .stream()
                .map(Family::getId)
                .max(Comparator.naturalOrder())
                .orElse(0))+1;
    }
    
    private Family getFamilyById(Integer id){
       return memoryEntitiesStorage.getFamilies().get(id);
    }
    
    private boolean existFamily(Integer id){
       return memoryEntitiesStorage.getFamilies().containsKey(id);
    }
    
}
