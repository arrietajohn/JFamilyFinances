package FamilyFinances.Controllers.Interfaces.Families;

import FamilyFinances.Domain.Constants.EntityStatusEnum;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public interface IUpdateFamilyController {

    public void excuteAction(Integer id, String name, String phoneNumber,
            String address, LocalDateTime updatedDate, User updatedBy,
            EntityStatusEnum status) throws Exception;
}
