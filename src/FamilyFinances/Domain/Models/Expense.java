package FamilyFinances.Domain.Models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 * @author johnarrieta
 */
public class Expense implements Comparable<Expense>{

    private Integer id;
    private LocalDate date;
    private String name;
    private Float amount;
    private String description;
    private Member member;
    private Category category;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private User createdBy;
    private User updateBy;
    private Contribution contribution;

    public Expense(LocalDate date, String name, Float amount, Member member, Category category) {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.member = member;
        this.category = category;
    }

    public Expense(LocalDate date, String name, Float amount, String description, Member member, Category category) {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.member = member;
        this.category = category;
    }

    public Expense(LocalDate date, String name, Float amount, String description, Member member, Category category, Contribution contribution) {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.member = member;
        this.category = category;
        this.contribution = contribution;
    }

    public Expense(Integer id, LocalDate date, String name, Float amount, String description, Member member, Category category, LocalDateTime creationDate, LocalDateTime updateDate, User createdBy, User updateBy, Contribution contribution) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.member = member;
        this.category = category;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.createdBy = createdBy;
        this.updateBy = updateBy;
        this.contribution = contribution;
    }

    public int compareTo(Expense other) {
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
        Expense theOther = (Expense) other;
        return Objects.equals(id, theOther.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(User updateBy) {
        this.updateBy = updateBy;
    }

    public Contribution getContribution() {
        return contribution;
    }

    public void setContribution(Contribution contribution) {
        this.contribution = contribution;
    }

}
