package FamilyFinances.Controllers.Implements.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;

/**
 *
 * @author johnarrieta
 */
public interface IDeleteMemberController {
    public void executeAction(Integer memberId) throws MemberEntityNotFoundException, Exception;
}
