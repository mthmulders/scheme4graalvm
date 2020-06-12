package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.ast.Argument;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import it.mulders.scheme.parser.generated.SchemeVisitor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ArgumentsVisitor extends SchemeBaseVisitor<List<Argument>> implements SchemeVisitor<List<Argument>> {
    final List<Argument> arguments = new ArrayList<>();

    @Override
    public List<Argument> visitArgument(final SchemeParser.ArgumentContext ctx) {
        log.trace("visitArgument( {} )", ctx.getText());
        var argument = new ArgumentVisitor().visit(ctx);
        arguments.add(argument);
        return arguments;
    }

    @Override
    protected List<Argument> defaultResult() {
        return arguments;
    }
}
