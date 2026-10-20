package com.silas.student;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class StudentValidatorTest {

    @Test
    void acceptsNormalAge() {
        boolean actual = StudentValidator.isValidAge(20);
        Assertions.assertTrue(actual);
    }

    @Test
    void acceptsMinimumAge() {
        boolean actual = StudentValidator.isValidAge(1);
        Assertions.assertTrue(actual);
    }

    @Test
    void acceptsMaximumAge() {
        boolean actual = StudentValidator.isValidAge(120);
        Assertions.assertTrue(actual);
    }

    @Test
    void rejectsAgeBelowMinimum() {
        boolean actual = StudentValidator.isValidAge(0);
        Assertions.assertFalse(actual);
    }

    @Test
    void rejectsAgeAboveMaximum() {
        boolean actual = StudentValidator.isValidAge(121);
        Assertions.assertFalse(actual);
    }

    @Test
    void parsesNormalAge() {
        int actual = StudentValidator.parseAge("20");
        Assertions.assertEquals(20,actual);
    }

    @Test
    void parsesAgeWithSpaces() {
        Assertions.assertEquals(20,StudentValidator.parseAge(" 20 "));
    }

    @Test
    void rejectsNonNumericAge() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> StudentValidator.parseAge("abc")
        );
    }

    @Test
    void rejectsBlankAge() {
        Assertions.assertThrows(
                NumberFormatException.class,
                () -> StudentValidator.parseAge(" ")
        );
    }

    @Test
    void rejectsNullAge() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> StudentValidator.parseAge(null)
        );
    }

    @Test
    void rejectsParsedAgeBelowMinimum() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> StudentValidator.parseAge("0")
        );
    }

    @Test
    void rejectsParsedAgeAboveMaximum() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> StudentValidator.parseAge("121")
        );
    }


}
