package FamilyFinances.Domain.Models;

import FamilyFinances.Domain.Constants.EntityStatusEnum;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author johnarrieta
 */
public class Family implements Comparable<Family>{

    private Integer id;
    private String name;
    private String phoneNumber;
    private String address;
    private List<Member> members;
    private List<SavingsBag> savingsBags;
    private LocalDateTime creationDate;
    private LocalDateTime updateDate;
    private User createdBy;
    private User updateBy;
    private EntityStatusEnum status;
    private Set<MembershipRequest> membershipRequests = new TreeSet<>();

    public Family(String name, String phoneNumber, String address, List<Member> members) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.members = members;
    }

    public Family() {
    }

    public Family(Integer id, 
            String name, 
            String phoneNumber, 
            String address, 
            LocalDateTime creationDate, 
            User createdBy, 
            EntityStatusEnum status) 
    {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.status = status;
    }

    public int compareTo(Family other) {
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
        Family theOther = (Family) other;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public List<SavingsBag> getSavingsBags() {
        return savingsBags;
    }

    public void setSavingsBags(List<SavingsBag> savingsBags) {
        this.savingsBags = savingsBags;
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

    public EntityStatusEnum getStatus() {
        return status;
    }

    public void setStatus(EntityStatusEnum status) {
        this.status = status;
    }

    public Set<MembershipRequest> getMembershipRequests() {
        return membershipRequests;
    }

    public void setMembershipRequests(Set<MembershipRequest> membershipRequests) {
        this.membershipRequests = membershipRequests;
    }

}
