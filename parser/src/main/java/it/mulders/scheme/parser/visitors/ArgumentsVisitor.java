package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.ast.Argument;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import it.mulders.scheme.parser.generated.SchemeVisitor;

import java.util.ArrayList;
import java.util.List;

public class ArgumentsVisitor extends SchemeBaseVisitor<List<Argument>> implements SchemeVisitor<List<Argument>> {
    final List<Argument> arguments = new ArrayList<>();

    @Override
    public List<Argument> visitArgument(final SchemeParser.ArgumentContext ctx) {
        var argument = new ArgumentVisitor().visit(ctx);
        arguments.add(argument);
        return arguments;
    }

    @Override
    protected List<Argument> defaultResult() {
        return arguments;
    }
}
