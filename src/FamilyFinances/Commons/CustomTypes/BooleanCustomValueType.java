package FamilyFinances.Commons.CustomTypes;

/**
 *
 * @author johnarrieta
 */
public class BooleanCustomValueType implements ICustomValueType<Boolean>{

    private Boolean value;

    public BooleanCustomValueType(boolean value) {
        this.value = value;
    }
    
   
    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public int compareTo(Boolean otherValue) {
        return this.value.compareTo(otherValue);
    }

    @Override
    public Boolean getValue() {
        return value;
    }

}
