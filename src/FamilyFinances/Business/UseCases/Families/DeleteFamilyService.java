package FamilyFinances.Business.UseCases.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.DeleteFamilyByIdCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Families.IDeleteFamilyCommand;
import FamilyFinances.Business.Interfaces.UseCases.Families.IDeleteFamilyService;


/**
 *
 * @author johnarrieta
 */
public class DeleteFamilyService implements IDeleteFamilyService{

    private final IDeleteFamilyCommand deleteFamilyCommand;

    public DeleteFamilyService(IDeleteFamilyCommand deleteFamilyCommand) {
        this.deleteFamilyCommand = deleteFamilyCommand;
    }

    @Override
    public void deleteFamily(DeleteFamilyByIdCommandRequest request) throws Exception {
        deleteFamilyCommand.handler(request);
    }

}
