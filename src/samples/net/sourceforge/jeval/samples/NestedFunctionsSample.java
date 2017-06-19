package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains a couple of samples for evaluating expression containing string
 * functions. There are many more examples in the JUnit tests.
 */
public class NestedFunctionsSample {

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
			 * This sample shows nested string functions.
			 */
			System.out.println(evaluator
					.evaluate("toUpperCase(trim( trim(' a b c ') ))"));

			/**
			 * This sample shows nested math functions.
			 */
			System.out.println(evaluator.evaluate("atan2(atan2(1, 1), 1)"));

			/**
			 * Create a new evaluator and turn off nested function support.
			 */
			evaluator = new Evaluator(EvaluationConstants.SINGLE_QUOTE, true,
					true, true, false);

			/**
			 * This expression is now invalid, because nested function support
			 * has been turned off.
			 */
			System.out.println("An exception is expected in the "
					+ "next evaluation.");
			System.out.println(evaluator
					.evaluate("toUpperCase(trim( trim(' a b c ') ))"));
		} catch (EvaluationException ee) {
			System.out.println(ee);
		}
	}
}
