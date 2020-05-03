package it.mulders.scheme.parser.ast;

public interface Argument {
    static Argument fromNumber(final Number number) {
        return new NumericArgument(number);
    }

    static Argument fromString(final String string) {
        return new StringArgument(string);
    }

    static Argument fromName(final String name) {
        return new NameArgument(name);
    }

    static Argument fromCombination(final Combination combination) {
        return new CombinationArgument(combination);
    }

    @Override
    String toString();
}
