package it.mulders.scheme.parser.ast;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Operand {
    MULTIPLY("*"),
    DIVIDE("/"),
    ADD("+"),
    SUBTRACT("-"),
    LESS_THAN("<"),
    GREATER_THAN(">"),
    LESS_THAN_EQUAL("<="),
    GREATER_THAN_EQUAL(">="),
    EQUALS("="),
    NOT_EQUALS("!="),
    DEFINE("define");

    private final String symbol;

    public static Operand forSymbol(final String input) {
        return Arrays.stream(Operand.values())
                .filter(o -> o.symbol.equals(input))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
