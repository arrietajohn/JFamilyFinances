package FamilyFinances.Commons.CustomTypes;

import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class LocalDateTimeCustomValueType implements ICustomValueType<LocalDateTime>{
    private LocalDateTime value;

    public LocalDateTimeCustomValueType(LocalDateTime value) {
        this.value = value;
    }

    public LocalDateTime getValue() {
        return value;
    }

    public void setValue(LocalDateTime value) {
        this.value = value;
    }

    @Override
    public int compareTo(LocalDateTime otherValue) {
        return this.value.compareTo(otherValue);
    }
    

}
