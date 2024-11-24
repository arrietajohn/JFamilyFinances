package FamilyFinances.Business.Interfaces.Queries.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Queries.Members.Dto.GetMembersByPamareterQueryRequest;
import FamilyFinances.Domain.Models.Member;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetMembersByParameterQuery {

    public List<Member> handler(GetMembersByPamareterQueryRequest request)
            throws MemberEntityNotFoundException, Exception;
}
