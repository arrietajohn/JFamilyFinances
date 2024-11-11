package FamilyFinances.Business.Interfaces.UseCases.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.CreateFamilyCommandRequest;
import FamilyFinances.Business.Handlers.Command.Families.Dto.UpdateFamilyCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateFamilyService {
    public void updateFamily(UpdateFamilyCommandRequest request) throws Exception;
}
