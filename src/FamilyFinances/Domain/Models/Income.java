package FamilyFinances.Domain.Models;

import FamilyFinances.Domain.Constants.EntityStatusEnum;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class Income {

    private Integer id;
    private LocalDate date;
    private String name;
    private Float amount;
    private String description;
    private Member member;
    private Source source;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private User createdBy;
    private User updateBy;
    private EntityStatusEnum status;
    private List<Contribution> contributions;
   

    public Income(String name, Float amount, Member member, Source source) {
        this.name = name;
        this.amount = amount;
        this.member = member;
        this.source = source;
    }

    public Income(LocalDate date, String name, Float amount, String description, Member member, Source source) {
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.member = member;
        this.source = source;
    }

    public Income(Integer id, LocalDate date, String name, Float amount, String description, Member member, Source source, LocalDateTime creationDate, User createdBy) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.amount = amount;
        this.description = description;
        this.member = member;
        this.source = source;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
    }

    public EntityStatusEnum getStatus() {
        return status;
    }

    public void setStatus(EntityStatusEnum status) {
        this.status = status;
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

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
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

}
