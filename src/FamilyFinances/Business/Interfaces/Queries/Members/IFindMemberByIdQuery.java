package FamilyFinances.Business.Interfaces.Queries.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Queries.Members.Dto.FindMemberByIdQueryRequest;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public interface IFindMemberByIdQuery {
    public Member handler(FindMemberByIdQueryRequest request) throws MemberEntityNotFoundException, Exception;
}
