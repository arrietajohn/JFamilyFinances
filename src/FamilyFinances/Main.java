
package FamilyFinances;

import FamilyFinances.Infrastructure.Configurations.DependencyContainer;
import FamilyFinances.Infrastructure.Configurations.DependencyInjectionConfiguration;
import FamilyFinances.Views.MainWindow;

/**
 *
 * @author johnarrieta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var dependencyContainer = DependencyContainer.getInstance();
        DependencyInjectionConfiguration.registerDependencies(dependencyContainer);
        MainWindow window = new MainWindow(dependencyContainer);
        // Esto maximiza la ventana al tamaño de la pantalla
        window.setExtendedState(MainWindow.MAXIMIZED_BOTH);
        window.setTitle("..:: [ Finanzas Familiares ] ::..");
        window.setVisible(true);
    }
    
}









