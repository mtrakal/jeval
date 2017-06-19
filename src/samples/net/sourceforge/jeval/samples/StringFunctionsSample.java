package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains a couple of samples for evaluating expression containing string
 * functions. There are many more examples in the JUnit tests.
 */
public class StringFunctionsSample {

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
			 * This sample shows a basic string function.
			 */
			System.out.println(evaluator
					.evaluate("toLowerCase('Hello World!')"));

			/**
			 * This sample shows a string function used in a more complex string
			 * expression.
			 */
			System.out.println(evaluator.evaluate("trim('abc ') + 'd'"));

			/**
			 * This sample shows another math function. Note that the return
			 * value is numeric.
			 */
			System.out.println(evaluator
					.evaluate("lastIndexOf('abcabcabc', 'abc', 8)"));

			/**
			 * This samples whows the "eval" function". The 'eval' function
			 * calls the Evaluator.evaluate() method using the expression in
			 * parentheses.
			 */
			System.out.println(evaluator.evaluate("eval(1 + 2)"));

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
