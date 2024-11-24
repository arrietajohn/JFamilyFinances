package FamilyFinances.Business.Handlers.Queries.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Queries.Members.Dto.GetMembersByPamareterQueryRequest;
import FamilyFinances.Business.Handlers.Queries.Members.Dto.GetMembersByParameterEnum;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Domain.Models.Member;
import java.util.List;
import FamilyFinances.Business.Interfaces.Queries.Members.IGetMembersByParameterQuery;
import FamilyFinances.Commons.CustomTypes.DateRangeCustomValueType;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.MembershipRequestStatusEnum;
import java.time.LocalDateTime;


/**
 *
 * @author johnarrieta
 */
public class GetMembersByParameterQueryHandler implements IGetMembersByParameterQuery {

    private final IMemberRepository memberRepository;

    public GetMembersByParameterQueryHandler(IMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    @SuppressWarnings("empty-statement")
    public List<Member> handler(GetMembersByPamareterQueryRequest request)
            throws MemberEntityNotFoundException, Exception {
        if(request == null){
            throw new IllegalArgumentException("El parametro de consulta es requerido");
        }
        
        var parameterName = (GetMembersByParameterEnum)request.getParameter().getName();
        
        switch (parameterName) {
            case ALL:
                return memberRepository.getAll();
            case STATUS:
                var status = (MembershipRequestStatusEnum) request.getParameter().getValue();
                return memberRepository.findByStatus(status);
            case GENDER:
                var gender = (String) request.getParameter().getValue();
                return memberRepository.findByGender(gender);
            case OCUPATION:
                var ocupacion = (String) request.getParameter().getValue();
                return memberRepository.findByOcupation(ocupacion);
            case PHONE_NUMBER:
                var phoneNumber = (String) request.getParameter().getValue();
                return memberRepository.findByPhoneNumber(phoneNumber);
            case DATE_OF_BIRTH:
                var date = (LocalDateTime) request.getParameter().getValue();
                return memberRepository.findByDateOfBirth(date.toLocalDate());
            case DATE_OF_BIRTH_BETEEW:
                var dateRange = (DateRangeCustomValueType) request.getParameter().getValue();
                return memberRepository.findByDateOfBirthBetween(
                        dateRange.getStartDate().toLocalDate(), 
                        dateRange.getEndDate().toLocalDate());
            case ROLE_IN_THE_FAMILY:
                var role = (FamilyRoleEnum) request.getParameter().getValue();
                return memberRepository.findByFamilyRole(role);
            case FIRST_OR_SECOND_NAME:
                String name = (String)request.getParameter().getValue();
                return memberRepository.findByFirstOrSecondName(name);
            case FIRST_OR_SECOND_LAST_NAME:
                var lastname = (String) request.getParameter().getValue();
                return memberRepository.findByFirstLastOrSecondLastName(lastname);
            default:
                throw new IllegalArgumentException("Operación invalida");
        }
    }
}
