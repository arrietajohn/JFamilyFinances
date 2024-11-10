package FamilyFinances.Business.Interfaces.UseCases.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.CreateFamilyCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface ICreateFamilyService {
    public void createFamily(CreateFamilyCommandRequest request) throws Exception;
}
