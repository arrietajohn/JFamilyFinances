package FamilyFinances.Business.Handlers.Queries.Users.Dto;

/**
 *
 * @author johnarrieta
 */
public class FindUserByCodeQueryRequest {
  private String userCode;

    public FindUserByCodeQueryRequest(String userCode) {
        if(userCode == null || userCode.isBlank()){
            throw new IllegalArgumentException("El Id Codigo del Usuario es requerido");
        }
        this.userCode = userCode;
    }

    public String getUserCode() {
        return userCode;
    }
    
}
