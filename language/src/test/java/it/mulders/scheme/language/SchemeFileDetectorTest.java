package it.mulders.scheme.language;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;

class SchemeFileDetectorTest implements WithAssertions {
    final SchemeFileDetector detector = new SchemeFileDetector();

    @Test
    void file_ending_with_scm_should_be_correct_mime_type() {
        assertThat(detector.probeContentType(Paths.get("whatever.scm"))).isEqualTo(SchemeLanguage.MIME_TYPE);
    }

    @Test
    void file_ending_with_ss_should_be_correct_mime_type() {
        assertThat(detector.probeContentType(Paths.get("whatever.ss"))).isEqualTo(SchemeLanguage.MIME_TYPE);
    }

    @Test
    void file_ending_with_something_else_should_not_be_correct_mime_type() {
        assertThat(detector.probeContentType(Paths.get("whatever.txt"))).isNotEqualTo(SchemeLanguage.MIME_TYPE);
    }
}