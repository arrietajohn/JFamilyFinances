package FamilyFinances.Commons.CustomTypes;

/**
 *
 * @author johnarrieta
 */
import java.time.LocalDateTime;

public class DateRangeCustomValueType implements ICustomValueType<DateRangeCustomValueType> {

    private final LocalDateTime startDate;
    private final LocalDateTime endDate;

    public DateRangeCustomValueType(LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("Las fechas no pueden ser nulas");
        }
        if (startDate.isAfter(endDate)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    @Override
    public DateRangeCustomValueType getValue() {
        return this;
    }

    @Override
    public int compareTo(DateRangeCustomValueType other) {
        int startComparison = this.startDate.compareTo(other.startDate);
        if (startComparison != 0) {
            return startComparison;
        }
        return this.endDate.compareTo(other.endDate);
    }

}
