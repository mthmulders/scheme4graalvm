import it.mulders.scheme.parser.SchemeParser;
import it.mulders.scheme.parser.impl.AntlrSchemeParser;

module it.mulders.scheme4graalvm.parser {
    requires static lombok;

    requires org.antlr.antlr4.runtime;
    requires org.slf4j;

    exports it.mulders.scheme.parser;
    exports it.mulders.scheme.parser.ast;

    provides SchemeParser with AntlrSchemeParser;
}