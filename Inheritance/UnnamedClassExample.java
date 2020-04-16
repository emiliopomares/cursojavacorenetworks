abstract class BinaryMathOperation {
	public abstract double performOperation(double x, double y);
}

class Addition extends BinaryMathOperation {
	@Override
	public double performOperation(double x, double y) {
		return x + y;
	}
}

public class UnnamedClassExample {

	public double executeBinaryMathOperation(BinaryMathOperation op, double param1, double param2) {
		return op.performOperation(param1, param2);
	}
	
	public static void main(String[] args) {
	
		// since executeBinaryMathOperation is not static, we need to create a class instance	
		UnnamedClassExample example = new UnnamedClassExample();

		Addition addition = new Addition();

		// perform addition
		System.out.println(example.executeBinaryMathOperation(addition, 4.0, 6.0));

		// perform multiplication (via unnamed class)
		System.out.println(example.executeBinaryMathOperation(new BinaryMathOperation() {
				@Override
				public double performOperation(double x, double y) {
					return x * y;
				}
			}, 4.0, 6.0));

	}
}
