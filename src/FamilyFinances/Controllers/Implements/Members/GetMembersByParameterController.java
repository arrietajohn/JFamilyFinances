package FamilyFinances.Controllers.Implements.Members;

import FamilyFinances.Business.Handlers.Queries.Members.Dto.GetMembersByPamareterQueryRequest;
import FamilyFinances.Business.Interfaces.UseCases.Members.IGetMembersByParameterService;
import FamilyFinances.Commons.Helpers.GenericParameter;
import FamilyFinances.Controllers.Interfaces.Members.IGetMembersByParameterController;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.Member;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class GetMembersByParameterController implements IGetMembersByParameterController{

    private final IGetMembersByParameterService getMemberByParameterService;

    public GetMembersByParameterController(IGetMembersByParameterService getMemberByParameterService) {
        this.getMemberByParameterService = getMemberByParameterService;
    }

    @Override
    public List<Member> executeAction(Family family, GenericParameter<?, ?, ?> parameter) throws Exception {
        var request = new GetMembersByPamareterQueryRequest(parameter);
        return getMemberByParameterService.getMembers(family, request);
    }
    
    
}
