package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.ast.Argument;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import it.mulders.scheme.parser.generated.SchemeVisitor;

public class ArgumentVisitor extends SchemeBaseVisitor<Argument> implements SchemeVisitor<Argument> {
    @Override
    public Argument visitNumber(final SchemeParser.NumberContext ctx) {
        var maybeNumber = new NumberVisitor().visit(ctx);
        return maybeNumber != null ? Argument.fromNumber(maybeNumber) : null;
    }

    @Override
    public Argument visitCombination(final SchemeParser.CombinationContext ctx) {
        var combination = CombinationVisitor.wrap().visit(ctx);
        return Argument.fromCombination(combination);
    }

    @Override
    public Argument visitName(final SchemeParser.NameContext ctx) {
        return Argument.fromName(ctx.getText());
    }
}
