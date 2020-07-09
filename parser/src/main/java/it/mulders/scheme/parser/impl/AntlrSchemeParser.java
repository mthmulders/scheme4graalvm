package it.mulders.scheme.parser.impl;

import it.mulders.scheme.parser.SchemeParser;
import it.mulders.scheme.parser.ast.SchemeExpression;
import it.mulders.scheme.parser.generated.SchemeLexer;
import it.mulders.scheme.parser.generated.SchemeVisitor;
import it.mulders.scheme.parser.visitors.SchemeExpressionsVisitor;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import java.util.Collection;

/**
 * Implementation of the {@link SchemeParser} interface based on ANTLR (v4).
 */
public class AntlrSchemeParser implements SchemeParser {
    public <T> T parse(final CharSequence input, final SchemeVisitor<T> visitor, final ANTLRErrorListener errorListener, final boolean debug) {
        var lexer = new SchemeLexer(CharStreams.fromString(input.toString()));
        var tokens = new CommonTokenStream(lexer);

        var parser = new it.mulders.scheme.parser.generated.SchemeParser(tokens);

        if (debug) {
            parser.addParseListener(new DebugSchemeListener());
        }
        if (errorListener != null) {
            parser.addErrorListener(errorListener);
        }

        var context = parser.program();
        return visitor.visit(context);
    }

    public <T> T parse(final CharSequence input, final SchemeVisitor<T> visitor, final boolean debug) {
        return parse(input, visitor, null, debug);
    }

    public <T> T parse(final CharSequence input, final SchemeVisitor<T> visitor) {
        return parse(input, visitor, null, false);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<SchemeExpression> parse(final CharSequence input) {
        return parse(input, new SchemeExpressionsVisitor());
    }

}
