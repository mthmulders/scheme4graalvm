package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.ast.Argument;
import it.mulders.scheme.parser.ast.Combination;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import it.mulders.scheme.parser.generated.SchemeVisitor;
import lombok.AllArgsConstructor;

/**
 * Visits a "combination", e.g.<code>(+ 2.7 10)</code> or <code>(* 5 99)</code>.
 */
@AllArgsConstructor
public class CombinationVisitor extends SchemeBaseVisitor<Combination.CombinationBuilder> implements PostprocessableSchemeVisitor<Combination.CombinationBuilder, Combination> {
    final Combination.CombinationBuilder builder = Combination.builder();

    @Override
    public Combination.CombinationBuilder visitOperand(SchemeParser.OperandContext ctx) {
        return builder.operand(ctx.getText());
    }

    @Override
    public Combination.CombinationBuilder visitArguments(final SchemeParser.ArgumentsContext ctx) {
        final var arguments = new ArgumentsVisitor().visit(ctx);
        builder.arguments(arguments);
        return builder;
    }

    @Override
    protected Combination.CombinationBuilder defaultResult() {
        return builder;
    }

    @Override
    public Combination postprocess() {
        return builder.build();
    }

    public static SchemeVisitor<Combination> wrap() {
        return new PostprocessingSchemeVisitor<>(new CombinationVisitor());
    }
}
