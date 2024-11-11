package FamilyFinances.Controllers.Implements.Families;

import FamilyFinances.Business.Handlers.Command.Families.Dto.DeleteFamilyByIdCommandRequest;
import FamilyFinances.Business.Interfaces.UseCases.Families.IDeleteFamilyService;
import FamilyFinances.Controllers.Interfaces.Families.IDeleteFamilyController;

/**
 *
 * @author johnarrieta
 */
public class DeleteFamilyController implements IDeleteFamilyController{

    private final IDeleteFamilyService deleteFamilyService;

    public DeleteFamilyController(IDeleteFamilyService deleteFamilyService) {
        this.deleteFamilyService = deleteFamilyService;
    }
    
    
    @Override
    public void exectuteAction(Integer familyId) throws Exception {
        var request = new DeleteFamilyByIdCommandRequest(familyId);
        deleteFamilyService.deleteFamily(request);
    }

}
