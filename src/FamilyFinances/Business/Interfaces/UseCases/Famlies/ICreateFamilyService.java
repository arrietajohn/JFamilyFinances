package FamilyFinances.Business.Interfaces.UseCases.Famlies;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.CreateFamilyCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface ICreateFamilyService {
    public void createFamily(CreateFamilyCommandRequest request) throws Exception;
}
