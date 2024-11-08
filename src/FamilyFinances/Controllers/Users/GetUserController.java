package FamilyFinances.Controllers.Users;

import FamilyFinances.Domain.Models.User;
import java.util.List;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;

/**
 *
 * @author johnarrieta
 */
public class GetUserController {
    private final IGetUsersService getUserService;

    public GetUserController(IGetUsersService getUserService) {
        this.getUserService = getUserService;
    }
    
    public User getUser(Integer userId) throws Exception{
        return getUserService.getUser(userId);
    }
    
     public User getUser(String userCode) throws Exception{
        return getUserService.getUser(userCode);
    }
     
    public List<User> getAllUsers()  throws Exception{
        return getUserService.getAllUsers();
    }
    
}
