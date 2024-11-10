package FamilyFinances.Business.Handlers.Queries.Families.Dto;

import FamilyFinances.Domain.Constants.EntityStatusEnum;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class UpdateFamilyCommandRequest {

    private final Integer id;
    private final String name;
    private final String phoneNumber;
    private final String address;
    private final LocalDateTime updatedDate;
    private final User updatedBy;
    private final EntityStatusEnum status;

    public UpdateFamilyCommandRequest(Integer id, String name, String phoneNumber, String address, LocalDateTime updatedDate, User updatedBy, EntityStatusEnum status) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public User getUpdatedBy() {
        return updatedBy;
    }

    public EntityStatusEnum getStatus() {
        return status;
    }

}
