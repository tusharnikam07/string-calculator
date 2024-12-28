public class StringCalculator {

	public int Add(String numbers) {
		if (numbers == null || numbers.isEmpty()) {
			return 0;
		}
		int sum = 0;
		String[] tokens = numbers.split(",");
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
		System.out.println(calculator.Add("1,2,3,4,5,6"));
		System.out.println(calculator.Add("1,2,3,4,5,6,7,8,9,10,11,12,13"));

	}

}
