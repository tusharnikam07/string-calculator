import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}

		int sum = 0;
		String delimiter = ",|\\n";

		// Handle custom delimiter
		if (numbers.startsWith("//")) {
			int delimiterEnd = numbers.indexOf("\n");
			String customDelimiter = numbers.substring(2, delimiterEnd);

			if (customDelimiter.startsWith("[") && customDelimiter.endsWith("]")) {
				customDelimiter = customDelimiter.substring(1, customDelimiter.length() - 1);
				String[] delimiters = customDelimiter.split("\\]\\[");
				delimiter = String.join("|", delimiters);
			} else {
				delimiter = customDelimiter;
			}

			numbers = numbers.substring(delimiterEnd + 1);
		}

		// Validate input for invalid format
		if (numbers.contains(",\n") || numbers.contains("\n,")) {
			throw new IllegalArgumentException(
					"Invalid input format: mixed commas and newlines without proper separation");
		}

		// Split numbers and calculate sum
		String[] tokens = numbers.split(delimiter);
		List<Integer> negatives = new ArrayList<>();

		for (String token : tokens) {
			if (!token.isEmpty()) {
				int num = Integer.parseInt(token);

				if (num < 0) {
					negatives.add(num);
				} else if (num <= 1000) {
					sum += num;
				}
			}
		}

		// Handle negatives
		if (!negatives.isEmpty()) {
			throw new IllegalArgumentException("Negatives not allowed: " + negatives);
		}

		return sum;
	}

	public static void main(String[] args) {
		StringCalculator calculator = new StringCalculator();
		System.out.println(calculator.add(""));
		System.out.println(calculator.add("1"));
		System.out.println(calculator.add("1,2"));
		System.out.println(calculator.add("1\n2,3"));
//		System.out.println(calculator.add("1,\n2"));
		System.out.println(calculator.add("//;\n1;2"));
//		System.out.println(calculator.add("//;\n-11;-2;-3"));
		System.out.println(calculator.add("//;\n1001;2;3"));
		System.out.println(calculator.add("//[@@@]\n1@@@2@@@3"));
		System.out.println(calculator.add("//[@][%]\n1@2%3"));
		System.out.println(calculator.add("//[@@@][%%%]\n1@@@2%%%3@@@2%%%3"));

	}

}
