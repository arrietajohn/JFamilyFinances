

package FamilyFinances.Domain.Models;

import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class Contribution {
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
