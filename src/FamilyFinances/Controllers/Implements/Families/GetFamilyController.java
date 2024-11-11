package FamilyFinances.Controllers.Implements.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByIdQueryRequest;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamilyService;
import FamilyFinances.Controllers.Interfaces.Families.IGetFamilyController;
import FamilyFinances.Domain.Models.Family;

/**
 *
 * @author johnarrieta
 */
public class GetFamilyController implements IGetFamilyController{

    private final IGetFamilyService getFamilyService;
    private Family currentFamily;
    
    public GetFamilyController(IGetFamilyService getFamilyService) {
        this.getFamilyService = getFamilyService;
    }
    
    
    @Override
    public Family executeAction(Integer familyId) throws Exception {
        var request = new FindFamilyByIdQueryRequest(familyId);
        return getFamilyService.getFamily(request);
    }

    @Override
    public Family getCurrentFamily() {
        return currentFamily;
    }

}
