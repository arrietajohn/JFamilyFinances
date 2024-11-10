package FamilyFinances.Business.Handlers.Command.Users.Dto;

import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;
import java.time.LocalDateTime;

/**
 *
 * @author johnarrieta
 */
public class CreateUserCommandRequest {
    private String code;
    private String password;
    private String name;
    private String email;
    private UserStatusEnum status;
    private Role role;
    private User createdBy;
    private LocalDateTime createdDate;

    public CreateUserCommandRequest(String code, String password, String name, String email, UserStatusEnum status, Role role, User createdBy) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("El código del usuario es requerido");
        }
        if (password == null || password.isBlank()) {
            throw new IllegalArgumentException("La contraseña del usuario es requerida");
        }
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre del usuario es requerido");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("El correo electrónico del usuario es requerido");
        }
        if (status == null) {
           status = UserStatusEnum.PENDING;
        }
        if (role == null) {
            throw new IllegalArgumentException("El rol del usuario es requerido");
        }
        if (createdBy == null) {
            throw new IllegalArgumentException("El creador del usuario es requerido");
        }

        this.code = code;
        this.password = password;
        this.name = name;
        this.email = email;
        this.status = status;
        this.role = role;
        this.createdBy = createdBy;
        this.createdDate = LocalDateTime.now();
    }

    public String getCode() {
        return code;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserStatusEnum getStatus() {
        return status;
    }

    public Role getRole() {
        return role;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }
    
    
}
