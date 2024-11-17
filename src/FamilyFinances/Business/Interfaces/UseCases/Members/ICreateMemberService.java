package FamilyFinances.Business.Interfaces.UseCases.Members;

import FamilyFinances.Business.Handlers.Command.Members.Dto.CreateMemberCommandRequest;

/**
 *
 * @author johnarrieta
 */
public interface ICreateMemberService {
    public void createMember(CreateMemberCommandRequest request) throws Exception;
}
