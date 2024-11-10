package FamilyFinances.Business.Interfaces.UseCases.Famlies;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.CreateFamilyCommandRequest;
import FamilyFinances.Business.Handlers.Queries.Families.Dto.UpdateFamilyCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateFamilyService {
    public void updateFamily(UpdateFamilyCommandRequest request) throws Exception;
}
