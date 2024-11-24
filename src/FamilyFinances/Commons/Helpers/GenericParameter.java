package FamilyFinances.Commons.Helpers;

import FamilyFinances.Commons.CustomTypes.ICustomValueType;

/**
 *
 * @author johnarrieta
 */
public class GenericParameter<P extends Enum<P> , T , V extends ICustomValueType<T>> {

    private final P name;
    private final V value;

    public GenericParameter(P name, V value) {
        this.name = name;
        this.value = value;
    }

    public P getName() {
        return name;
    }

    public T getValue() {
        return value.getValue();
    }
    
    public Class<?> getValueType(){
        return value.getValue().getClass();
    }
    
}
