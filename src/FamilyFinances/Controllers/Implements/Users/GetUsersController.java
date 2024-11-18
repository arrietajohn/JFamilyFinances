package FamilyFinances.Controllers.Implements.Users;

import FamilyFinances.Domain.Models.User;
import java.util.List;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;
import FamilyFinances.Controllers.Interfaces.Users.IGetUsersController;

/**
 *
 * @author johnarrieta
 */
public class GetUsersController implements IGetUsersController{
    private final IGetUsersService getUserService;
    private User currentUser;

    public GetUsersController(IGetUsersService getUserService) {
        this.getUserService = getUserService;
    }
    
    @Override
    public User executeActionGetUser(Integer userId) throws Exception{
        currentUser = getUserService.getUserById(userId);
        return currentUser;
    }
    
    @Override
     public User executeActionGetUser(String userCode) throws Exception{
         currentUser =  getUserService.getUserByCode(userCode);
         return currentUser;
    }
     
    @Override
    public List<User> executeActionGetAllUsers()  throws Exception{
        return getUserService.getAllUsers();
    }

    @Override
    public User getCurrentUser() {
        return currentUser;
    }
    
}
