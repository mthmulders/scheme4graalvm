package it.mulders.scheme.parser;

import it.mulders.scheme.parser.ast.SchemeExpression;

import java.util.Collection;

/**
 * Component that can parse an input and returns a {@link Collection} of {@link SchemeExpression}.
 */
public interface SchemeParser {
    /**
     * Parses a {@link String} of input, resulting in a {@link Collection} containing zero or more {@link SchemeExpression} instances.
     * @param input Input to parse. May be empty, but not <code>null</code>.
     * @return The parsed expressions. Can be empty, but never <code>null</code>.
     */
    Collection<SchemeExpression> parse(final String input);
}
