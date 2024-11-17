package FamilyFinances.Business.UseCases.Members;

import FamilyFinances.Business.Handlers.Queries.Members.Dto.FindMemberByIdQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Members.IFindMemberByIdQuery;
import FamilyFinances.Business.Interfaces.UseCases.Members.IGetMemberService;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public class GetMemberService implements IGetMemberService{

    private final IFindMemberByIdQuery findMemberByIdQuery;

    public GetMemberService(IFindMemberByIdQuery findMemberByIdQuery) {
        this.findMemberByIdQuery = findMemberByIdQuery;
    }
    
    @Override
    public Member getMember(FindMemberByIdQueryRequest request) throws Exception {
        return findMemberByIdQuery.handler(request);
    }

}
