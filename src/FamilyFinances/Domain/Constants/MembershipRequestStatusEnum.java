package FamilyFinances.Domain.Constants;

/**
 *
 * @author johnarrieta
 */
public enum MembershipRequestStatusEnum {
    PENDING,
    APPROVED,
    REJECTED;

    public String toSpanish() {
        switch (this) {
            case PENDING:
                return "Pendiente";
            case APPROVED:
                return "Aprobada";
            case REJECTED:
                return "Rechazada";
            default:
                throw new IllegalArgumentException("Estado no reconocido: " + this);
        }
    }

    public static String fromEnglish(MembershipRequestStatusEnum status) {
        return status.toSpanish();
    }

    public static MembershipRequestStatusEnum fromSpanish(String translation) {
        switch (translation) {
            case "Pendiente":
                return PENDING;
            case "Aprobada":
                return APPROVED;
            case "Rechazada":
                return REJECTED;
            default:
                throw new IllegalArgumentException("No se encontró el estado para la traducción: " + translation);
        }
    }
}
