package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.generated.SchemeBaseVisitor;
import it.mulders.scheme.parser.generated.SchemeVisitor;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.tree.ParseTree;

/**
 * Extension of the ANTLR4-generated {@link PostprocessingSchemeVisitor} which allows a information that can be retrieved later.
 * @param <T> The type of information to be collected.
 */
@AllArgsConstructor
public class PostprocessingSchemeVisitor<T, U> extends SchemeBaseVisitor<U> implements SchemeVisitor<U> {
    protected final PostprocessableSchemeVisitor<T, U> delegate;

    @Override
    public U visit(final ParseTree tree) {
        tree.accept(delegate);
        return delegate.postprocess();
    }

}
