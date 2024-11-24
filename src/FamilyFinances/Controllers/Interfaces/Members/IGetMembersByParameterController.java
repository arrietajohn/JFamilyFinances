package FamilyFinances.Controllers.Interfaces.Members;

import FamilyFinances.Commons.Helpers.GenericParameter;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.Member;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public interface IGetMembersByParameterController {
    public List<Member> executeAction(Family family, GenericParameter<?, ?, ?> parameter) throws Exception;
}
