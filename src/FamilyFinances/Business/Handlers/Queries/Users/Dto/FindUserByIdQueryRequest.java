package FamilyFinances.Business.Handlers.Queries.Users.Dto;

/**
 *
 * @author johnarrieta
 */
public class FindUserByIdQueryRequest {
  private Integer userId;

    public FindUserByIdQueryRequest(Integer userId) {
        if(userId == null || userId < 1){
            throw new IllegalArgumentException("El Id del Usuario es requerido");
        }
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
    
}
