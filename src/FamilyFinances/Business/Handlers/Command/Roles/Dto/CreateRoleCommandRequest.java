
package FamilyFinances.Business.Handlers.Command.Roles.Dto;

/**
 * @author johnarrieta
 */
public class CreateRoleCommandRequest {
    
    private final Integer id;
    private final String name; 
    private final String description;

    public CreateRoleCommandRequest(Integer id, String name, String description) {
        if(id == null || id.intValue() == 0){
            throw new IllegalArgumentException("El Id del Rol es requerido");
        }
        if(name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("El Nombre del Rel es requerido");
        }
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }
}






