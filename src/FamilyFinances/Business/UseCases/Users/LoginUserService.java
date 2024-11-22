package FamilyFinances.Business.UseCases.Users;

import FamilyFinances.Business.Exceptions.UserEntityNotFoundException;
import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByCodeQueryRequest;
import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByEmailQueryRequest;
import FamilyFinances.Business.Interfaces.UseCases.Users.ILoginUserService;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;

/**
 *
 * @author johnarrieta
 */
public class LoginUserService implements ILoginUserService {

    private final IGetUsersService getUserService;
    private  User currentUser;

    public LoginUserService(IGetUsersService getUserService) {
        this.getUserService = getUserService;
    }

    @Override
    public User login(String codeOrEmail, String password) throws Exception {
        var errorMessage = new StringBuilder();
        var user = getByCode(codeOrEmail, errorMessage);
        if(user == null){
            user = getByEmail(codeOrEmail, errorMessage);
            if (user == null) {
                throw new UserEntityNotFoundException(errorMessage.toString());
            }
        }
        if (!user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Datos de acceso incorrectos");
        }
        currentUser = user;
        return user;

    }
    
    private User getByCode(String code, StringBuilder errorMessage){
        try {
            var request = new FindUserByCodeQueryRequest(code);
            return getUserService.getUserByCode(code);
        } catch (Exception e) {
            errorMessage.append("Codigo ") ;
            return null;
        }
    }
    
    private User getByEmail(String email, StringBuilder errorMessage){
        try {
            var request = new FindUserByEmailQueryRequest(email);
            return getUserService.getUserByEmail(email);
        } catch (Exception e) {
            errorMessage.append(" o email incorrectos");
            return null;
        }
    }
    
}
