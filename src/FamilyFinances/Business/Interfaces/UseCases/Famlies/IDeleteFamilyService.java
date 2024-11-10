package FamilyFinances.Business.Interfaces.UseCases.Famlies;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.DeleteFamilyByIdCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteFamilyService {
    public void deleteFamily(DeleteFamilyByIdCommandRequest request) throws Exception;
}
