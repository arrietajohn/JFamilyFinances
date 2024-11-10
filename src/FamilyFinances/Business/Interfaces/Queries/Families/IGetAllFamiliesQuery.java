package FamilyFinances.Business.Interfaces.Queries.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByIdQueryRequest;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetAllFamiliesQuery {
    public List<Family>  handler() throws Exception;
}
