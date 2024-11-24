package FamilyFinances.Business.Interfaces.UseCases.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Queries.Members.Dto.GetMembersByPamareterQueryRequest;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.Member;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetMembersByParameterService {

    public List<Member> getMembers(Family family,GetMembersByPamareterQueryRequest request)
            throws MemberEntityNotFoundException, Exception;
}
