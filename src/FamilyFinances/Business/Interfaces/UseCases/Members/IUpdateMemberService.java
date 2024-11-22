package FamilyFinances.Business.Interfaces.UseCases.Members;

import FamilyFinances.Business.Handlers.Command.Members.Dto.UpdateMemberCommandRequest;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateMemberService {
    public Member updateMember(UpdateMemberCommandRequest request) throws Exception;
}
