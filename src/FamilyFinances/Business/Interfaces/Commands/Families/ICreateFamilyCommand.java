package FamilyFinances.Business.Interfaces.Commands.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.CreateFamilyCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface ICreateFamilyCommand {
    public void handler(CreateFamilyCommandRequest request) throws Exception;
}
