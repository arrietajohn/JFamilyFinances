package FamilyFinances.Business.Handlers.Command.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.UpdateFamilyCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Families.IUpdateFamilyCommand;
import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;
import FamilyFinances.Domain.Models.Family;

/**
 *
 * @author johnarrieta
 */
public class UpdateFamilyCommandHandler implements IUpdateFamilyCommand{

    private final IFamilyRepository familyRepository;

    public UpdateFamilyCommandHandler(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }
    
    
  
    @Override
    public void handler(UpdateFamilyCommandRequest request) throws Exception {
         var famaly = new Family(
                request.getId() // el ID
                , request.getName()
                , request.getPhoneNumber()
                , request.getAddress()
                , null                      // creado por
                , null                      // fecha de creacion
                , request.getStatus());
         famaly.setUpdateBy(request.getUpdatedBy());
         famaly.setUpdateDate(request.getUpdatedDate());
        familyRepository.edit(famaly);
    }

}
