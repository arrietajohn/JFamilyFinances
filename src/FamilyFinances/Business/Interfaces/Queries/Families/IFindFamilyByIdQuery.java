package FamilyFinances.Business.Interfaces.Queries.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByIdQueryRequest;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IFindFamilyByIdQuery {
    public Family handler(FindFamilyByIdQueryRequest request) throws Exception;
}
