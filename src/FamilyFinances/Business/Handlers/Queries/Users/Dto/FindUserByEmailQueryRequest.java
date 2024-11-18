package FamilyFinances.Business.Handlers.Queries.Users.Dto;

/**
 *
 * @author johnarrieta
 */
public class FindUserByEmailQueryRequest {
  private String userEmail;

    public FindUserByEmailQueryRequest(String userEmail) {
        if(userEmail == null || userEmail.isBlank()){
            throw new IllegalArgumentException("El email del usuario es requerido");
        }
        this.userEmail = userEmail;
    }

    public String getUserEmail() {
        return userEmail;
    }
    
}
