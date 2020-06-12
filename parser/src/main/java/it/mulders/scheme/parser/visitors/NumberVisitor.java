package it.mulders.scheme.parser.visitors;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import it.mulders.scheme.parser.generated.SchemeVisitor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumberVisitor extends SchemeBaseVisitor<Number> implements SchemeVisitor<Number> {
    private static final List<Function<String, Number>> PARSERS = Arrays.asList(
            Integer::parseInt,
            Double::parseDouble
    );

    @Override
    public Number visitNumber(SchemeParser.NumberContext ctx) {
        log.trace("visitNumber( {} )", ctx.getText());
        var value = ctx.getText();

        for (Function<String, Number> parser : PARSERS) {
            try {
                return parser.apply(value);
            } catch (NumberFormatException ignored) {
                log.warn("Value {} is not a number", value);
            }
        }

        return null;
    }
}
