package it.mulders.scheme.language;

import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.instrumentation.ProvidedTags;
import com.oracle.truffle.api.instrumentation.StandardTags;

@ProvidedTags({
        StandardTags.CallTag.class,
        StandardTags.RootTag.class,
        StandardTags.RootBodyTag.class,
        StandardTags.StatementTag.class,

})
@TruffleLanguage.Registration(
        id = SchemeLanguage.ID,
        name = "Scheme",
        defaultMimeType = SchemeLanguage.MIME_TYPE,
        characterMimeTypes = SchemeLanguage.MIME_TYPE
)
public final class SchemeLanguage extends TruffleLanguage<SchemeContext> {
    public static final String ID = "scheme";
    public static final String MIME_TYPE = "text/x-script.scheme";

    /**
     * {@inheritDoc}
     */
    @Override
    protected SchemeContext createContext(final Env env) {
        return new SchemeContext(this, env);
    }
}
