module it.mulders.scheme4graalvm.language {
    requires org.graalvm.truffle;

    uses com.oracle.truffle.api.TruffleLanguage;
    uses com.oracle.truffle.api.instrumentation.ProvidedTags;
    uses com.oracle.truffle.api.instrumentation.StandardTags;
    uses java.nio.file.spi.FileTypeDetector;
}