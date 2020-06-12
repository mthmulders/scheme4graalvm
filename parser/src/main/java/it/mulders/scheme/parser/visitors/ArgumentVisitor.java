package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.ast.Argument;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import it.mulders.scheme.parser.generated.SchemeVisitor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ArgumentVisitor extends SchemeBaseVisitor<Argument> implements SchemeVisitor<Argument> {
    @Override
    public Argument visitNumber(final SchemeParser.NumberContext ctx) {
        log.trace("visitNumber( {} )", ctx.getText());
        var maybeNumber = new NumberVisitor().visit(ctx);
        return maybeNumber != null ? Argument.fromNumber(maybeNumber) : null;
    }

    @Override
    public Argument visitCombination(final SchemeParser.CombinationContext ctx) {
        log.trace("visitCombination( {} )", ctx.getText());
        var combination = new CombinationVisitor().visit(ctx).build();
        return Argument.fromCombination(combination);
    }

    @Override
    public Argument visitName(final SchemeParser.NameContext ctx) {
        log.trace("visitName( {} )", ctx.getText());
        return Argument.fromName(ctx.getText());
    }
}
