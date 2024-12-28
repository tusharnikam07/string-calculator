public class StringCalculator {

	public int Add(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		String[] tokens = numbers.split(",");

		int firstNum = Integer.parseInt(tokens[0].trim());
		int secondNum = Integer.parseInt(tokens[1].trim());

		return firstNum + secondNum;
	}

	public static void main(String[] args) {
		StringCalculator calculator = new StringCalculator();
		System.out.println(calculator.Add(""));
		System.out.println(calculator.Add("1,2"));
	}

}
