package FamilyFinances.Domain.Models;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author johnarrieta
 */
public class Contribution implements Comparable<Contribution>{

    private Integer id;
    private LocalDateTime date;
    private Float amount;
    private SavingsBag savingsBag;
    private Income income;

    public Contribution(Float amount, SavingsBag savingsBag, Income income) {
        this.amount = amount;
        this.savingsBag = savingsBag;
        this.income = income;
    }

    public int compareTo(Contribution other) {
        return this.id.compareTo(other.id);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        Contribution theOther = (Contribution) other;
        return Objects.equals(id, theOther.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Income getIncome() {
        return income;
    }

    public void setIncome(Income income) {
        this.income = income;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public SavingsBag getSavingsBag() {
        return savingsBag;
    }

    public void setSavingsBag(SavingsBag savingsBag) {
        this.savingsBag = savingsBag;
    }

}
