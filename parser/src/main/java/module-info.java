module it.mulders.scheme4graalvm.parser {
    requires static lombok;
    requires org.antlr.antlr4.runtime;
    requires org.slf4j;

    exports it.mulders.scheme.parser;
}