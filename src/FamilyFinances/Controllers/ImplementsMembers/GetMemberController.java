package FamilyFinances.Controllers.ImplementsMembers;

import FamilyFinances.Business.Handlers.Queries.Members.Dto.FindMemberByIdQueryRequest;
import FamilyFinances.Business.Interfaces.UseCases.Members.IGetMemberService;
import FamilyFinances.Controllers.Interfaces.Members.IGetMemberController;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public class GetMemberController implements IGetMemberController{

    private final IGetMemberService getMemberService;

    public GetMemberController(IGetMemberService getMemberService) {
        this.getMemberService = getMemberService;
    }
    
    @Override
    public Member executeAction(Integer memberId) throws Exception {
        var request = new FindMemberByIdQueryRequest(memberId);
        return getMemberService.getMember(request);
    }

}
