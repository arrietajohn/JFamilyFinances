package FamilyFinances.Business.Handlers.Queries.Families.Dto;

/**
 *
 * @author johnarrieta
 */
public class FindFamilyByIdQueryRequest {
    private final Integer familyId;

    public FindFamilyByIdQueryRequest(Integer familyId) {
        if(familyId >= 0 ){
            var message = "El Id de la Familia es requerido";
            throw new IllegalArgumentException(message);
        }
        this.familyId = familyId;
    }

    public Integer getFamilyId() {
        return familyId;
    }
    
}
