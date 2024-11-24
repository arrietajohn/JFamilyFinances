package FamilyFinances.Commons.CustomTypes;

/**
 *
 * @author johnarrieta
 */

public class NumberCustomValueType<T extends Number & Comparable<T>> implements ICustomValueType<T> {
    private final T value;

    public NumberCustomValueType(T value) {
        this.value = value;
    }


    public T getValue() {
        return value;
    }

    @Override
    public int compareTo(T other) {
        return this.value.compareTo(other);
    }
    
}
