/*
 * Copyright 2002-2007 Robert Breidecker.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sourceforge.jeval.samples;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;
import net.sourceforge.jeval.function.Function;
import net.sourceforge.jeval.function.FunctionConstants;
import net.sourceforge.jeval.function.FunctionException;
import net.sourceforge.jeval.function.FunctionHelper;
import net.sourceforge.jeval.function.FunctionResult;

/**
 * This class is an example of a custom function that executes within Evaluator.
 * The function returns the source string in reverse order.
 */
public class MockStringReverseFunction implements Function {
	/**
	 * Returns the name of the function - "stringReverse".
	 * 
	 * @return The name of this function class.
	 */
	public String getName() {
		return "stringReverse";
	}

	/**
	 * Executes the function for the specified argument. This method is called
	 * internally by Evaluator.
	 * 
	 * @param evaluator
	 *            An instance of Evaluator.
	 * @param arguments
	 *            A string argument that will be converted into a string that is
	 *            in reverse order. The string argument(s) HAS to be enclosed in
	 *            quotes. White space that is not enclosed within quotes will be
	 *            trimmed. Quote characters in the first and last positions of
	 *            any string argument (after being trimmed) will be removed
	 *            also. The quote characters used must be the same as the quote
	 *            characters used by the current instance of Evaluator. If there
	 *            are multiple arguments, they must be separated by a comma
	 *            (",").
	 * 
	 * @return The source string in reverse order.
	 * 
	 * @exception FunctionException
	 *                Thrown if the argument(s) are not valid for this function.
	 */
	public FunctionResult execute(Evaluator evaluator, String arguments)
			throws FunctionException {
		String result = "";

		try {
			String stringValue = new Evaluator().evaluate(arguments, true,
					false);

			String argumentOne = FunctionHelper.trimAndRemoveQuoteChars(
					stringValue, evaluator.getQuoteCharacter());

			int size = argumentOne.length();
			for (int index = size - 1; index >= 0; index--) {
				result = result + argumentOne.charAt(index);
			}
		} catch (FunctionException fe) {
			throw new FunctionException(fe.getMessage(), fe);
		} catch (EvaluationException ee) {
			throw new FunctionException("Invalid expression in arguments.", ee);
		} catch (Exception e) {
			throw new FunctionException("One string argument is required.", e);
		}

		return new FunctionResult(result, 
				FunctionConstants.FUNCTION_RESULT_TYPE_STRING);
	}
}