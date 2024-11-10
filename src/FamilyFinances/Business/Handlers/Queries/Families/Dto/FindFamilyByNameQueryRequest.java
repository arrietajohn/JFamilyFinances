package FamilyFinances.Business.Handlers.Queries.Families.Dto;

/**
 *
 * @author johnarrieta
 */
public class FindFamilyByNameQueryRequest {
    private final String familyName;

    public FindFamilyByNameQueryRequest(String familyName) {
        if(familyName == null || familyName.isBlank() ){
            var message = "El Nombre de la Familia es requerido";
            throw new IllegalArgumentException(message);
        }
        this.familyName = familyName;
    }

    public String getFamilyId() {
        return familyName;
    }
    
}
