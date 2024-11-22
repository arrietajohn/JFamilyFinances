package FamilyFinances.Controllers.ImplementsMembers;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteMemberController {
    public void executeAction(Integer memberId) throws MemberEntityNotFoundException, Exception;
}
