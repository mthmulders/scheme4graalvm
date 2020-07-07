package it.mulders.scheme.language;

import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;

public class SchemeFileDetector extends FileTypeDetector {
    @Override
    public String probeContentType(final Path path) {
        // Filename extensions from https://en.wikipedia.org/wiki/Scheme_(programming_language)
        if (path.toString().endsWith(".scm") || path.toString().endsWith(".ss")) {
            return SchemeLanguage.MIME_TYPE;
        }
        return null;
    }
}
