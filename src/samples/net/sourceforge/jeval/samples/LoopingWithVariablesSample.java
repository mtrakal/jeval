package net.sourceforge.jeval.samples;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sourceforge.jeval.EvaluationConstants;
import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

/**
 * Contains a sample for evaluating an expression containing variables running
 * within a loop. JEval doesn't have to reparse an expression if that expression
 * is equal to the previously executed expression, This saves be saved when
 * looping through data and evaluating an expression containing one or more
 * variables.
 * 
 * This sample also provides an example for how to filter data at runtime.
 */
public class LoopingWithVariablesSample {

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
		final Evaluator evaluator = new Evaluator();

		/*
		 * Create a table of randomly generated data with 50 rows and 3 columns
		 * of data. Let;s pretend this is data coming back from a relational
		 * database.
		 */
		final List table = new ArrayList();
		loadData(table, 50, 3);

		/*
		 * This is the expression we are going to evaluate. Not that we have
		 * three variables.
		 */
		final String expression = "#{a} >= 2 && #{b} >= 5 && #{c} >= 8";

		try {

			/*
			 * You can choose to parse ahead of time. If you do this, then you
			 * can call the parameterless version of the evaluate method. e.g.
			 * evaluator.evaluate(); This version of the evaluate method simply
			 * evaluates the previously parsed expression.
			 * 
			 * This statement is commented out here, so that we can illustrate
			 * that the first evaluation takes longer than subsequant
			 * evaluations.
			 */
			// evaluator.parse(expression);
			/*
			 * Loop through each row of data in the table.
			 */
			int numRows = table.size();
			for (int rowNum = 0; rowNum < numRows; rowNum++) {

				List row = (List) table.get(rowNum);
				Long a = (Long) row.get(0);
				Long b = (Long) row.get(1);
				Long c = (Long) row.get(2);

				/*
				 * Set the variables.
				 */
				evaluator.putVariable("a", a.toString());
				evaluator.putVariable("b", b.toString());
				evaluator.putVariable("c", c.toString());

				/*
				 * Evaluate the expression. The first evaluation should take
				 * longer than each evaluation that follows.
				 * 
				 * Note: I have seen some unexpected results when running this
				 * on different machines.  Sometimes the parsing during the 
				 * first evaluation is very fast and doesn't appear to take any 
				 * longer than subsequent evaluations.  If you are really 
				 * curious, then you can debug the source code to se how it 
				 * works.
				 */
				long startTime = new Date().getTime();
				String result = evaluator.evaluate(expression);
				long endTime = new Date().getTime();

				System.out.println("Execution time (row number = " + rowNum
						+ "):" + (endTime - startTime) + " ms");

				/*
				 * Verify the result to see if we found a row that we are
				 * looking for.
				 */
				if (result.equals(EvaluationConstants.BOOLEAN_STRING_TRUE)) {

					System.out.println("Row number " + rowNum
							+ " meets our criteria. A=" + a + " B=" + b + " C="
							+ c);
				}
			}

		} catch (EvaluationException ee) {
			System.out.println(ee);
		}
	}

	/**
	 * Load the data rows with randomly generated data that has a range from 0
	 * to 10. Let's pretend this is data coming back from a relational database.
	 * 
	 * @param table
	 *            The table to load.
	 * @param numRows
	 *            The number of rows to generate.
	 * @param numColumns
	 *            The number of columns to generate.
	 */
	private static void loadData(final List table, final int numRows,
			final int numColumns) {

		for (int rowNum = 0; rowNum < numRows; rowNum++) {

			final List row = new ArrayList();

			for (int columnNum = 0; columnNum < numColumns; columnNum++) {

				final Long dataValue = Long.valueOf(Math
						.round(Math.random() * 10));

				row.add(dataValue);
			}

			table.add(row);
		}
	}
}
