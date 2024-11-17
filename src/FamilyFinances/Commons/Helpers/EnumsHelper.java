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
    
    public static FamilyRoleEnum getFamilyRoleEnum(String familyRoleInSpanish) {
        return switch (familyRoleInSpanish) {
            case "Padre" -> FamilyRoleEnum.FATHER;
            case "Madre" -> FamilyRoleEnum.MOTHER;
            case "Hijo" -> FamilyRoleEnum.SON;
            case "Hija" -> FamilyRoleEnum.DAUGHTER;
            case "Abuelo" -> FamilyRoleEnum.GRANDFATHER;
            case "Abuela" -> FamilyRoleEnum.GRANTMOTHER;
            case "Tío" -> FamilyRoleEnum.UNCLE;
            case "Tía" -> FamilyRoleEnum.AUNT;
            case "Sobrino" -> FamilyRoleEnum.NEPHEW;
            case "Sobrina" -> FamilyRoleEnum.NIECE;
            case "Suegro" -> FamilyRoleEnum.FATHER_IN_LAW;
            case "Nuera" -> FamilyRoleEnum.DAUGHTER_IN_LAW;
            default -> FamilyRoleEnum.OTHER;
        };
    }
    
}
