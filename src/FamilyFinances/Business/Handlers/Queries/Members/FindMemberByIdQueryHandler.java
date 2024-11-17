package FamilyFinances.Business.Handlers.Queries.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Queries.Members.Dto.FindMemberByIdQueryRequest;
import FamilyFinances.Business.Interfaces.Queries.Members.IFindMemberByIdQuery;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public class FindMemberByIdQueryHandler implements IFindMemberByIdQuery{

    private final IMemberRepository memberRepository;

    public FindMemberByIdQueryHandler(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    
    @Override
    public Member handler(FindMemberByIdQueryRequest request) throws MemberEntityNotFoundException, Exception {
        return memberRepository.findById(request.getMemberId());
    }

}
