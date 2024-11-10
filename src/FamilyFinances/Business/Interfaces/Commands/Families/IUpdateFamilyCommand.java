package FamilyFinances.Business.Interfaces.Commands.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.UpdateFamilyCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateFamilyCommand {
    public void handler(UpdateFamilyCommandRequest request) throws Exception;
}
