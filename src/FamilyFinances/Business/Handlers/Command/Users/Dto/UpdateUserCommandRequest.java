package FamilyFinances.Business.Handlers.Command.Users.Dto;

import FamilyFinances.Domain.Constants.UserStatusEnum;
import FamilyFinances.Domain.Models.Role;
import FamilyFinances.Domain.Models.User;

/**
 *
 * @author johnarrieta
 */
import java.time.LocalDateTime;

public class UpdateUserCommandRequest {

    private Integer id;
    private String code;
    private String password;
    private String name;
    private String email;
    private UserStatusEnum status;
    private Role role;
    private User updateBy;
    private LocalDateTime updateDate;

    public UpdateUserCommandRequest(Integer id, String code, String password, String name, String email, UserStatusEnum status, Role role, User updateBy) {
        if (id == null || id < 1) {
            throw new IllegalArgumentException("El ID del usuario es requerido y debe ser mayor que 0");
        }
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
            throw new IllegalArgumentException("El estado del usuario es requerido");
        }
        if (role == null) {
            throw new IllegalArgumentException("El rol del usuario es requerido");
        }

        this.id = id;
        this.code = code;
        this.password = password;
        this.name = name;
        this.email = email;
        this.status = status;
        this.role = role;
        this.updateBy = updateBy;
        this.updateDate = LocalDateTime.now();
    }

    public Integer getId() {
        return id;
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

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public User getUpdateBy() {
        return updateBy;
    }
}
