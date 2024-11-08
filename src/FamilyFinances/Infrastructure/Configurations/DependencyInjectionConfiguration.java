
package FamilyFinances.Infrastructure.Configurations;

/**
 *
 * @author johnarrieta
 */
public class DependencyInjectionConfiguration {
    
    public static void registerDependencies(DependencyContainer container) {
        DependencyInjectionConfigurationFacade.configurationAllDependencyInjections(container);
    }
}





