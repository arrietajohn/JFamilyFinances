package FamilyFinances.Infrastructure.Configurations;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 *
 * @author johnarrieta
 */
public class DependencyContainer {
    
    private static DependencyContainer instance;
    private final Map<Class<?>, Supplier<?>> dependencies ;
    
    private DependencyContainer(){
        dependencies =  new HashMap<>();
    }
    
    public static DependencyContainer getInstance(){
        if(instance == null){
            instance = new DependencyContainer();
        }
        return instance;
    }

    public <T> void register(Class<T> key, Supplier<T> supplier) {
        dependencies.put(key, supplier);
    }

    public <T> T resolve(Class<T> key) {
        Supplier<?> supplier = dependencies.get(key);
        if (supplier == null) {
            throw new IllegalArgumentException("Dependencia no existe: " + key.getName());
        }
        return key.cast(supplier.get());
    }
}


