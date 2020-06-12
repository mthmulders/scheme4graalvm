package it.mulders.scheme.parser.visitors;

import java.util.ArrayList;
import java.util.List;

import it.mulders.scheme.parser.ast.SchemeExpression;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchemeExpressionsVisitor extends SchemeBaseVisitor<List<SchemeExpression>> {
    private final List<SchemeExpression> expressions = new ArrayList<>();

    @Override
    public List<SchemeExpression> visitCombination(final SchemeParser.CombinationContext ctx) {
        log.trace("visitCombination( {} )", ctx.getText());
        var expression = new CombinationVisitor().visit(ctx).build();
        expressions.add(expression);
        return expressions;
    }

    @Override
    public List<SchemeExpression> visitCompoundProcedure(final SchemeParser.CompoundProcedureContext ctx) {
        log.trace("visitCompoundProcedure( {} )", ctx.getText());
        var expression = new CompoundProcedureVisitor().visit(ctx).build();
        expressions.add(expression);
        return expressions;
    }

    @Override
    public List<SchemeExpression> visitPrimitiveExpression(final SchemeParser.PrimitiveExpressionContext ctx) {
        log.trace("visitPrimitiveExpression( {} )", ctx.getText());
        var expression = new PrimitiveExpressionVisitor().visitPrimitiveExpression(ctx).build();
        expressions.add(expression);
        return expressions;
    }

    @Override
    protected List<SchemeExpression> defaultResult() {
        return expressions;
    }
}
