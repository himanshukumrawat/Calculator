package incubyte.main;

public class Calculator {
    /**
     * Takes a string of numbers separated by commas or new lines and returns their sum.
     * If the string is empty, returns 0.
     * If the string contains any negative numbers, throws an exception with a message
     * like "negative numbers not allowed <negative_number>".
     * If there are multiple negative numbers, show all of them in the exception message,
     * separated by commas.
     *
     * @param numbers a string of numbers separated by commas or new lines
     * @return the sum of the numbers
     */
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0; // empty string
        }

        String[] numArray;
        if (numbers.startsWith("//")) {
            String[] lines = numbers.split("\n", 2);
            if (lines.length < 2) {
                return 0; // custom delimiter but no numbers
            }
            String delimiter = lines[0].substring(2);
            numArray = lines[1].split(delimiter + "|[\n]"); // split on custom delimiter and new line
        } else {
            numArray = numbers.split("[,\n]"); // split on comma and new line
        }

        StringBuilder sb = new StringBuilder();
        int sum = 0;
        for (String num : numArray) {
            num = num.trim();
            if (!num.isEmpty()) {
                int number = Integer.parseInt(num);
                if (number < 0) {
                    sb.append(number).append(","); // collect negative numbers
                } else {
                    sum += number; // add positive numbers
                }
            }
        }

        if (!sb.isEmpty()) {
            // Convert StringBuilder to String and remove trailing comma
            String message = sb.substring(0, sb.length() - 1);
            // Throw exception with a message containing all negative numbers
            throw new IllegalArgumentException("negative numbers not allowed " + message);
        }

        return sum;
    }
}