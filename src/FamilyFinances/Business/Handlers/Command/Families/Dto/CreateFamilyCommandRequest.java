package FamilyFinances.Business.Handlers.Command.Families.Dto;

import FamilyFinances.Domain.Constants.EntityStatusEnum;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class CreateFamilyCommandRequest {

    private final String name;
    private final String phoneNumber;
    private final String address;
    private final LocalDateTime creationDate;
    private final User createdBy;
    private final EntityStatusEnum status;

    public CreateFamilyCommandRequest(String name, String phoneNumber, String address, LocalDateTime creationDate, User createdBy, EntityStatusEnum status) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.creationDate = creationDate;
        this.createdBy = createdBy;
        this.status = status;
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

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public EntityStatusEnum getStatus() {
        return status;
    }
    
    
}
