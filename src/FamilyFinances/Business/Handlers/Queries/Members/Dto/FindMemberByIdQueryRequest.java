package FamilyFinances.Business.Handlers.Queries.Members.Dto;

/**
 *
 * @author johnarrieta
 */
public class FindMemberByIdQueryRequest {
    private final Integer id;

    public FindMemberByIdQueryRequest(Integer id) {
        if(id == null || id < 1){
            throw new IllegalArgumentException("El ID del miembro es requerido");
        }
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
    
    
}
