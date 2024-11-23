package Members;

import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Business.Interfaces.Repositories.IMembershipRequestRepository;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.Member;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Infrastructure.Configurations.DependencyContainer;
import FamilyFinances.Infrastructure.Configurations.DependencyInjectionConfiguration;
import FamilyFinances.Infrastructure.Persistence.Data.InMemoryEntitiesStorage;
import FamilyFinances.Infrastructure.Persistence.Repositories.MemberMemoryRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author johnarrieta
 */
public class MemberRepositoryTest {

    private InMemoryEntitiesStorage entityStorage;
    private DependencyContainer dependencyInjection = DependencyContainer.getInstance();
    private IMemberRepository memberRepository;
    private IUserRepository userRepository;
    private IFamilyRepository familyRepository;
    
    @Before
    public void setUp() {
        DependencyInjectionConfiguration.registerDependencies(DependencyContainer.getInstance());
        userRepository = dependencyInjection.resolve(IUserRepository.class);
        familyRepository = dependencyInjection.resolve(IFamilyRepository.class);
        memberRepository = dependencyInjection.resolve(IMemberRepository.class);

    }

    @Test
    public void testSaveAMemberShouldFindIt() throws Exception {
        // Arrange
        var role = Role.MEMBER;
         var user = new User("fulanito", "abd", "Fulano", "fulanito@gmail.com", role);
         userRepository.save(user);
        var family = new Family("Fuanito Test", "55555", "Cartageja", null);
        familyRepository.save(family);
        
        var member = new Member(
                "Filano",
                "Perencejo",
                "De", "Tal",
                FamilyRoleEnum.FATHER,
                family,
                "fulanito",
                "abd", "Fulano", "fulanito@gmail.com", role);
        member.setId(1);
        member.setPassword(user.getPassword());
        member.setEmail(user.getEmail());
        member.setCode(user.getCode());
        member.setRole(user.getRole());
        // Act

        try {

            memberRepository.save(member);
            // Assert
            assertEquals(member, memberRepository.findById(1));
        } catch (Exception ex) {
            TestCase.assertNull(ex);
        }
    }
}
