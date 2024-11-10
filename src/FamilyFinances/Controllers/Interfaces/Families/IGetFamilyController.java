package FamilyFinances.Controllers.Interfaces.Families;

import FamilyFinances.Domain.Models.Family;

/**
 *
 * @author johnarrieta
 */
public interface IGetFamilyController {

    public Family excuteAction(Integer id) throws Exception;
}
