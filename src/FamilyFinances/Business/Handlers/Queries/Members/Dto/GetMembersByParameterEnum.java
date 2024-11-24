package FamilyFinances.Business.Handlers.Queries.Members.Dto;

/**
 *
 * @author johnarrieta
 */
public enum GetMembersByParameterEnum {
    ALL,
    STATUS,
    GENDER,
    OCUPATION,
    PHONE_NUMBER,
    DATE_OF_BIRTH,
    ROLE_IN_THE_FAMILY,
    DATE_OF_BIRTH_BETEEW,
    FIRST_OR_SECOND_NAME,
    FIRST_OR_SECOND_LAST_NAME;

    public String toSpanish() {
        return switch (this) {
            case ALL ->
                "TODOS";
            case STATUS ->
                "ESTADO";
            case GENDER ->
                "GENERO";
            case OCUPATION ->
                "OCUPACÍON";
            case PHONE_NUMBER ->
                "NUMERO DE TELEFONO";
            case DATE_OF_BIRTH ->
                "FECHA DE CUMPLEAÑOS";
            case DATE_OF_BIRTH_BETEEW ->
                "RANGO DE FECHA DE CUMPLEAÑOS";
            case ROLE_IN_THE_FAMILY ->
                "ROL EN LA FAMILIA";
            case FIRST_OR_SECOND_NAME ->
                "PRIMER O SEGUNDO NOMBRE";
            case FIRST_OR_SECOND_LAST_NAME ->
                "PRIMER O SEGUNDO APELLIDO";
            default ->
                "PARAMETRO INVALIDO";
        };
    }

    public static GetMembersByParameterEnum toEnglish(String spanishValue) {
        return switch (spanishValue) {
            case "TODOS" ->
                GetMembersByParameterEnum.ALL;
            case "ESTADO" ->
                GetMembersByParameterEnum.STATUS;
            case "GENERO" ->
                GetMembersByParameterEnum.GENDER;
            case "OCUPACÍON" ->
                GetMembersByParameterEnum.OCUPATION;
            case "NUMERO DE TELEFONO" ->
                GetMembersByParameterEnum.PHONE_NUMBER;
            case "FECHA DE CUMPLEAÑOS" ->
                GetMembersByParameterEnum.DATE_OF_BIRTH;
            case "ROL EN LA FAMILIA" ->
                GetMembersByParameterEnum.ROLE_IN_THE_FAMILY;
            case "DATE_OF_BIRTH_BETEEW" ->
                GetMembersByParameterEnum.DATE_OF_BIRTH_BETEEW;
            case "RANGO DE FECHA DE CUMPLEAÑOS" ->
                GetMembersByParameterEnum.FIRST_OR_SECOND_NAME;
            case "PRIMER O SEGUNDO APELLIDO" ->
                GetMembersByParameterEnum.FIRST_OR_SECOND_LAST_NAME;
            default ->
                null;
        };
    }

}
