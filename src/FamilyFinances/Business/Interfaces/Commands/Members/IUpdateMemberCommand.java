package FamilyFinances.Business.Interfaces.Commands.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.UpdateMemberCommandRequest;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateMemberCommand {
    public Member handler(UpdateMemberCommandRequest request) throws MemberEntityNotFoundException, Exception;
}
