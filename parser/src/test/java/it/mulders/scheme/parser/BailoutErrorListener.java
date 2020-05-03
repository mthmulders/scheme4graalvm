package it.mulders.scheme.parser;

import lombok.Getter;
import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

final class BailoutErrorListener extends BaseErrorListener {
    private static final Logger logger = LoggerFactory.getLogger(BailoutErrorListener.class);

    @Getter
    private final List<String> capturedErrors = new ArrayList<>();

    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // line 1:1 token recognition error at: '*'
        var message = String.format("%d:%d %s", line, charPositionInLine, msg);
        capturedErrors.add(message);
        logger.error(msg);
        throw new IllegalArgumentException(message);
    }
}
