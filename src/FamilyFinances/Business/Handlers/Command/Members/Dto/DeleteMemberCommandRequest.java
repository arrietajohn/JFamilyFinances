package FamilyFinances.Business.Handlers.Command.Members.Dto;

/**
 *
 * @author johnarrieta
 */
public class DeleteMemberCommandRequest {
    private final Integer memberId;

    public DeleteMemberCommandRequest(Integer memberId) {
        if(memberId == null || memberId < 1){
            throw new IllegalArgumentException("El id del miembro es requerido");
        }
        this.memberId = memberId;
    }

    public Integer getMemberId() {
        return memberId;
    }
    
    
    
}
