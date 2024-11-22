package FamilyFinances.Business.Interfaces.Commands.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.DeleteMemberCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteMemberCommand {
    public void handler(DeleteMemberCommandRequest request) throws MemberEntityNotFoundException, Exception;
}
