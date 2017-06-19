package net.sourceforge.jeval;

import net.sourceforge.jeval.function.FunctionException;

/**
 * This clas is an example of a custom variable resolver that can set onto an
 * instance of an evaluator.
 */
public class MockVariableResolver implements VariableResolver {

	/**
     * Returns a variable value for the specified variable name.
     *
     * @param variableName
     *            The name of the variable to return the variable value for.
     *
     * @return A variable value for the specified variable name. If the variable
     *         name can not be resolved, then null should be returned.
     *         
     * @throws Can throw a FunctionException if needed.
     */
	public String resolveVariable(String variableName) throws FunctionException {
		
		String returnValue = null;
		
		if (variableName.equals("MockVariable1")) {
			returnValue = "1";
		}
		else if (variableName.equals("MockVariable2")) {
			returnValue = "2";
		}
		else if (variableName.equals("MockVariable3")) {
			throw new FunctionException("Invalid mock variable name.");
		}
		
		return returnValue;
	}
}
