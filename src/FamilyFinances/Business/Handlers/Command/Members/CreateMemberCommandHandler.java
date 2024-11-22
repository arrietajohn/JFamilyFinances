package FamilyFinances.Business.Handlers.Command.Members;

import FamilyFinances.Business.Exceptions.DuplicateMemberEntityException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.CreateMemberCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Members.ICreateMemberCommand;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public class CreateMemberCommandHandler implements ICreateMemberCommand {

    private final IMemberRepository memberRepository;

    public CreateMemberCommandHandler(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void handler(CreateMemberCommandRequest request) throws DuplicateMemberEntityException, Exception {
        var member = new Member(
                request.getFirstName(),
                request.getSecondName(),
                request.getFirstLastName(),
                request.getSecondLastName(),
                request.getGender(),
                request.getDateOfBirth(),
                request.getOccupation(),
                request.getFamilyRole(),
                request.getCellPhoneNumber(),
                request.getFamily(),
                null, // incomes
                null, // expenses
                request.getParentUser().getId(),
                request.getParentUser().getCode(),
                request.getParentUser().getPassword(),
                request.getParentUser().getName(),
                request.getParentUser().getEmail(),
                request.getStatus(),
                request.getRole(),
                request.getCreationDate(),
                null, // UpdateDate
                request.getCreatedBy(),
                null // UpdateBy
                
      );
        memberRepository.save(member);
        member.getCreatedBy().setMember(member);
    }

}
