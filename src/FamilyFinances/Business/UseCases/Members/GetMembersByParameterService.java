package FamilyFinances.Business.UseCases.Members;

import FamilyFinances.Business.Exceptions.MemberEntityNotFoundException;
import FamilyFinances.Business.Handlers.Queries.Members.Dto.GetMembersByPamareterQueryRequest;
import FamilyFinances.Business.Handlers.Queries.Members.Dto.GetMembersByParameterEnum;
import FamilyFinances.Business.Interfaces.Queries.Members.IGetMembersByParameterQuery;
import FamilyFinances.Business.Interfaces.UseCases.Members.IGetMembersByParameterService;
import FamilyFinances.Commons.CustomTypes.DateRangeCustomValueType;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.MembershipRequestStatusEnum;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.Member;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class GetMembersByParameterService implements IGetMembersByParameterService {

    private final IGetMembersByParameterQuery getMemberByParameterQuery;

    public GetMembersByParameterService(IGetMembersByParameterQuery getMemberByParameterQuery) {
        this.getMemberByParameterQuery = getMemberByParameterQuery;
    }

    @Override
    public List<Member> getMembers(Family family, GetMembersByPamareterQueryRequest request) throws MemberEntityNotFoundException, Exception {
        if (request == null) {
            throw new IllegalArgumentException("El parametro de consulta es requerido");
        }

        var members = getMemberByParameterQuery.handler(request);
        var familyMembers = members.stream()
                .filter(member -> member.getFamily().equals(family))
                .toList();
        validateIfEmpty(familyMembers, request);
        return familyMembers;
    }

    private void validateIfEmpty(List<Member> familyMembers, GetMembersByPamareterQueryRequest request)
            throws MemberEntityNotFoundException, Exception {
        if (familyMembers.isEmpty()) {
            var parameterName = (GetMembersByParameterEnum) request.getParameter().getName();
            var parameterValue = "";
            parameterValue = switch (parameterName) {
                case ALL, FIRST_OR_SECOND_NAME, FIRST_OR_SECOND_LAST_NAME, GENDER, OCUPATION, PHONE_NUMBER ->
                    (String) request.getParameter().getValue();
                case DATE_OF_BIRTH -> {
                    var date = ((LocalDateTime) request.getParameter().getValue()).toLocalDate();
                    var format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    yield date.format(format);
                }
                case DATE_OF_BIRTH_BETEEW -> {
                    var rangeDate = (DateRangeCustomValueType) request.getParameter().getValue();
                    var startDate = rangeDate.getStartDate().toLocalDate();
                    var endDate = rangeDate.getEndDate().toLocalDate();
                    var format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    var range = startDate.format(format) + " y " + endDate.format(format);
                    yield range;
                }
                case ROLE_IN_THE_FAMILY -> {
                    var role = (FamilyRoleEnum) request.getParameter().getValue();
                    yield role.toString();
                }
                case STATUS -> {
                    var status = (MembershipRequestStatusEnum) request.getParameter().getValue();
                    yield status.toSpanish();
                }
                default ->
                    "valor invalido";

            };
            var message = "No existen Miembros con " + parameterName.toSpanish()
                    + ": " + parameterValue;
            throw new MemberEntityNotFoundException(message);
        }
    }
}
