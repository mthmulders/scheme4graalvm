package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.ast.Combination;
import it.mulders.scheme.parser.ast.Operand;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Visits a "combination", e.g.<code>(+ 2.7 10)</code> or <code>(* 5 99)</code>.
 */
@AllArgsConstructor
@Slf4j
public class CombinationVisitor extends SchemeBaseVisitor<Combination.CombinationBuilder> {
    private final Combination.CombinationBuilder builder = Combination.builder();

    @Override
    public Combination.CombinationBuilder visitOperand(SchemeParser.OperandContext ctx) {
        log.trace("visitOperand( {} )", ctx.getText());
        var operand = Operand.forSymbol(ctx.getText());
        return builder.operand(operand);
    }

    @Override
    public Combination.CombinationBuilder visitArguments(final SchemeParser.ArgumentsContext ctx) {
        log.trace("visitArguments( {} )", ctx.getText());
        var arguments = new ArgumentsVisitor().visit(ctx);
        builder.arguments(arguments);
        return builder;
    }

    @Override
    protected Combination.CombinationBuilder defaultResult() {
        return builder;
    }
}
