package it.mulders.scheme.language;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.oracle.truffle.api.TruffleLanguage;

public final class SchemeContext {
    final TruffleLanguage.Env env;
    final SchemeLanguage language;
    final BufferedReader input;
    final PrintWriter output;

    public SchemeContext(final SchemeLanguage language, final TruffleLanguage.Env env) {
        this.env = env;
        this.language = language;
        this.input = new BufferedReader(new InputStreamReader(env.in()));
        this.output = new PrintWriter(env.out(), true);
    }
}
