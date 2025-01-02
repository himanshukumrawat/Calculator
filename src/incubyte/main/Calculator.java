package incubyte.main;

public class Calculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }

        String[] numArray = numbers.split(",");
        if (numArray.length > 2) {
            throw new IllegalArgumentException("Only 2 numbers are supported");
        }

        int sum = 0;
        for (String num : numArray) {
            sum += Integer.parseInt(num.trim());
        }
        return sum;
    }
}