package FamilyFinances.Controllers.Interfaces.Members;

import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import java.time.LocalDate;

/**
 *
 * @author johnarrieta
 */
public interface ICreateMemberController {
    public void executeAction(    
            int parentUserId,
            UserStatusEnum status,
            String firstName,
            String secondName,
            String firstLastName,
            String secondLastName,
            String gender,
            LocalDate dateOfBirth,
            String occupation,
            FamilyRoleEnum familyRole,
            String cellPhoneNumber,
            int familyId,
            int createdById) throws Exception;
}
