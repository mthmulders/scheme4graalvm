package it.mulders.scheme.parser;

import java.util.List;

import it.mulders.scheme.parser.ast.Argument;
import it.mulders.scheme.parser.ast.Combination;
import it.mulders.scheme.parser.ast.PrimitiveExpression;
import it.mulders.scheme.parser.ast.SchemeExpression;
import it.mulders.scheme.parser.visitors.SchemeExpressionsVisitor;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParserFacadeIT {
    private final SchemeParserFacade sut = new SchemeParserFacade();

    private final SchemeExpressionsVisitor visitor = new SchemeExpressionsVisitor();
    private final ANTLRErrorListener errorListener = new BailoutErrorListener();

    private List<SchemeExpression> parse(final String input) {
        return sut.parse(
            input,
            visitor,
            errorListener,
            true
        );
    }

    @Test
    void should_parse_primitive_expression() {
        // Arrange & act
        var expressions = parse("486");

        // Assert
        final SchemeExpression expected = PrimitiveExpression.builder().value(486).build();
        assertThat(expressions).containsOnly(expected);
    }

    @Test
    void should_parse_multiplication() {
        // Arrange & act
        var expressions = parse("(* 5 99)");

        // Assert
        var expected = Combination.builder()
                .operand("*")
                .argument(Argument.fromNumber(5))
                .argument(Argument.fromNumber(99))
                .build();
        assertThat(expressions).containsOnly(expected);
    }

    @Test
    void should_parse_combination_with_multiple_arguments() {
        // Arrange & act
        var expressions = parse("(+ 21 35 12 7)");

        // Assert
        var expected = Combination.builder()
                .operand("+")
                .argument(Argument.fromNumber(21))
                .argument(Argument.fromNumber(35))
                .argument(Argument.fromNumber(12))
                .argument(Argument.fromNumber(7))
                .build();
        assertThat(expressions).containsOnly(expected);
    }

    @Test
    void should_parse_combination() {
        // Arrange & act
        var expressions = sut.parse("(define size 2)", visitor, true);

        // Assert
        var expected = Combination.builder()
                .operand("define")
                .argument(Argument.fromName("size"))
                .argument(Argument.fromNumber(2))
                .build();
        assertThat(expressions).containsOnly(expected);
    }

}
