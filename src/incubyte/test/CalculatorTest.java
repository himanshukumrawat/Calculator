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
}