package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.ast.PrimitiveExpression;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import it.mulders.scheme.parser.generated.SchemeVisitor;
import lombok.AllArgsConstructor;

/**
 * Visits a primitive expression, e.g. <code>486</code>
 */
@AllArgsConstructor
public class PrimitiveExpressionVisitor extends SchemeBaseVisitor<PrimitiveExpression.PrimitiveExpressionBuilder> implements PostprocessableSchemeVisitor<PrimitiveExpression.PrimitiveExpressionBuilder, PrimitiveExpression> {
    final PrimitiveExpression.PrimitiveExpressionBuilder builder = PrimitiveExpression.builder();

    @Override
    public PrimitiveExpression.PrimitiveExpressionBuilder visitNumber(final SchemeParser.NumberContext ctx) {
        return builder.value(new NumberVisitor().visit(ctx));
    }

    @Override
    public PrimitiveExpression postprocess() {
        return builder.build();
    }

    public static SchemeVisitor<PrimitiveExpression> wrap() {
        return new PostprocessingSchemeVisitor<>(new PrimitiveExpressionVisitor());
    }
}
