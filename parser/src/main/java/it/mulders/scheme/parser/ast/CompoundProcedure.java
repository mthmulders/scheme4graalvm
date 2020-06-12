package it.mulders.scheme.parser.ast;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Singular;

import java.util.List;

@Builder
@EqualsAndHashCode
@Getter
public class CompoundProcedure implements SchemeExpression {
    private final String name;

    @Singular
    private final List<String> parameters;

    @Singular
    private final List<? extends SchemeExpression> expressions;

    public String toString() {
        var args = String.join(" ", parameters);
        return String.format("(define (%s %s) (...%d expressions...))", name, args, expressions.size());
    }
}
