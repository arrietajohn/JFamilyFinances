package FamilyFinances.Controllers.Interfaces.Families;

import FamilyFinances.Domain.Constants.EntityStatusEnum;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public interface ICreateFamilyController {
    public void executeAction(String name, String phoneNumber, String address, LocalDateTime creationDate, User createdBy, EntityStatusEnum status) throws Exception;
}
