package FamilyFinances.Infrastructure.Configurations;

import FamilyFinances.Business.Interfaces.Repositories.IFamilyRepository;
import FamilyFinances.Business.Interfaces.Repositories.IMemberRepository;
import FamilyFinances.Business.Interfaces.Repositories.IMembershipRequestRepository;
import FamilyFinances.Infrastructure.Persistence.Repositories.MembershipRequestMemoryRepository;

/**
 *
 * @author johnarrieta
 */
public class MembershipRequestDependencyInjectionFactory {

    public static void registerDependencies(DependencyContainer container) {

        // Registrar la dependencia del respositorio de Miembros
        container.register(IMembershipRequestRepository.class, ()
                -> new MembershipRequestMemoryRepository());
    }
}
