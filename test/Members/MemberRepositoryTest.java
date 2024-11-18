package Members;

import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.Member;
import FamilyFinances.Infrastructure.Persistence.Data.InMemoryEntitiesStorage;
import FamilyFinances.Infrastructure.Persistence.Repositories.MemberRepository;
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
    private IMemberRepository memberRepository;

    @Before
    public void setUp() {

        memberRepository = new MemberRepository();
    }

    @Test
    public void testSaveAMemberShouldFindIt() {
        // Arrange
        var role = Role.MEMBER;
        //    var user = new User("fulanito", "abd", "Fulano", "fulanito@gmail.com", role);
        var family = new Family("Fuanito Test", "55555", "Cartageja", null);
        var member = new Member(
                "Filano",
                "Perencejo",
                "De", "Tal",
                FamilyRoleEnum.FATHER,
                family,
                "fulanito",
                "abd", "Fulano", "fulanito@gmail.com", role);
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
