package FamilyFinances.Controllers.Implements.Members;

import FamilyFinances.Business.Handlers.Command.Members.Dto.CreateMemberCommandRequest;
import FamilyFinances.Business.Interfaces.UseCases.Members.ICreateMemberService;
import FamilyFinances.Controllers.Interfaces.Members.ICreateMemberController;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDate;

/**
 *
 * @author johnarrieta
 */
public class CreateMemberController implements ICreateMemberController {

    private final ICreateMemberService createMemberService;

    public CreateMemberController(ICreateMemberService createMemberService) {
        this.createMemberService = createMemberService;
    }

    @Override
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
            int createdById
    ) throws Exception {
        var parentUser = new User(parentUserId);
        var family = new Family();
        family.setId(familyId);
        var createBy = parentUser;
        var request = new CreateMemberCommandRequest(
                parentUser,
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
                createBy,
                status
        );
        createMemberService.createMember(request);
    }

}
