package FamilyFinances.Controllers.Implements.Families;

import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByNameQueryRequest;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamiliesService;
import FamilyFinances.Controllers.Interfaces.Families.IGetFamiliesController;
import FamilyFinances.Domain.Models.Family;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class GetFamiliesController implements IGetFamiliesController {

    private final IGetFamiliesService getFamiliesService;

    public GetFamiliesController(IGetFamiliesService GetFamiliesService) {
        this.getFamiliesService = GetFamiliesService;
    }

    @Override
    public List<Family> executeAction(String name) throws Exception {
        var request = new FindFamilyByNameQueryRequest(name);
        return getFamiliesService.getFamilies(request);
        
    }

    @Override
    public List<Family> executeAction() throws Exception {
         return getFamiliesService.getFamilies();
    }

}
