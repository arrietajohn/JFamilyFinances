package FamilyFinances.Business.Interfaces.Commands.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.DeleteFamilyByIdCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteFamilyCommand {
    public void handler(DeleteFamilyByIdCommandRequest request) throws Exception;
}
