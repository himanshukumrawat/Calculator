/**
 *
 * JUnit tests for the Calculator class.
 * 
 * @author Himanshu Kumrawat
 */
package incubyte.test;

import incubyte.main.Calculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorTest {

    Calculator calculator = new Calculator();

    /**
     * Verifies that add() returns 0 when given an empty string.     *
     */
    @Test
    void testAdd() {
        int res = calculator.add("");
        assert res == 0;
    }

    /**
     * Verifies that add() returns the correct result when given a string with a
     * single number.
     */
    @Test
    void testAddSingle() {
        int res = calculator.add("1");
        assert res == 1;
    }

    /**
     * Verifies that add() returns the correct sum when given a string of multiple
     * numbers separated by commas.
     */
    @Test
    void testAddMultiple() {
        int res = calculator.add("1,2");
        assert res == 3;
    }

    /**
     * Verifies that add() returns the correct result when given a string with a
     * trailing comma.
     */
    @Test
    void testAddMultipleWithTrailingComma() {
        int res = calculator.add("1,");
        assert res == 1;
    }

    /**
     * Verifies that add() returns the correct sum when given a string of multiple
     * numbers separated by commas with a space after the comma.
     */
    @Test
    void testAddMultipleWithWhiteSpace() {
        int res = calculator.add("1, 2");
        assert res == 3;
    }

    /**
     * Verifies that add() returns the correct sum when given a string of 3
     * numbers separated by commas.
     */
    @Test
    void testAddMultipleWith3Numbers() {
        int res = calculator.add("1,2,3");
        assert res == 6;
    }

    /**
     * Verifies that add() returns the correct sum when given a string of 4
     * numbers separated by commas.
     */
    @Test
    void testAddMultipleWith4Numbers() {
        int res = calculator.add("1,2,3,4");
        assert res == 10;
    }

    /**
     * Verifies that add() throws an exception when given a string containing one
     * negative number and other positive numbers.
     */
    @Test
    void testAddOneNegative() {
        String input = "-1,2,3";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(input));
        assertEquals("negative numbers not allowed -1", exception.getMessage());
    }

    /**
     * Verifies that add() throws an exception when given a string containing
     * negative numbers.
     */
    @Test
    void testAddMultipleNegativeAndPositive() {
        String input = "-1,2,-3,4";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(input));
        assertEquals("negative numbers not allowed -1,-3", exception.getMessage());
    }

    /**
     * Verifies that add() returns the correct sum when given a string containing
     * multiple numbers separated by new lines.
     */
    @Test
    void testAddMultipleWithNewLine() {
        int res = calculator.add("1\n2\n3");
        assert res == 6;
    }

    /**
     * Verifies that add() returns the correct sum when given a string containing
     * multiple numbers separated by both commas and new lines.
     */
    @Test
    void testAddMultipleWithCommaAndNewLine() {
        int res = calculator.add("1,2\n3");
        assert res == 6;
    }

    /**
     * Verifies that add() supports custom delimiters and returns the correct sum.
     */
    @Test
    void testAddWithCustomDelimiter() {
        int res = calculator.add("//;\n1;2;3");
        assert res == 6;
    }

    /**
     * Verifies that add() handles edge case of custom delimiter with no numbers.
     */
    @Test
    void testAddWithCustomDelimiterNoNumbers() {
        int res = calculator.add("//;");
        assert res == 0;
    }

    /**
     * Verifies that add() handles edge case of custom delimiter with no numbers
     * and a trailing comma.
     */
    @Test
    void testAddWithCustomDelimiterNoNumbersWithTrailingComma() {
        int res = calculator.add("//;");
        assert res == 0;
    }

    /**
     * Verifies that add() handles edge case of custom delimiter with no numbers
     * and a trailing comma and a space after the comma.
     */
    @Test
    void testAddWithCustomDelimiterNoNumbersWithTrailingCommaAndSpace() {
        int res = calculator.add("//;");
        assert res == 0;
    }

    /**
     * Verifies that add() handles edge case of custom delimiter with no numbers
     * and a trailing comma and a space after the comma and a new line.
     */
    @Test
    void testAddWithCustomDelimiterNoNumbersWithTrailingCommaAndSpaceAndNewLine() {
        int res = calculator.add("//;\n");
        assert res == 0;
    }

    /**
     * Verifies that add() returns the correct sum when given a string containing
     * multiple numbers separated by commas with a space after the comma.
     */
    @Test
    void testAddMultipleWithCommasAndSpace() {
        int res = calculator.add("1, 2, 3");
        assert res == 6;
    }

    /**
     * Verifies that add() returns the correct sum when given a string containing
     * multiple numbers separated by commas with a space after the comma and a
     * new line.
     */
    @Test
    void testAddMultipleWithCommasAndSpaceAndNewLine() {
        int res = calculator.add("1, 2, 3\n4, 5, 6");
        assert res == 21;
    }

    /**
     * Verifies that add() throws an exception when given a string containing one
     * negative number and other positive numbers.
     */
    @Test
    void testAddOneNegativeWithCommasAndSpace() {
        String input = "-1, 2, 3";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(input));
        assertEquals("negative numbers not allowed -1", exception.getMessage());
    }

    /**
     * Verifies that add() throws an exception when given a string containing
     * negative numbers.
     */
    @Test
    void testAddMultipleNegativeAndPositiveWithCommasAndSpace() {
        String input = "-1, 2, -3, 4";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(input));
        assertEquals("negative numbers not allowed -1,-3", exception.getMessage());
    }

    /**
     * Verifies that add() returns the correct sum when given a string containing
     * multiple numbers separated by commas with a space after the comma and a
     * new line.
     */
    @Test
    void testAddMultipleWithCommasAndSpaceAndNewLineAndCustomDelimiter() {
        int res = calculator.add("//;\n1; 2; 3\n4; 5; 6\n8; 8; 0");
        assert res == 37;
    }

    /**
     * Verifies that add() throws an exception when given a string containing one
     * negative number and other positive numbers.
     */
    @Test
    void testAddOneNegativeWithCommasAndSpaceAndNewLineAndCustomDelimiter() {
        String input = "//;\n-1; 2; 3\n4; 5; 6";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(input));
        assertEquals("negative numbers not allowed -1", exception.getMessage());
    }

    /**
     * Verifies that add() throws an exception when given a string containing
     * negative numbers.
     */
    @Test
    void testAddMultipleNegativeAndPositiveWithCommasAndSpaceAndNewLineAndCustomDelimiter() {
        String input = "//;\n-1; 2; -3\n4; 5; 6";
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> calculator.add(input));
        assertEquals("negative numbers not allowed -1,-3", exception.getMessage());
    }

}