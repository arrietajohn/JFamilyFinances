
package FamilyFinances.Infrastructure.Persistence.Data;

import FamilyFinances.Domain.Models.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author johnarrieta
 */
public class InMemoryEntitiesStorage {
        // Diccionarios para cada clase
    private final Map<Integer, Category> categories;
    private final Map<Integer, Contribution> contributions;
    private final Map<Integer, Expense> expenses;
    private final Map<Integer, Family> families;
    private final Map<Integer, Income> incomes;
    private final Map<Integer, Member> members;
    private final Map<Integer, Role> roles;
    private final Map<Integer, SavingsBag> savingsBags;
    private final Map<Integer, Source> sources;
    private final Map<Integer, User> users;

    // Singleton instance
    private static InMemoryEntitiesStorage instance;

    // Constructor privado
    private InMemoryEntitiesStorage() {
        categories = new HashMap<>();
        contributions = new HashMap<>();
        expenses = new HashMap<>();
        families = new HashMap<>();
        incomes = new HashMap<>();
        members = new HashMap<>();
        roles = new HashMap<>();
        savingsBags = new HashMap<>();
        sources = new HashMap<>();
        users = new HashMap<>();
    }

    // Método Singleton (Obtiene siempre la misma instancia )
    public static InMemoryEntitiesStorage getInstance() {
        if (instance == null) {
            instance = new InMemoryEntitiesStorage();
        }
        return instance;
    }


    public Map<Integer, Category> getCategories() {
        return categories;
    }

    public Map<Integer, Contribution> getContributions() {
        return contributions;
    }

    public Map<Integer, Expense> getExpenses() {
        return expenses;
    }

    public Map<Integer, Family> getFamilies() {
        return families;
    }

    public Map<Integer, Income> getIncomes() {
        return incomes;
    }

    public Map<Integer, Member> getMembers() {
        return members;
    }

    public Map<Integer, Role> getRoles() {
        return roles;
    }

    public Map<Integer, SavingsBag> getSavingsBags() {
        return savingsBags;
    }

    public Map<Integer, Source> getSources() {
        return sources;
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

}
