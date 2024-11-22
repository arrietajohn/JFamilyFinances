package FamilyFinances.Controllers.ImplementsMembers;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.DeleteMemberCommandRequest;
import FamilyFinances.Business.Interfaces.UseCases.Members.IDeleteMemberService;

/**
 *
 * @author johnarrieta
 */
public class DeleteMemberController implements IDeleteMemberController {

    private final IDeleteMemberService deleteMemberService;

    public DeleteMemberController(IDeleteMemberService deleteMemberService) {
        this.deleteMemberService = deleteMemberService;
    }

    @Override
    public void executeAction(Integer memberId) throws MemberEntityNotFoundException, Exception {
        var request = new DeleteMemberCommandRequest(memberId);
        deleteMemberService.deleteMember(request);
    }

}
