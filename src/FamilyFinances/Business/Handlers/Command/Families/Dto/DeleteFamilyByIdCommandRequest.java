package FamilyFinances.Business.Handlers.Command.Families.Dto;

/**
 *
 * @author johnarrieta
 */
public class DeleteFamilyByIdCommandRequest {
    private final Integer familyId;

    public DeleteFamilyByIdCommandRequest(Integer familyId) {
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
