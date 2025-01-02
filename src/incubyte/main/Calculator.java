package incubyte.main;

public class Calculator {
    /**
     * Takes a string of numbers separated by commas or new lines and returns their sum.
     * If the string is empty, returns 0.
     * @param numbers a string of numbers separated by commas or new lines
     * @return the sum of the numbers
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numArray = numbers.split("[,\n]");
        int sum = 0;
        for (String num : numArray) {
            sum += Integer.parseInt(num.trim());
        }
        return sum;
    }
}