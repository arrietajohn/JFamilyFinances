package FamilyFinances.Business.UseCases.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.DeleteMemberCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Members.IDeleteMemberCommand;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamilyService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;
import FamilyFinances.Business.Interfaces.UseCases.Members.IDeleteMemberService;

/**
 *
 * @author johnarrieta
 */
public class DeleteMemberService implements IDeleteMemberService{

    private final IGetUsersService getUserService;
    private final IDeleteMemberCommand deleteMemberCommand;
    private final IGetFamilyService getFamilyService;

    public DeleteMemberService(IGetUsersService getUserService, IDeleteMemberCommand deleteMemberCommand, IGetFamilyService getFamilyService) {
        this.getUserService = getUserService;
        this.deleteMemberCommand = deleteMemberCommand;
        this.getFamilyService = getFamilyService;
    }


    @Override
    public void deleteMember(DeleteMemberCommandRequest request) throws MemberEntityNotFoundException, Exception {
        deleteMemberCommand.handler(request);
        var currentUser = getUserService.getUserById(request.getMemberId());
        var family = (currentUser.getMember() != null )?  currentUser.getMember().getFamily() : null;
        if(family == null)
        {
            return;
        }
        var members = family.getMembers();
        if(members == null || members.isEmpty()){
            return;
        }
         
        members.removeIf(m -> m.getId() == request.getMemberId());
        currentUser.setMember(null);
    }

}
