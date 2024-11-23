package FamilyFinances.Domain.Models;

import FamilyFinances.Domain.Constants.EntityStatusEnum;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author johnarrieta
 */
public class Source implements Comparable<Source>{

    private Integer id;
    private String name;
    private String descripcion;
    private List<Income> incomes;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private User createdBy;
    private User updatedBy;
    private EntityStatusEnum status;

    public Source() {
    }

    public Source(String name, String descripcion) {
        this.name = name;
        this.descripcion = descripcion;
    }

    public Source(Integer id, String name, String descripcion, List<Income> incomes, LocalDateTime creationDate, LocalDateTime updateDate, User createdBy, User updatedBy) {
        this.id = id;
        this.name = name;
        this.descripcion = descripcion;
        this.incomes = incomes;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }

    public int compareTo(Source other) {
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
        Source theOther = (Source) other;
        return Objects.equals(id, theOther.id)
                && Objects.equals(name.toLowerCase(), theOther.name.toLowerCase());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<Income> getIncomes() {
        return incomes;
    }

    public void setIncomes(List<Income> incomes) {
        this.incomes = incomes;
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

    public User getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(User updateBy) {
        this.updatedBy = updateBy;
    }

    public EntityStatusEnum getStatus() {
        return status;
    }

    public void setStatus(EntityStatusEnum status) {
        this.status = status;
    }

}
