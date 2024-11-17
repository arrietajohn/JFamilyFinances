package FamilyFinances.Business.Handlers.Queries.Members.Dto;

/**
 *
 * @author johnarrieta
 */
public class FindMemberByIdQueryRequest {

    private final Integer memberId;

    public FindMemberByIdQueryRequest(Integer memberId) {
        if (memberId == null || memberId < 1) {
            throw  new IllegalArgumentException("El ID del miembro es requerido");
        }
        this.memberId = memberId;
    }

    public Integer getMemberId() {
        return memberId;
    }

}
