package FamilyFinances.Controllers.Implements.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.CreateFamilyCommandRequest;
import FamilyFinances.Business.Interfaces.UseCases.Families.ICreateFamilyService;
import FamilyFinances.Controllers.Interfaces.Families.ICreateFamilyController;
import FamilyFinances.Domain.Constants.EntityStatusEnum;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class CreateFamilyController implements ICreateFamilyController{

    private final ICreateFamilyService createFamilyService;

    public CreateFamilyController(ICreateFamilyService createFamilyService) {
        this.createFamilyService = createFamilyService;
    }
    
    
    @Override
    public void executeAction(String name, String phoneNumber, String address, LocalDateTime creationDate, User createdBy, EntityStatusEnum status) throws Exception {
        var request = new CreateFamilyCommandRequest(name, phoneNumber, address, creationDate, createdBy, status);
        createFamilyService.createFamily(request);
    }
    

}
