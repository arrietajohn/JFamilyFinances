package FamilyFinances.Controllers.Interfaces.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.Member;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDate;
import java.time.LocalDateTime;


/**
 *
 * @author johnarrieta
 */
public interface IUpdateMemberController {

    public Member executeAction(
            Integer parentUserId,
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
            Integer family,
            User updateBy)
            throws MemberEntityNotFoundException, Exception;
}
