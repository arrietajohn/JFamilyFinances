package FamilyFinances.Business.Handlers.Command.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Command.Members.Dto.UpdateMemberCommandRequest;
import FamilyFinances.Business.Interfaces.Commands.Members.IUpdateMemberCommand;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Domain.Models.Member;

/**
 *
 * @author johnarrieta
 */
public class UpdateMemberCommandHandler implements IUpdateMemberCommand {

    private final IMemberRepository memberRepository;

    public UpdateMemberCommandHandler(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member handler(UpdateMemberCommandRequest request) throws MemberEntityNotFoundException,Exception {
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
                request.getParentUserId(), //request..parentUserId(),
                null, //request.getParentUser().getCode(),
                null, //request.getParentUser().getPassword(),
                null, //request.getParentUser().getName(),
                null, //request.getParentUser().getEmail(),
                request.getStatus(),
                null, //request.getRole(),
                null, // request.getCreationDate(),
                request.getUpdateDe(),
                null, //request.getCreatedBy(),
                request.getUpdateBy() // UpdateBy
        );
        return memberRepository.edit(member);
    }

}
