package FamilyFinances.Business.Interfaces.UseCases.Members;

import FamilyFinances.Business.Handlers.Queries.Members.Dto.FindMemberByIdQueryRequest;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public interface IGetMemberService {
    public Member getMember(FindMemberByIdQueryRequest request) throws Exception;
}
