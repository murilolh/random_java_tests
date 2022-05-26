package shifteddiffapp.app;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShiftedDiffTest {
    @Test
    @DisplayName("should handle basic cases")
    public void shouldHandleBasicCases() {
        assertEquals(2, ShiftedDiff.shiftedDiff("coffee", "eecoff"));
        assertEquals(4, ShiftedDiff.shiftedDiff("eecoff", "coffee"));
        assertEquals(-1, ShiftedDiff.shiftedDiff("Moose", "moose"));
        assertEquals(2, ShiftedDiff.shiftedDiff("isn't", "'tisn"));
        assertEquals(0, ShiftedDiff.shiftedDiff("Esham", "Esham"));
        assertEquals(-1, ShiftedDiff.shiftedDiff("dog", "god"));
    }

    @Test
    @DisplayName("should return -1 if the strings are null")
    public void shouldReturnFalseIfTheStringsAreNull() {
        assertEquals(-1, ShiftedDiff.shiftedDiff(null, null));
        assertEquals(-1, ShiftedDiff.shiftedDiff(null, "notnull"));
        assertEquals(-1, ShiftedDiff.shiftedDiff("notnull", null));
    }

    @Test
    @DisplayName("should return -1 if the strings are empty")
    public void shouldReturnFalseIfTheStringsAreEmpty() {
        assertEquals(-1, ShiftedDiff.shiftedDiff("", ""));
        assertEquals(-1, ShiftedDiff.shiftedDiff("", "notEmpty"));
        assertEquals(-1, ShiftedDiff.shiftedDiff("notEmpty", ""));
    }

    @Test
    @DisplayName("should return -1 if the length of strings are different")
    public void shouldReturnFalseIfTheLengthsAreDifferent() {
        assertEquals(-1, ShiftedDiff.shiftedDiff("123456", "12345"));
        assertEquals(-1, ShiftedDiff.shiftedDiff("12345", "123456"));
    }

    @Test
    @DisplayName("should return 0 if the strings are equal")
    public void shouldReturnZeroIfTheStringsAreEqual() {
        assertEquals(0, ShiftedDiff.shiftedDiff("a", "a"));
        assertEquals(0, ShiftedDiff.shiftedDiff("ab", "ab"));
        assertEquals(0, ShiftedDiff.shiftedDiff("equal", "equal"));
    }

    @Test
    @DisplayName("should handle more cases")
    public void shouldHandleMoreCases() {
        assertEquals(2, ShiftedDiff.shiftedDiff("abba", "baab"));
        assertEquals(6, ShiftedDiff.shiftedDiff("unconstitutional", "tionalunconstitu"));
        assertEquals(15, ShiftedDiff.shiftedDiff("unconstitutional", "nconstitutionalu"));
        assertEquals(17, ShiftedDiff.shiftedDiff("Long phrase to be tested", "rase to be testedLong ph"));
        assertEquals(-1, ShiftedDiff.shiftedDiff("long phrase to be tested", "rase to be testedLong ph"));
    }
}
