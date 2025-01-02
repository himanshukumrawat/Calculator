/**
 * JUnit tests for the Calculator class.
 * 
 * @author Himanshu Kumrawat
 */
package incubyte.test;

import incubyte.main.Calculator;
import org.junit.jupiter.api.Test;

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

    @Test
    void testAddSingle() {
        int res = calculator.add("1");
        assert res == 1;
    }

    @Test
    void testAddMultiple() {
        int res = calculator.add("1,2");
        assert res == 3;
    }

    @Test
    void testAddMultipleWithTrailingComma() {
        int res = calculator.add("1,");
        assert res == 1;
    }

    @Test
    void testAddMultipleWithWhiteSpace() {
        int res = calculator.add("1, 2");
        assert res == 3;
    }

    @Test
    void testAddMultipleWith3Numbers() {
        int res = calculator.add("1,2,3");
        assert res == 6;
    }

    @Test
    void testAddMultipleWith4Numbers() {
        int res = calculator.add("1,2,3,4");
        assert res == 10;
    }

    @Test
    void testAddOneNegative() {
        int res = calculator.add("-1,2,3");
        assert res == 4;
    }

    @Test
    void testAddMultipleNegative() {
        int res = calculator.add("-1,-2,-3");
        assert res == -6;
    }

    @Test
    void testAddMultipleNegativeAndPositive() {
        int res = calculator.add("-1,2,-3,4");
        assert res == 2;
    }
    
}