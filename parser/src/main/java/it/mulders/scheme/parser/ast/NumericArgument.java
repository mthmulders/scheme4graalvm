package it.mulders.scheme.parser.ast;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NumericArgument implements Argument {
    private final Number value;

    @Override
    public String toString() {
        return value.toString();
    }
}
