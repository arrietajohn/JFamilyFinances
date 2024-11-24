package FamilyFinances.Commons.CustomTypes;

/**
 *
 * @author johnarrieta
 */
public class TextCustomValueType implements ICustomValueType<String>{

    private String value;

    public TextCustomValueType(String value) {
        this.value = value;
    }
    


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public int compareTo(String othreValue) {
        return this.compareTo(othreValue);
    }


}
