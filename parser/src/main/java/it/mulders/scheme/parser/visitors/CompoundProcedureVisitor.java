package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.ast.CompoundProcedure;
import it.mulders.scheme.parser.ast.CompoundProcedure.CompoundProcedureBuilder;
import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CompoundProcedureVisitor extends SchemeBaseVisitor<CompoundProcedureBuilder> {
    private final CompoundProcedureBuilder builder = CompoundProcedure.builder();

    @Override
    public CompoundProcedureBuilder visitArguments(final SchemeParser.ArgumentsContext ctx) {
        log.trace("visitArguments( {} )", ctx.getText());
        var arguments = new ParametersVisitor().visit(ctx);
        builder.parameters(arguments);
        return builder;
    }

    @Override
    public CompoundProcedureBuilder visitName(final SchemeParser.NameContext ctx) {
        log.trace("visitName( {} )", ctx.getText());
        return builder.name(ctx.getText());
    }

    @Override
    public CompoundProcedureBuilder visitPrimitiveExpression(final SchemeParser.PrimitiveExpressionContext ctx) {
        log.trace("visitPrimitiveExpression( {} )", ctx.getText());
        var expression = new PrimitiveExpressionVisitor().visitPrimitiveExpression(ctx).build();
        return builder.expression(expression);
    }

    @Override
    public CompoundProcedureBuilder visitCombination(final SchemeParser.CombinationContext ctx) {
        log.trace("visitCombination( {} )", ctx.getText());
        var expression = new CombinationVisitor().visitCombination(ctx).build();
        return builder.expression(expression);
    }

    @Override
    protected CompoundProcedureBuilder defaultResult() {
        return builder;
    }
}
