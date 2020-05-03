package it.mulders.scheme.parser.visitors;

import it.mulders.scheme.parser.generated.SchemeVisitor;

public interface PostprocessableSchemeVisitor<T, U> extends SchemeVisitor<T> {
    U postprocess();
}
