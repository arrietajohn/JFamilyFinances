package FamilyFinances.Business.Handlers.Command.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.DeleteFamilyByIdCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Families.IDeleteFamilyCommand;
import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;

/**
 *
 * @author johnarrieta
 */
public class DeleteFamilyByIdCommandHandler implements IDeleteFamilyCommand{

    private final IFamilyRepository familyRepository;

    public DeleteFamilyByIdCommandHandler(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }
    
    
    @Override
    public void handler(DeleteFamilyByIdCommandRequest request) throws Exception {
        familyRepository.deleteById(request.getFamilyId());
    }

}
