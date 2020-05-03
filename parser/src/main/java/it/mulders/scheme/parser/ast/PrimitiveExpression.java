package it.mulders.scheme.parser.ast;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@EqualsAndHashCode
@Getter
public class PrimitiveExpression implements SchemeExpression {
    private final Number value;

    public String toString() {
        return String.format("%s", value);
    }
}
