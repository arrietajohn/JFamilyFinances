package FamilyFinances.Business.Interfaces.UseCases.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByNameQueryRequest;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetFamiliesService {

    public List<Family> getFamilies(FindFamilyByNameQueryRequest request) throws Exception;

    public List<Family> getFamilies() throws Exception;
}
