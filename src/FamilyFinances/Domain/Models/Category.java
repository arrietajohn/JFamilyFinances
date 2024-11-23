package FamilyFinances.Domain.Models;

import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author johnarrieta
 */
public class Category implements Comparable<Category>{

    private Integer id;
    private String name;
    private String description;
    private Set<Expense> exprenses = new TreeSet<>();

    public Category() {
        
    }

    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
    
    public int compareTo(Category other) {
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
        Category theOther = (Category) other;
        return Objects.equals(id, theOther.id) && Objects.equals(name.toLowerCase(), theOther.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
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

    public Set<Expense> getExprenses() {
        return exprenses;
    }

    public void setExprenses(Set<Expense> exprenses) {
        this.exprenses = exprenses;
    }
    
}
