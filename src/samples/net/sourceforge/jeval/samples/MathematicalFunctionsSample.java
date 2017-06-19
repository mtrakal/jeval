package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains a couple of samples for evaluating expression containing
 * mathematical functions. There are many more examples in the JUnit tests.
 */
public class MathematicalFunctionsSample {

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

			/**
			 * This sample shows a basic math function.
			 */
			System.out.println(evaluator.evaluate("abs(-1)"));

			/**
			 * This sample shows a math function used in a more complex
			 * mathematical expression.
			 */
			System.out.println(evaluator.evaluate("1 + abs(-1)"));

			/**
			 * This sample shows another math function.
			 */
			System.out.println(evaluator.evaluate("acos(0.1)"));

			/**
			 * This sample shows an invalid expression. The "round" function
			 * requires an argument.
			 */
			System.out.println("An exception is expected in the "
					+ "next evaluation.");
			System.out.println(evaluator.evaluate("round()"));
		} catch (EvaluationException ee) {
			System.out.println(ee);
		}
	}
}
