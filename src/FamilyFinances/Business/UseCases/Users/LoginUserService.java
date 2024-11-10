package FamilyFinances.Business.UseCases.Users;

import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByCodeQueryRequest;
import FamilyFinances.Business.Handlers.Queries.Users.Dto.FindUserByIdQueryRequest;
import FamilyFinances.Business.Handlers.Queries.Users.FindUserByCodeQueryHandler;
import FamilyFinances.Business.Interfaces.Queries.Roles.IGetRoleByIdQuery;
import FamilyFinances.Business.Interfaces.Queries.Users.IGetAllUserQuery;
import FamilyFinances.Business.Interfaces.UseCases.Users.ILoginUserService;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Business.Interfaces.UseCases.Users.IGetUsersService;

/**
 *
 * @author johnarrieta
 */
public class LoginUserService implements ILoginUserService{
    
    private final IGetUsersService getUserService;
    
    public LoginUserService(IGetUsersService getUserService) {
        this.getUserService = getUserService;
    }
    
    @Override
    public User login(String code, String password) throws Exception {
        if(password == null || password.isBlank()){
            throw new IllegalArgumentException("El Password es requerido");
        }
        var request = new FindUserByCodeQueryRequest(code);
        var user = getUserService.getUser(code);
        if(!user.getPassword().equals(password) ){
             throw new IllegalArgumentException("Datos de acceso incorrectos");
        }
        
        return user;
        
    }
}
