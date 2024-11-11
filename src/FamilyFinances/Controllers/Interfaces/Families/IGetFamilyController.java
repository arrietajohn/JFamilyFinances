package FamilyFinances.Controllers.Interfaces.Families;

import FamilyFinances.Domain.Models.Family;

/**
 *
 * @author johnarrieta
 */
public interface IGetFamilyController {
    public Family executeAction(Integer familyId) throws Exception;
    public Family getCurrentFamily();
}
