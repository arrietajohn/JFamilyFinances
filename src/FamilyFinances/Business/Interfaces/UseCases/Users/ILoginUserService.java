package FamilyFinances.Business.Interfaces.UseCases.Users;

import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
public interface ILoginUserService {
    public User login(String codeOrEmail, String password) throws Exception;
}
