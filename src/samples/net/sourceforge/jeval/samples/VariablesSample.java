package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains a couple of samples for evaluating expression containing variables.
 * There are many more examples in the JUnit tests.
 */
public class VariablesSample {

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
			 * Add the variables to our instance of the Evaluator class.
			 */
			evaluator.putVariable("a", "'Hello'");
			evaluator.putVariable("b", "'World'");

			/**
			 * This sample simply outputs the variables.
			 */
			System.out.println(evaluator.evaluate("#{a}"));
			System.out.println(evaluator.evaluate("#{b}"));

			/**
			 * This sample outputs a preloaded math varibles.
			 */
			System.out.println(evaluator.evaluate("#{PI}"));

			/**
			 * This sample adds the variables together to form a sentence.
			 */
			System.out.println(evaluator.evaluate("#{a} + ' ' + #{b} + '!'"));

			/**
			 * This sample clears the variables. This call will not clear
			 * preloaded variables.
			 */
			evaluator.clearVariables();
			/**
			 * This sample shows the use of a custom variable resolver.
			 */
			evaluator.setVariableResolver(new MockVariableResolver());
			System.out.println(evaluator
					.evaluate("#{MockVariable1} + #{MockVariable2}"));
			
			/**
			 * This sample shows an invalid expression. The variables were just
			 * cleared, therefor the variable "a" no longer exists.
			 */
			System.out.println("An exception is expected in the "
					+ "next evaluation.");
			System.out.println(evaluator.evaluate("#{a}"));
		} catch (EvaluationException ee) {
			System.out.println(ee);
		}
	}
}
