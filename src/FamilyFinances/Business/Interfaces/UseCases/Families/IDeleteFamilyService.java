package FamilyFinances.Business.Interfaces.UseCases.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.DeleteFamilyByIdCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteFamilyService {
    public void deleteFamily(DeleteFamilyByIdCommandRequest request) throws Exception;
}
