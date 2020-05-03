package it.mulders.scheme.parser;

import it.mulders.scheme.parser.generated.SchemeLexer;
import it.mulders.scheme.parser.generated.SchemeParser;
import it.mulders.scheme.parser.generated.SchemeVisitor;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class SchemeParserFacade {
    public <T> T parse(final String input, final SchemeVisitor<T> visitor, final ANTLRErrorListener errorListener, final boolean debug) {
        var lexer = new SchemeLexer(CharStreams.fromString(input));
        var tokens = new CommonTokenStream(lexer);

        var parser = new SchemeParser(tokens);

        if (debug) {
            parser.addParseListener(new DebugSchemeListener());
        }
        if (errorListener != null) {
            parser.addErrorListener(errorListener);
        }

        var context = parser.expressions();
        return visitor.visit(context);
    }

    public <T> T parse(final String input, final SchemeVisitor<T> visitor, final boolean debug) {
        return parse(input, visitor, null, debug);
    }

    public <T> T parse(final String input, final SchemeVisitor<T> visitor) {
        return parse(input, visitor, null, false);
    }

}
