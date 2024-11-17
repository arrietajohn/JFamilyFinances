package FamilyFinances.Business.Interfaces.Commands.Members;

import FamilyFinances.Business.Exceptions.DuplicateMemberEntityException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.CreateMemberCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface ICreateMemberCommand {
    public void handler(CreateMemberCommandRequest request) throws DuplicateMemberEntityException, Exception;
}
