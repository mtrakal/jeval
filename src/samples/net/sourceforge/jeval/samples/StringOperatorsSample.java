package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains a couple of samples for evaluating string operations. There are many
 * more examples in the JUnit tests.
 */
public class StringOperatorsSample {

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
			 * This sample shows basic string addition.
			 * 
			 * Note: That we are using a single quote as our quote character.
			 */
			System.out.println(evaluator.evaluate("'A' + 'C'"));

			/**
			 * This sample shows basic string comparison, which is a Boolean
			 * operation. The output will be TRUE ("1.0").
			 */
			System.out.println(evaluator.evaluate("'A' < 'C'"));

			/**
			 * This sample shows a string expression using a double quote as our
			 * quote character. We must using a string delimitor in order to
			 * specify the double quote in the expression.
			 */
			evaluator.setQuoteCharacter(EvaluationConstants.DOUBLE_QUOTE);
			System.out.println(evaluator.evaluate("\"AB\" + \"C\""));

			/**
			 * This sample shows an invalid expression. There are no quotes.
			 */
			System.out.println("An exception is expected in the "
					+ "next evaluation.");
			System.out.println(evaluator.evaluate("a + b"));
		} catch (EvaluationException ee) {
			System.out.println(ee);
		}
	}
}
