package FamilyFinances.Business.UseCases.Members;

import FamilyFinances.Business.Handlers.Command.Members.Dto.CreateMemberCommandRequest;
import FamilyFinances.Business.Handlers.Queries.Families.Dto.FindFamilyByIdQueryRequest;
import FamilyFinances.Business.Interfaces.Commands.Members.ICreateMemberCommand;
import FamilyFinances.Business.Interfaces.UseCases.Families.IGetFamilyService;
import FamilyFinances.Business.Interfaces.UseCases.Members.ICreateMemberService;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;

/**
 *
 * @author johnarrieta
 */
public class CreateMemberService  implements ICreateMemberService{

    private final ICreateMemberCommand createMemberCommand;
    private final IGetUsersService getUsersService;
    private final IGetFamilyService getFamilyService;

    public CreateMemberService(ICreateMemberCommand createMemberCommand, IGetUsersService getUsersService, IGetFamilyService getFamilyService) {
        this.createMemberCommand = createMemberCommand;
        this.getUsersService = getUsersService;
        this.getFamilyService = getFamilyService;
    }

  

    @Override
    public void createMember(CreateMemberCommandRequest request) throws Exception {

            var parentUser = getUsersService.getUser(request.getParentUser().getId());
            request.setParentUser(parentUser);
            var getFamilyQueryRequest = new FindFamilyByIdQueryRequest(request.getFamily().getId());
            var family = getFamilyService.getFamily(getFamilyQueryRequest);
            request.setFamily(family);
            var createdBy = getUsersService.getUser(request.getCreatedBy().getId());
            request.setCreatedBy(createdBy);
            createMemberCommand.handler(request);
    }
    
    
}
