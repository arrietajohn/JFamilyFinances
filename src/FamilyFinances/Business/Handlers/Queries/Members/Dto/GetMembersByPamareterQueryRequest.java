package FamilyFinances.Business.Handlers.Queries.Members.Dto;

import FamilyFinances.Commons.Helpers.GenericParameter;
import java.time.LocalDateTime;
import FamilyFinances.Commons.CustomTypes.DateRangeCustomValueType;

/**
 *
 * @author johnarrieta
 */
public class GetMembersByPamareterQueryRequest {

    private GenericParameter<?, ?, ?> parameter;

    public GetMembersByPamareterQueryRequest(GenericParameter<?, ?, ?> parameter) {
        this.parameter = parameter;
        validParameter();
    }

    private void validParameter() {
        if (parameter == null) {
            throw new IllegalArgumentException("El parametro es requerido");
        }

        if (!(parameter.getName() instanceof GetMembersByParameterEnum)) {
            throw new IllegalArgumentException("Parametro invalido");
        }

        Class<?> type = parameter.getValueType();
        Object value = parameter.getValue();
        GetMembersByParameterEnum name = (GetMembersByParameterEnum) parameter.getName();
        var message = "El valor del parametro " + name.toSpanish() + " es requerido";

        if (type == String.class) {
            String strValue = (String) value;
            if (strValue == null || strValue.isBlank()) {
                throw new IllegalArgumentException(message);
            }
        } else if (Number.class.isAssignableFrom(type)) {
            if (type == Integer.class) {
                var intValue = (Integer) value;
                if (intValue == null || intValue < 1) {
                    throw new IllegalArgumentException(message);
                }
            }
        } else if (type == LocalDateTime.class) {
            var dateValue = (LocalDateTime) value;
            if (dateValue == null) {
                throw new IllegalArgumentException(message);
            }
        } else if (type == Boolean.class) {
            var boolValue = (Boolean) value;
            if (boolValue == null) {
                throw new IllegalArgumentException(message);
            }
        } else if (type.isEnum()) {
            var enumValue = (Enum<?>) value;
            if (enumValue == null) {
                throw new IllegalArgumentException(message);
            }
        } else if (type == DateRangeCustomValueType.class) {
            var dateRangeValue = (DateRangeCustomValueType) value;
            if (dateRangeValue == null) {
                throw new IllegalArgumentException(message);
            }
        } else {
            var errorMessage = "Es incorrecto el tipo " + type.getSimpleName() + " para el parametro " + name.toSpanish();
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public GenericParameter<?, ?, ?> getParameter() {
        return parameter;
    }
}
