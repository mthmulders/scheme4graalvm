package it.mulders.scheme.parser.ast;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class OperandTest implements WithAssertions {
    @Test
    void forSymbol_shouldFindExistingSymbol() {
        assertThat(Operand.forSymbol("+")).isEqualTo(Operand.ADD);
    }

    @Test
    void forSymbol_shouldThrowExceptionForNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> Operand.forSymbol(null)
        );
    }

    @Test
    void forSymbol_shouldThrowExceptionForUnknownSymbol() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(
                () -> Operand.forSymbol("?")
        );
    }
}