package it.mulders.scheme.parser.visitors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.mulders.scheme.parser.ast.SchemeExpression;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SchemeExpressionsVisitor extends SchemeBaseVisitor<List<SchemeExpression>> {
    @Override
    public List<SchemeExpression> visitCombination(SchemeParser.CombinationContext ctx) {
        var expression = CombinationVisitor.wrap().visit(ctx);
        return Collections.singletonList(expression);
    }

    @Override
    public List<SchemeExpression> visitPrimitiveExpression(SchemeParser.PrimitiveExpressionContext ctx) {
        var expression = PrimitiveExpressionVisitor.wrap().visit(ctx);
        return Collections.singletonList(expression);
    }

    @Override
    protected List<SchemeExpression> defaultResult() {
        return Collections.emptyList();
    }

    @Override
    protected List<SchemeExpression> aggregateResult(List<SchemeExpression> aggregate, List<SchemeExpression> nextResult) {
        var result = new ArrayList<SchemeExpression>();
        result.addAll(aggregate);
        result.addAll(nextResult);
        return result;
    }
}
