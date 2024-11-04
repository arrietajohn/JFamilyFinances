package FamilyFinances.Domain.Models;

import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class Category {

    private Integer id;
    private String name;
    private String description;
    private List<Expense> exprenses;

    public Category() {
        
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Expense> getExprenses() {
        return exprenses;
    }

    public void setExprenses(List<Expense> exprenses) {
        this.exprenses = exprenses;
    }

}
