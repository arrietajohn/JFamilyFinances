package FamilyFinances.Business.Interfaces.UseCases.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.DeleteMemberCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteMemberService {
    public void deleteMember(DeleteMemberCommandRequest request) throws MemberEntityNotFoundException, Exception;
}
