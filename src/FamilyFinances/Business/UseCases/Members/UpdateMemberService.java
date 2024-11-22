package FamilyFinances.Business.UseCases.Members;

import FamilyFinances.Business.Handlers.Command.Members.Dto.UpdateMemberCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Members.IUpdateMemberCommand;
import FamilyFinances.Business.Interfaces.UseCases.Members.IUpdateMemberService;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public class UpdateMemberService implements IUpdateMemberService{

    private final IUpdateMemberCommand updateMemberCommand;

    public UpdateMemberService(IUpdateMemberCommand updateMemberCommand) {
        this.updateMemberCommand = updateMemberCommand;
    }

    @Override
    public Member updateMember(UpdateMemberCommandRequest request) throws Exception {
       return  updateMemberCommand.handler(request);
    }
    

   

}
