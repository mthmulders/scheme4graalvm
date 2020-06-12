package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.ast.PrimitiveExpression;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Visits a primitive expression, e.g. <code>486</code>
 */
@AllArgsConstructor
@Slf4j
public class PrimitiveExpressionVisitor extends SchemeBaseVisitor<PrimitiveExpression.PrimitiveExpressionBuilder> {
    final PrimitiveExpression.PrimitiveExpressionBuilder builder = PrimitiveExpression.builder();

    @Override
    public PrimitiveExpression.PrimitiveExpressionBuilder visitNumber(final SchemeParser.NumberContext ctx) {
        log.trace("visitNumber( {} )", ctx.getText());
        return builder.value(new NumberVisitor().visit(ctx));
    }
}
