package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains a couple of samples for evaluating mathematical operations. There
 * are many more examples in the JUnit tests.
 */
public class MathematicalOperationsSample {

	/**
	 * Run the sample code. No arguments are necessary.
	 * 
	 * @param args
	 */
	public static void main(String args[]) {

		/*
		 * This sample shows the basic usage of the JEval Evaluator class.
		 * Calling the default contructor will set he quoteCharater to single
		 * quote. This constructor will also load all math variables, math
		 * functions and string variables.
		 */
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * This sample shows basic addition.
			 * 
			 * Note: The output will contain at least one decimal place, since
			 * the results of math operations are treated like doubles.
			 */
			System.out.println(evaluator.evaluate("4 + 1"));

			/**
			 * This sample shows basic division
			 */
			System.out.println(evaluator.evaluate("1 / 3"));

			/**
			 * This sample shows a more complex expression involving
			 * parentheses.
			 */
			System.out.println(evaluator.evaluate("4 + (3 + 1) + (3 + 1) + 1"));

			/**
			 * This sample shows an invalid expression. There is no operand to
			 * the right of the plus addition operator.
			 */
			System.out.println("An exception is expected in the "
					+ "next evaluation.");
			System.out.println(evaluator.evaluate("4 + "));
		} catch (EvaluationException ee) {
			System.out.println(ee);
		}
	}
}
