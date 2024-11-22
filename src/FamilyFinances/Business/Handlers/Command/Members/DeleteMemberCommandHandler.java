package FamilyFinances.Business.Handlers.Command.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.DeleteMemberCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Members.IDeleteMemberCommand;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;

/**
 *
 * @author johnarrieta
 */
public class DeleteMemberCommandHandler implements IDeleteMemberCommand {

    private final IMemberRepository memberRepository;

    public DeleteMemberCommandHandler(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    @Override
    public void handler(DeleteMemberCommandRequest request) throws MemberEntityNotFoundException, Exception {
        memberRepository.deleteById(request.getMemberId());
    }

}
