package FamilyFinances.Business.Interfaces.Repositories;

import FamilyFinances.Business.Exceptions.DuplicateFamilyEntityException;
import FamilyFinances.Business.Exceptions.FamilyEntityNotFoundException;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface FamilyRepository {

    public Family findById(Integer id) throws FamilyEntityNotFoundException, Exception;

    public Family findByCode(String code) throws FamilyEntityNotFoundException, Exception;

    public List<Family> getAll() throws Exception;

    public void save(Family family) throws DuplicateFamilyEntityException, Exception;

    public void edit(Family family) throws FamilyEntityNotFoundException, Exception;

    public void deleteById(Integer id) throws FamilyEntityNotFoundException, Exception;
}
