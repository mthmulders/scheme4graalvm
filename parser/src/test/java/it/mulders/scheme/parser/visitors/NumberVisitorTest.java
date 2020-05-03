package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.generated.SchemeParser;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class NumberVisitorTest implements WithAssertions {
    private final NumberVisitor visitor = new NumberVisitor();

    private SchemeParser.NumberContext prepareContext(final String input) {
        var context = new SchemeParser.NumberContext(null, -1);
        context.addChild(new TerminalNodeImpl(new CommonToken(0, input)));

        return context;
    }

    @Test
    void should_parse_integer() {
        var context = prepareContext("1");

        var result = visitor.visitNumber(context);

        assertThat(result).isEqualTo(1);
    }

    @Test
    void should_parse_real() {
        var context = prepareContext("1.3");

        var result = visitor.visitNumber(context);

        assertThat(result).isEqualTo(1.3);
    }

    @Test
    void should_not_parse_arbitrary_text() {
        var context = prepareContext("abc");

        var result = visitor.visitNumber(context);

        assertThat(result).isNull();
    }

    @Test
    void should_not_parse_null() {
        var context = prepareContext(null);

        var result = visitor.visitNumber(context);

        assertThat(result).isNull();
    }
}