package FamilyFinances.Business.Handlers.Command.Users.Dto;

/**
 *
 * @author johnarrieta
 */
public class DeleteUserCommandRequest {
    private Integer userId;

    public DeleteUserCommandRequest(Integer userId) {
        if(userId == null || userId < 1){
            throw new IllegalArgumentException("El Id del Rol es requerido");
        }
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }
    
    
}
