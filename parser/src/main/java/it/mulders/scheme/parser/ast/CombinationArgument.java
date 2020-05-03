package it.mulders.scheme.parser.ast;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CombinationArgument implements Argument {
    private final Combination combination;

    @Override
    public String toString() {
        return combination.toString();
    }
}
