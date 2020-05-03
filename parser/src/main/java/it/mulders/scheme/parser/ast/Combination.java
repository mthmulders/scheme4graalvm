package it.mulders.scheme.parser.ast;

import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;

import static java.util.stream.Collectors.joining;

@Builder
@EqualsAndHashCode
@Getter
public class Combination implements SchemeExpression {
    private final String operand;

    @Singular
    private final List<Argument> arguments;

    public String toString() {
        var args = arguments.stream().map(Argument::toString).collect(joining(" "));
        return String.format("(%s %s)", operand, args);
    }
}
