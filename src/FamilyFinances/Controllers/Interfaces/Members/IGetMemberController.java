package FamilyFinances.Controllers.Interfaces.Members;

import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public interface IGetMemberController {
    public Member executeAction(Integer memberId) throws Exception;
}

