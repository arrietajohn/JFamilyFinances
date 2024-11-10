package FamilyFinances.Business.Interfaces.UseCases.Famlies;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByNameQueryRequest;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetFamilesService {

    public List<Family> getFamilies(FindFamilyByNameQueryRequest request) throws Exception;

    public List<Family> getFamilies() throws Exception;
}
