package FamilyFinances.Infrastructure.Configurations;

/**
 *
 * @author johnarrieta
 */
public class DependencyInjectionConfigurationFacade {
    public static void configurationAllDependencyInjections(DependencyContainer container){
        RoleDependencyInjectionFactory.registerDependencies(container);
        UserDependencyInjectionFactory.registerDependencies(container);
    }
}
