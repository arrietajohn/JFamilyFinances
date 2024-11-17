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

    private final IGetMemberService getMemberSercice;

    public GetMemberController(IGetMemberService getMemberSercice) {
        this.getMemberSercice = getMemberSercice;
    }
    
    
    @Override
    public Member excuteAction(Integer memberId) throws Exception {
        var request = new FindMemberByIdQueryRequest(memberId);
        return getMemberSercice.getMember(request);

    }

}
