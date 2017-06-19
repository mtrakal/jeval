package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains a couple of samples for evaluating expression containing custom
 * functions. There are many more examples in the JUnit tests.
 */
public class CustomFunctionsSample {

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
			 * Add a custom function to our instance of the Evaluator class.
			 */
			evaluator.putFunction(new MockStringReverseFunction());

			/**
			 * This sample shows how to use the function.
			 */
			System.out.println(evaluator
					.evaluate("stringReverse('Hello World!')"));

			/**
			 * This sample shows how to use a function in a more complex
			 * expression.
			 */
			System.out.println(evaluator
					.evaluate("'*' + stringReverse('test') + '*'"));

			/**
			 * This sample clears the functions. This call will not included
			 * preloaded functions.
			 */
			evaluator.clearFunctions();

			/**
			 * This sample shows an invalid expression. The variables were just
			 * cleared, therefor the function "stringReverse" no longer exists.
			 */
			System.out.println("An exception is expected in the "
					+ "next evaluation.");
			System.out.println(evaluator
					.evaluate("stringReverse('Hello World!')"));
		} catch (EvaluationException ee) {
			System.out.println(ee);
		}
	}
}
