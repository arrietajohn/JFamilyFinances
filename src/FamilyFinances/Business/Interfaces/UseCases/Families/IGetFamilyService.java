package FamilyFinances.Business.Interfaces.UseCases.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByIdQueryRequest;
import FamilyFinances.Domain.Models.Family;

/**
 *
 * @author johnarrieta
 */
public interface IGetFamilyService {
    public Family getFamily(FindFamilyByIdQueryRequest request) throws Exception;

}
