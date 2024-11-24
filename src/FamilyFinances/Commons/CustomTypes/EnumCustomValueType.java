package FamilyFinances.Commons.CustomTypes;

/**
 *
 * @author johnarrieta
 */
public class EnumCustomValueType<T extends Enum<T> & Comparable<T>> implements ICustomValueType<T> {
    
    private T value;

    @Override
    public int compareTo(T otherValue) {
        return this.value.compareTo(otherValue);
    }

    public EnumCustomValueType(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

}
