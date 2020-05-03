package it.mulders.scheme.parser.ast;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class StringArgument implements Argument {
    private final String value;

    @Override
    public String toString() {
        return value;
    }
}
