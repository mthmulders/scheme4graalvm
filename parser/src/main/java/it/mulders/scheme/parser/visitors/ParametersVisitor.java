package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeParser;
import it.mulders.scheme.parser.generated.SchemeVisitor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class ParametersVisitor extends SchemeBaseVisitor<List<String>> implements SchemeVisitor<List<String>> {
    final List<String> parameters = new ArrayList<>();

    @Override
    public List<String> visitArgument(final SchemeParser.ArgumentContext ctx) {
        log.trace("visitArgument( {} )", ctx.getText());
        var parameter = ctx.getText();
        parameters.add(parameter);
        return parameters;
    }

    @Override
    protected List<String> defaultResult() {
        return parameters;
    }
}
