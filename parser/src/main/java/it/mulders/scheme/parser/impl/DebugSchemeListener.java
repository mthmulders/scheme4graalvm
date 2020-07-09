package it.mulders.scheme.parser.impl;

import it.mulders.scheme.parser.generated.SchemeListener;
import it.mulders.scheme.parser.generated.SchemeParser;
import lombok.extern.slf4j.Slf4j;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

@Slf4j
class DebugSchemeListener implements SchemeListener {
    private int indentCount = 0;

    @Override
    public void enterArgument(final SchemeParser.ArgumentContext ctx) {
        log.debug("{}enterArgument {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitArgument(final SchemeParser.ArgumentContext ctx) {
        indentCount--;
        log.debug("{}exitArgument {}", indent(), ctx.getText());
    }

    @Override
    public void enterArguments(final SchemeParser.ArgumentsContext ctx) {
        log.debug("{}enterArguments {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitArguments(final SchemeParser.ArgumentsContext ctx) {
        indentCount--;
        log.debug("{}exitArguments {}", indent(), ctx.getText());
    }

    @Override
    public void enterCompoundProcedure(final SchemeParser.CompoundProcedureContext ctx) {
        log.debug("{}enterCompoundProcedure {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitCompoundProcedure(final SchemeParser.CompoundProcedureContext ctx) {
        indentCount--;
        log.debug("{}exitCompoundProcedure {}", indent(), ctx.getText());
    }

    @Override
    public void enterName(final SchemeParser.NameContext ctx) {
        log.debug("{}enterName {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitName(final SchemeParser.NameContext ctx) {
        indentCount--;
        log.debug("{}exitName {}", indent(), ctx.getText());
    }

    @Override
    public void enterNumber(final SchemeParser.NumberContext ctx) {
        log.debug("{}enterNumber {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitNumber(final SchemeParser.NumberContext ctx) {
        indentCount--;
        log.debug("{}exitNumber {}", indent(), ctx.getText());
    }

    @Override
    public void enterSymbol(final SchemeParser.SymbolContext ctx) {
        log.debug("{}enterSymbol {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitSymbol(final SchemeParser.SymbolContext ctx) {
        indentCount--;
        log.debug("{}exitSymbol {}", indent(), ctx.getText());
    }

    @Override
    public void enterOperand(final SchemeParser.OperandContext ctx) {
        log.debug("{}enterOperand {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitOperand(final SchemeParser.OperandContext ctx) {
        indentCount--;
        log.debug("{}exitOperand {}", indent(), ctx.getText());
    }

    @Override
    public void enterPrimitiveExpression(final SchemeParser.PrimitiveExpressionContext ctx) {
        log.debug("{}enterPrimitiveExpression {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitPrimitiveExpression(final SchemeParser.PrimitiveExpressionContext ctx) {
        indentCount--;
        log.debug("{}exitPrimitiveExpression {}", indent(), ctx.getText());
    }

    @Override
    public void enterCombination(final SchemeParser.CombinationContext ctx) {
        log.debug("{}enterCompoundExpression {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitCombination(final SchemeParser.CombinationContext ctx) {
        indentCount--;
        log.debug("{}exitCompoundExpression {}", indent(), ctx.getText());
    }

    @Override
    public void enterProgram(final SchemeParser.ProgramContext ctx) {
        log.debug("{}enterProgram {}", indent(), ctx.getText());
        indentCount++;
    }

    @Override
    public void exitProgram(final SchemeParser.ProgramContext ctx) {
        indentCount--;
        log.debug("{}exitProgram {}", indent(), ctx.getText());
    }

    @Override
    public void visitTerminal(final TerminalNode node) {
        log.debug("{}visitTerminal {}", indent(), node.getText());
    }

    @Override
    public void visitErrorNode(final ErrorNode node) {
        log.debug("visitErrorNode {}", node.getText());
    }

    @Override
    public void enterEveryRule(final ParserRuleContext ctx) {
        // Intentionally left empty
    }

    @Override
    public void exitEveryRule(final ParserRuleContext ctx) {
        // Intentionally left empty
    }
    
    private String indent() {
        return "  ".repeat(Math.max(0, indentCount));
    }
}
