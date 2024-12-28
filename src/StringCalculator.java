public class StringCalculator {

	public int Add(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		int sum = 0;
		String delimeter = ",|\\n";

		if (numbers.startsWith("//")) {
			int delimiterEnd = numbers.indexOf("\n");
			delimeter = numbers.substring(2, delimiterEnd);
			numbers = numbers.substring(delimiterEnd + 1);
		}

		if (numbers.contains(",\n") || numbers.contains("\n,")) {
			throw new IllegalArgumentException(
					"Invalid input format: mixed commas and newlines without proper separation");
		}

		String[] tokens = numbers.split(delimeter);
		for (String token : tokens) {
			if (!token.isEmpty()) {
				int num = Integer.parseInt(token);
				sum += num;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		StringCalculator calculator = new StringCalculator();
		System.out.println(calculator.Add(""));
		System.out.println(calculator.Add("1"));
		System.out.println(calculator.Add("1,2"));
		System.out.println(calculator.Add("1\n2,3"));
//		System.out.println(calculator.Add("1,\n2"));
		System.out.println(calculator.Add("//;\n1;2"));

	}

}
