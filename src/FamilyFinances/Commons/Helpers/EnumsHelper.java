package FamilyFinances.Commons.Helpers;

import FamilyFinances.Domain.Constants.FamilyRoleEnum;

/**
 *
 * @author johnarrieta
 */
public class EnumsHelper {
    public static String getFamilyReleInSpanish(FamilyRoleEnum familyRole){
        return switch (familyRole){
        case FATHER -> "Padre";
        case MOTHER -> "Madre";
        case SON -> "Hijo";
        case DAUGHTER -> "Hija";
        case GRANDFATHER -> "Abuelo";
        case GRANTMOTHER -> "Abuela";
        case UNCLE -> "Tío";
        case AUNT -> "Tía";
        case NEPHEW -> "Sobrino";
        case NIECE -> "Sobrina";
        case FATHER_IN_LAW -> "Suegro";
        case DAUGHTER_IN_LAW -> "Nuera";
        default -> "Otro rol familiar";
        };
    }
}
