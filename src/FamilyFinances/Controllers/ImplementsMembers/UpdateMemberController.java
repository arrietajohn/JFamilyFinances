package FamilyFinances.Controllers.ImplementsMembers;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.UpdateMemberCommandRequest;
import FamilyFinances.Business.Interfaces.UseCases.Members.IUpdateMemberService;
import FamilyFinances.Controllers.Interfaces.Families.IGetFamilyController;
import FamilyFinances.Controllers.Interfaces.Members.IUpdateMemberController;
import FamilyFinances.Controllers.Interfaces.Users.ILoginUserController;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Member;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Main;
import java.time.LocalDate;

/**
 *
 * @author johnarrieta
 */
public class UpdateMemberController implements IUpdateMemberController {

    private final IUpdateMemberService updteMemberService;
    private final ILoginUserController loginUserController;
    private final IGetFamilyController getFamilyController;

    public UpdateMemberController(IUpdateMemberService updteMemberService, ILoginUserController loginUserController, IGetFamilyController getFamilyController) {
        this.updteMemberService = updteMemberService;
        this.loginUserController = loginUserController;
        this.getFamilyController = getFamilyController;
    }


    @Override
    public Member executeAction(
            Integer parentUserId,
            UserStatusEnum status,
            String firstName,
            String secondName,
            String firstLastName,
            String secondLastName,
            String gender, LocalDate dateOfBirth,
            String occupation,
            FamilyRoleEnum familyRole,
            String cellPhoneNumber,
            Integer familyId,
            User updateBy)
            throws MemberEntityNotFoundException, Exception 
    {
        var userCurrent = Main.currentUser;
        var family = getFamilyController.executeAction(familyId);
        var request = new UpdateMemberCommandRequest(
                parentUserId,
                status,
                firstName,
                secondName,
                firstLastName,
                secondLastName,
                gender,
                dateOfBirth,
                occupation,
                familyRole,
                cellPhoneNumber,
                family,
                userCurrent);
       return  updteMemberService.updateMember(request);

    
    }

}
