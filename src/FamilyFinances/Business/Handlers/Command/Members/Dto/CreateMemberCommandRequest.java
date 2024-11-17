package FamilyFinances.Business.Handlers.Command.Members.Dto;

import FamilyFinances.Domain.Constants.FamilyRoleEnum;
import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Family;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class CreateMemberCommandRequest {

    private User parentUser;
    private final UserStatusEnum status;
    private Role role;
    private final String firstName;
    private final String secondName;
    private final String firstLastName;
    private final String secondLastName;
    private final String gender;
    private final LocalDate dateOfBirth;
    private final String occupation;
    private final FamilyRoleEnum familyRole;
    private final String cellPhoneNumber;
    private Family family;
    private final LocalDateTime creationDate;
    private User createdBy;

    // Constructor que valida los argumentos
    public CreateMemberCommandRequest(
            User parentUser,
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
            User createdBy,
            UserStatusEnum status
    ) {
        if (parentUser == null) {
            throw new IllegalArgumentException("El Usuario del miembro es requerido.");
        }
        if (parentUser.getId() == null || parentUser.getId() < 1) {
            throw new IllegalArgumentException("El Id del Usuario del miembro es requerido.");
        }
        if (status == null) {
            throw new IllegalArgumentException("El estado del miembro es requerido.");
        }
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("El primer nombre del miembre es requerido.");
        }

        if (firstLastName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("El primer apellido del miembre es requerido.");
        }
        if (gender == null || (!gender.equalsIgnoreCase("male") && !gender.equalsIgnoreCase("female"))) {
            throw new IllegalArgumentException("El género del miembre no debe ser vacio");
        }

        if (familyRole == null) {
            throw new IllegalArgumentException("El rol familiar del miembre es requerido.");
        }

        if (family == null || family.getId() < 1) {
            throw new IllegalArgumentException("El Id familia del miembre es requetida.");
        }

        if (createdBy == null) {
            throw new IllegalArgumentException("El usuario creadordel miembre es requerido.");
        }

        if (createdBy.getId() == null || createdBy.getId() < 1) {
            throw new IllegalArgumentException("El Id dei Usuario creador del miembro es requerido.");
        }

        this.parentUser = parentUser;
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
        this.creationDate = LocalDateTime.now();
        this.createdBy = createdBy;
    }

    // Getters
    public UserStatusEnum getStatus() {
        return status;
    }

    public Role getRole() {
        return role;
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

    public Family getFamily() {
        return family;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    private void setRole(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("El Rol del usuario miembro es requerido.");
        }
        this.role = role;
    }

    public User getParentUser() {
        return parentUser;
    }

    public void setParentUser(User parentUser) {
        if (parentUser == null) {
            throw new IllegalArgumentException("El Usuario miembro es requerido.");
        }
        if (parentUser.getId() == null || parentUser.getId() < 1) {
            throw new IllegalArgumentException("El Id del usuario del miembre es requetida.");
        }
        this.parentUser = parentUser;
        this.setRole(parentUser.getRole());
    }

    public void setFamily(Family family) {

        if (family == null) {
            throw new IllegalArgumentException("La familia del miembro es requerida.");
        }
        if (family.getId() == null || family.getId() < 1) {
            throw new IllegalArgumentException("El Id de familia del miembre  es requetida.");
        }
        this.family = family;
    }

    public void setCreatedBy(User createdBy) {

        if (createdBy == null) {
            throw new IllegalArgumentException("El usuario creador del miembro es requerido.");
        }
        if (createdBy.getId() == null || createdBy.getId() < 1) {
            throw new IllegalArgumentException("El Id dei Usuario creador del miembro es requerido.");
        }
        this.createdBy = createdBy;
    }

}
