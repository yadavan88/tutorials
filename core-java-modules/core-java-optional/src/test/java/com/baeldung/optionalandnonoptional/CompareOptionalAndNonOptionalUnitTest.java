package com.baeldung.optionalandnonoptional;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class CompareOptionalAndNonOptionalUnitTest {

    @Test
    void whenCovertToOptionalBeforeComparison_thenGetExpectedResult() {
        Optional<String> opt = Optional.empty();
        assertFalse(opt.isPresent() && opt.equals(Optional.ofNullable("a b c")));
        assertFalse(opt.isPresent() && opt.equals(Optional.ofNullable(null)));

        opt = Optional.of("x y z");
        assertFalse(opt.isPresent() && opt.equals(Optional.ofNullable("a b c")));
        assertFalse(opt.isPresent() && opt.equals(Optional.ofNullable(null)));

        opt = Optional.of("a b c");
        assertTrue(opt.isPresent() && opt.equals(Optional.ofNullable("a b c")));
    }

    @Test
    void whenOptionalGetBeforeComparison_thenGetExpectedResult() {
        Optional<String> opt = Optional.empty();
        assertFalse(opt.isPresent() && opt.get().equals("a b c"));
        assertFalse(opt.isPresent() && opt.get().equals(null));

        opt = Optional.of("x y z");
        assertFalse(opt.isPresent() && opt.get().equals("a b c"));
        assertFalse(opt.isPresent() && opt.get().equals(null));

        opt = Optional.of("a b c");
        assertTrue(opt.isPresent() && opt.get().equals("a b c"));
    }

    @Test
    void whenUsingOptionalMap_thenGetExpectedResult() {
        Optional<String> opt = Optional.empty();
        assertFalse(opt.map(c -> c.equals("a b c")).orElse(false));
        assertFalse(opt.map(c -> c.equals(null)).orElse(false));

        opt = Optional.of("x y z");
        assertFalse(opt.map(c -> c.equals("a b c")).orElse(false));
        assertFalse(opt.map(c -> c.equals(null)).orElse(false));

        opt = Optional.of("a b c");
        assertTrue(opt.map(c -> c.equals("a b c")).orElse(false));
    }
}