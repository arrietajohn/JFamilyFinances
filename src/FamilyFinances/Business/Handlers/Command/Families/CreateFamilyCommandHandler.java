package FamilyFinances.Business.Handlers.Command.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.CreateFamilyCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Families.ICreateFamilyCommand;
import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;
import FamilyFinances.Domain.Models.Family;

/**
 *
 * @author johnarrieta
 */
public class CreateFamilyCommandHandler implements ICreateFamilyCommand{

    private final IFamilyRepository familyRepository;

    public CreateFamilyCommandHandler(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }
    
    
    @Override
    public void handler(CreateFamilyCommandRequest request) throws Exception {
        var famaly = new Family(
                null // el ID
                , request.getName()
                , request.getPhoneNumber()
                , request.getAddress()
                , request.getCreationDate()
                , request.getCreatedBy()
                , request.getStatus())
        ;
        familyRepository.save(famaly);
    }

}
