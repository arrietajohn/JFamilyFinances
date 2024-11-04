package FamilyFinances.Domain.Models;

import FamilyFinances.Domain.Constants.SavingsBagStatusEnum;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author johnarrieta
 */
public class SavingsBag {

    private Integer id;
    private String name;
    private Float targetAmount;
    private String purpose;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private SavingsBagStatusEnum status;
    private Family family;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private User createdBy;
    private User updateBy;
    private List<Contribution> contributions;
    
    public SavingsBag(String name, Float targetAmount, String purpose) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.purpose = purpose;
    }

    public SavingsBag(String name, Float targetAmount, String purpose, LocalDateTime startDate, LocalDateTime endDate, Family family) {
        this.name = name;
        this.targetAmount = targetAmount;
        this.purpose = purpose;
        this.startDate = startDate;
        this.endDate = endDate;
        this.family = family;
    }

    public SavingsBag(Integer id, String name, Float targetAmount, String purpose, LocalDateTime startDate, LocalDateTime endDate, SavingsBagStatusEnum status, Family family, LocalDateTime creationDate, LocalDateTime updateDate, User createdBy, User updateBy, List<Contribution> contributions) {
        this.id = id;
        this.name = name;
        this.targetAmount = targetAmount;
        this.purpose = purpose;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.family = family;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.createdBy = createdBy;
        this.updateBy = updateBy;
        this.contributions = contributions;
    }

    public List<Contribution> getContributions() {
        return contributions;
    }

    public void setContributions(List<Contribution> contributions) {
        this.contributions = contributions;
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

    public Float getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Float targetAmount) {
        this.targetAmount = targetAmount;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public SavingsBagStatusEnum getStatus() {
        return status;
    }

    public void setStatus(SavingsBagStatusEnum status) {
        this.status = status;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
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
