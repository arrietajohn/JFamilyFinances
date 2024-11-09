package FamilyFinances;

import FamilyFinances.Business.Interfaces.Repositories.IRoleRepository;
import FamilyFinances.Business.Interfaces.Repositories.IUserRepository;
import FamilyFinances.Controllers.Interfaces.Users.ILoginUserController;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;
import FamilyFinances.Infrastructure.Configurations.DependencyContainer;
import FamilyFinances.Infrastructure.Configurations.DependencyInjectionConfiguration;
import FamilyFinances.Views.MainWindow;
import javax.swing.JOptionPane;

/**
 *
 * @author johnarrieta
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static User currentUser;
    public static void main(String[] args) {

        var dependencyContainer = DependencyContainer.getInstance();
        DependencyInjectionConfiguration.registerDependencies(dependencyContainer);
        MainWindow window = new MainWindow(dependencyContainer);
        // Esto maximiza la ventana al tamaño de la pantalla
        window.setExtendedState(MainWindow.MAXIMIZED_BOTH);
        window.setTitle("..:: [ Finanzas Familiares ] ::..");
        window.setVisible(true);
        try {
            // Objetos iniciales (Validar esto cuando se persistan los objetos)
            var initialRole = new Role("Administrador", "Super usuario");
            var roleRepository = dependencyContainer.resolve(IRoleRepository.class);
            roleRepository.save(initialRole);
            var initialUser = new User(
                    "123",
                    "Abc**",
                    "John Arrieta",
                    "jarrieta@yopmail,com",
                    initialRole);
            var userRepository = dependencyContainer.resolve(IUserRepository.class);
            userRepository.save(initialUser);
            var loginUserController = dependencyContainer.resolve(ILoginUserController.class);
            currentUser = loginUserController.executeAction(initialUser.getCode(), initialUser.getPassword());
            

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(window, ex.getMessage());
            System.exit(0);
        }

    }
}
