package it.mulders.scheme.parser.ast;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class NameArgument implements Argument {
    private final String name; // Stored as a String, but in fact a symbol that refers to something else.

    @Override
    public String toString() {
        return name;
    }
}
