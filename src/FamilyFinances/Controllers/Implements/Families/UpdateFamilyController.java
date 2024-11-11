package FamilyFinances.Controllers.Implements.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.UpdateFamilyCommandRequest;
import FamilyFinances.Business.Interfaces.UseCases.Families.IUpdateFamilyService;
import FamilyFinances.Controllers.Interfaces.Families.IUpdateFamilyController;
import FamilyFinances.Domain.Constants.EntityStatusEnum;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class UpdateFamilyController implements IUpdateFamilyController {

    private final IUpdateFamilyService updateFamilyService;

    public UpdateFamilyController(IUpdateFamilyService updateFamilyService) {
        this.updateFamilyService = updateFamilyService;
    }

    @Override
    public void executeAction(Integer id, String name, String phoneNumber, String address, LocalDateTime updatedDate, User updatedBy, EntityStatusEnum status) throws Exception {
        var request = new UpdateFamilyCommandRequest(id, name, phoneNumber, address, updatedDate, updatedBy, status);
        updateFamilyService.updateFamily(request);
    }

}
