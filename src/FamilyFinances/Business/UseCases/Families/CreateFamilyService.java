package FamilyFinances.Business.UseCases.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.CreateFamilyCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Families.ICreateFamilyCommand;
import FamilyFinances.Business.Interfaces.UseCases.Families.ICreateFamilyService;

/**
 *
 * @author johnarrieta
 */
public class CreateFamilyService implements ICreateFamilyService{

    private final ICreateFamilyCommand createFamilyCommand;

    public CreateFamilyService(ICreateFamilyCommand createFamilyCommand) {
        this.createFamilyCommand = createFamilyCommand;
    }
    
    
    @Override
    public void createFamily(CreateFamilyCommandRequest request) throws Exception {
        createFamilyCommand.handler(request);
    }

}
