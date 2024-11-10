package FamilyFinances.Business.UseCases.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.UpdateFamilyCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Families.IUpdateFamilyCommand;
import FamilyFinances.Business.Interfaces.UseCases.Families.IUpdateFamilyService;

/**
 *
 * @author johnarrieta
 */
public class UpdateFamilyService implements IUpdateFamilyService{

    private final IUpdateFamilyCommand updateFamilyCommand;

    public UpdateFamilyService(IUpdateFamilyCommand updateFamilyCommand) {
        this.updateFamilyCommand = updateFamilyCommand;
    }

    @Override
    public void updateFamily(UpdateFamilyCommandRequest request) throws Exception {
         updateFamilyCommand.handler(request);
    }

}
