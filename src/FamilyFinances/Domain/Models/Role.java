package FamilyFinances.Domain.Models;

/**
 *
 * @author johnarrieta
 */
import FamilyFinances.Domain.Constants.EntityStatusEnum;

/**
 *
 * @author johnarrieta
 */
public enum Role implements Comparable<Role> {
    ADMINISTRATOR(1, "Administrador", "Rol de administrador", EntityStatusEnum.ENABLED),
    MEMBER(2, "Miembro", "Rol de miembro", EntityStatusEnum.ENABLED);

    private final Integer id;
    private final String name;
    private String description;
    private EntityStatusEnum status;

    // Constructor
    private Role(Integer id, String name, String description, EntityStatusEnum status) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public EntityStatusEnum getStatus() {
        return status;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(EntityStatusEnum status) {
        this.status = status;
    }
}
