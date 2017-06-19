package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains a couple of samples for evaluating Boolean operations. There are
 * many more examples in the JUnit tests.
 */
public class BooleanOperationsSample {

	/**
	 * Run the sample code. No arguments are necessary.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		/*
		 * This sample shows the basic usage of the JEval Evaluator class.
		 * Calling the default contructor will set he quoteCharater to single
		 * quotes This constructor will also load all math variables, math
		 * functions and string variables.
		 */
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * This sample shows a Boolean expression with a FALSE result.
			 * 
			 * Note: A Boolean FALSE value is represented by "0.0".
			 */
			System.out.println(evaluator.evaluate("3 < 3"));

			/*
			 * This sample shows a Boolean expression with a TRUE result.
			 * 
			 * Note: A Boolean TRUE value is represented by "1.0".
			 */
			System.out.println(evaluator.evaluate("3 < 4"));

			/**
			 * This sample shows a more complex expression involving
			 * parentheses, the OR operator and the AND operator. The result
			 * will be fALSE.
			 */
			System.out.println(evaluator
					.evaluate("((2 < 3) || (1 == 1)) && (3 < 3)"));

			/**
			 * This sample shows an invalid expression. There is no closing
			 * parentheses.
			 */
			System.out.println("An exception is expected in the "
					+ "next evaluation.");
			System.out.println(evaluator.evaluate("(2 < 3) && (1 = 1"));
		} catch (EvaluationException ee) {
			System.out.println(ee);
		}
	}
}
