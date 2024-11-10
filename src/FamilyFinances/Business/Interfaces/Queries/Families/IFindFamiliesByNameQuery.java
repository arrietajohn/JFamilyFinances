package FamilyFinances.Business.Interfaces.Queries.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByNameQueryRequest;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IFindFamiliesByNameQuery {
    public List<Family>  handler(FindFamilyByNameQueryRequest request) throws Exception;
}
