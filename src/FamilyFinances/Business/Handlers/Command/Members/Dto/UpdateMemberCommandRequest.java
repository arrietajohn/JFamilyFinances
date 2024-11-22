package FamilyFinances.Business.Handlers.Command.Members.Dto;

import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class UpdateMemberCommandRequest {

    private final Integer parentUserId;
    private final UserStatusEnum status;
    private final String firstName;
    private final String secondName;
    private final String firstLastName;
    private final String secondLastName;
    private final String gender;
    private final LocalDate dateOfBirth;
    private final String occupation;
    private final FamilyRoleEnum familyRole;
    private final String cellPhoneNumber;
    private final Family family;
    private final LocalDateTime updateDe;
    private final User updateBy;

    public UpdateMemberCommandRequest(
            Integer parentUserId,
            UserStatusEnum status,
            String firstName,
            String secondName,
            String firstLastName,
            String secondLastName,
            String gender,
            LocalDate dateOfBirth,
            String occupation,
            FamilyRoleEnum familyRole,
            String cellPhoneNumber,
            Family family,
            User updateBy) {
        if (parentUserId == null || parentUserId < 1) {
            throw new IllegalArgumentException("userId debe ser un número positivo.");
        }
        if (status == null) {
            throw new IllegalArgumentException("El estado es reqierido");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("El primer nombre es requerido");
        }
       
        if (firstLastName == null || firstLastName.isBlank()) {
            throw new IllegalArgumentException("El primer apellido es requerido");
        }
       
        if (dateOfBirth != null && dateOfBirth.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento incorrecta");
        }
      
        if (familyRole == null) {
            throw new IllegalArgumentException("El rol en la famifamil es requerido");
        }
         if (family == null ) {
            throw new IllegalArgumentException("La familia es es requerida");
        }
        
        if (updateBy == null ) {
            throw new IllegalArgumentException("El Id del usuario actualizador es requerido");
        }
        

        this.parentUserId = parentUserId;
        this.status = status;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;
        this.familyRole = familyRole;
        this.cellPhoneNumber = cellPhoneNumber;
        this.family = family;
        this.updateBy = updateBy;
        this.updateDe = LocalDateTime.now();
    }

    public Integer getParentUserId() {
        return parentUserId;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public FamilyRoleEnum getFamilyRole() {
        return familyRole;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public LocalDateTime getUpdateDe() {
        return updateDe;
    }

    public User getUpdateBy() {
        return updateBy;
    }

    public Family getFamily() {
        return family;
    }

    
}
