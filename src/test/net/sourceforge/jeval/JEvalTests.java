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

package net.sourceforge.jeval;

import junit.framework.TestCase;

/**
 * Contains suite of expression tests for validating JEval.
 * 
 */
public class JEvalTests extends TestCase {

	/**
	 * Standard constructor.
	 * 
	 * @param arg0
	 */
	public JEvalTests(String arg0) {
		super(arg0);
	}

	/**
	 * Test expressions containing mathematical operations.
	 */
	public void testEvaluateMathematicalOperations() {
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * These tests involve valid expressions.
			 */
			assertEquals("4.0", evaluator.evaluate("4"));
			assertEquals("-4.0", evaluator.evaluate("-4"));
			assertEquals("5.0", evaluator.evaluate("4 + 1"));
			assertEquals("3.0", evaluator.evaluate("4 + -1"));
			assertEquals("0.2", evaluator.evaluate("0.2"));
			assertEquals("1.6", evaluator.evaluate("1.2 + 0.4"));
			assertEquals("1.6", evaluator.evaluate("1.2 + .4"));
			assertEquals("0.6000000000000001", evaluator.evaluate("0.2 + 0.4"));
			assertEquals("-0.2", evaluator.evaluate("0.2 - 0.4"));
			assertEquals("6.0", evaluator.evaluate("2 - -4"));
			assertEquals("-3.0", evaluator.evaluate("-4 + 1"));
			assertEquals("-5.0", evaluator.evaluate("-4 + -1"));
			assertEquals("3.0", evaluator.evaluate("4 - 1"));
			assertEquals("-3.0", evaluator.evaluate("1 - 4"));
			assertEquals("12.0", evaluator.evaluate("4 * 3"));
			assertEquals("-12.0", evaluator.evaluate("4 * -3"));
			assertEquals("12.0", evaluator.evaluate("-4 * -3"));
			assertEquals("2.0", evaluator.evaluate("4 / 2"));
			assertEquals("0.5", evaluator.evaluate("2 / 4"));
			assertEquals("-2.0", evaluator.evaluate("4 / -2"));
			assertEquals("1.0", evaluator.evaluate("7 % 2"));
			assertEquals("1.0", evaluator.evaluate("7 % -2"));
			assertEquals("14.0", evaluator.evaluate("4 * 3 + 2"));
			assertEquals("10.0", evaluator.evaluate("4 + 3 * 2"));
			assertEquals("16.0", evaluator.evaluate("4 / 2 * 8"));
			assertEquals("4.0", evaluator.evaluate("(4)"));
			assertEquals("-4.0", evaluator.evaluate("(-4)"));
			assertEquals("-4.0", evaluator.evaluate("-(4)"));
			assertEquals("4.0", evaluator.evaluate("-(-4)"));
			assertEquals("4.0", evaluator.evaluate("-(-(4))"));
			assertEquals("7.0", evaluator.evaluate("(4 + 3)"));
			assertEquals("-6.0", evaluator.evaluate("-(3 + 3)"));
			assertEquals("4.0", evaluator.evaluate("(3) + 1"));
			assertEquals("2.0", evaluator.evaluate("(3) - 1"));
			assertEquals("14.0", evaluator.evaluate("(4 + 3) * 2"));
			assertEquals("13.0", evaluator
					.evaluate("4 + (3 + 1) + (3 + 1) + 1"));
			assertEquals("14.0", evaluator.evaluate("((4 + 3) * 2)"));
			assertEquals("42.0", evaluator.evaluate("((4 + 3) * 2) * 3"));
			assertEquals("-42.0", evaluator.evaluate("((4 + 3) * -2) * 3"));
			assertEquals("-2.0", evaluator.evaluate("((4 + 3) * 2) / -7"));
			assertEquals("16.0", evaluator.evaluate("(4 / 2) * 8"));
			assertEquals("0.25", evaluator.evaluate("4 / (2 * 8)"));
			assertEquals("1.0", evaluator.evaluate("(4 * 2) / 8"));
			assertEquals("1.0", evaluator.evaluate("4 * (2 / 8)"));
			assertEquals("16.0", evaluator.evaluate("(4 / (2) * 8)"));
			assertEquals("-4.0", evaluator.evaluate("-(3 + -(3 - 4))"));

			/*
			 * These tests involve invalid expressions.
			 */
			assertException(evaluator, "-");
			assertException(evaluator, "4 + ");
			assertException(evaluator, "4 - ");
			assertException(evaluator, "4 + -");
			assertException(evaluator, "--4");
			assertException(evaluator, "4 * / 3");
			assertException(evaluator, "* 3");
			assertException(evaluator, "((4");
			assertException(evaluator, "4 (");
			assertException(evaluator, "(4))");
			assertException(evaluator, "((4 + 3)) * 2)");
			assertException(evaluator, "4 ()");
			assertException(evaluator, "4 (+) 3");
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test expressions containing Boolean operations.
	 */
	public void testEvaluateBooleanOperations() {
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * These tests involve valid expressions.
			 */
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("3 < 3"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("3 < 4"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("4 < 3"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("3 > 3"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("3 > 4"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("4 > 3"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("3 <= 4"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("3 <= -4"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("3 <= 3"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("3 >= 4"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("3 >= -4"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("3 >= 3"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("3 == 3"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("3 == 4"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("3 == 2"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("3 != 3"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("3 != 4"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("3 != 2"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("2 < 3 && 1 == 1"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("2 > 3 && 1 == 1"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("2 < 3 && 1 == 2"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("2 < 3 || 1 == 1"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("2 > 3 || 1 == 1"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("2 > 3 || 1 == 2"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("1 + 2 >= 3 + 0"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("(3 < 3)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("!(3 < 3)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("(3 > 4)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("(3 == 3)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("!(3 == 3)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("(3 != 3)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("(2 < 3) && 1 == 1"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("(2 > 3) && (1 == 1)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("(2 < 3 && 1 == 2)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("(2 < 3) || (1 == 1)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("!1"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("!0"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("!2"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("((2 < 3) || (1 == 1)) && (3 < 3)"));

			/*
			 * These tests involve invalid expressions.
			 */
			assertException(evaluator, "3 3 < 3");
			assertException(evaluator, "3 << 3");
			assertException(evaluator, "3 <> 4");
			assertException(evaluator, "!!(3 <> 4)");
			assertException(evaluator, "3 = 4");
			assertException(evaluator, "2 < 3 && 1 = 1");
			assertException(evaluator, "(3) (3 < 3)");
			assertException(evaluator, "3 (<<) 3");
			assertException(evaluator, "(2 < 3) && (1 = 1");
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test expressions containing string operations.
	 */
	public void testEvaluateStringOperations() {
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * These tests involve valid expressions.
			 */
			assertEquals("'A'", evaluator.evaluate("'A'"));
			assertEquals("'AC'", evaluator.evaluate("'A' + 'C'"));
			assertEquals("'A + C'", evaluator.evaluate("'A + C'"));
			assertEquals("'ABC'", evaluator.evaluate("'AB' + 'C'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("'A' < 'C'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("'C' < 'A'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("'C' < 'F'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("'C' < 'c'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("'c' < 'C'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("'A' > 'C'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("'C' > 'A'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("'C' > 'F'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("'A' <= 'A'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("'C' <= 'A'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("'C' <= 'F'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("'A' >= 'A'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("'C' >= 'A'"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("'C' >= 'F'"));
			assertEquals("'A'", evaluator.evaluate("('A')"));
			assertEquals("'ABC'", evaluator.evaluate("('AB' + 'C')"));
			assertEquals("'123ABC'", evaluator.evaluate("'123' + ('AB' + 'C')"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("(('C' >= 'A'))"));

			/*
			 * These tests involve invalid expressions.
			 */
			assertException(evaluator, "A");
			assertException(evaluator, "A'");
			assertException(evaluator, "a + b");
			assertException(evaluator, "A' + 'C'");
			assertException(evaluator, "'A' + B' + 'C'");
			assertException(evaluator, "'A' + C");
			assertException(evaluator, "A + C");
			assertException(evaluator, "'A' - 'C'");
			assertException(evaluator, "A > C");
			assertException(evaluator, "A < C");
			assertException(evaluator, "'A') + C");
			assertException(evaluator, "('A') + (C");
			assertException(evaluator, "-'A'");
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test expressions containing variables.
	 */
	public void testEvaluateVariables() {
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * These tests involve valid expressions.
			 */
			assertEquals("2.718281828459045", evaluator.evaluate("#{E}"));
			assertEquals("3.141592653589793", evaluator.evaluate("#{PI}"));
			assertEquals("5.859874482048838", evaluator
					.evaluate("#{E} + #{PI}"));

			evaluator.putVariable("a", "'Hello'");
			evaluator.putVariable("b", "'World'");
			assertEquals("'Hello World!'", evaluator
					.evaluate("#{a} + ' ' + #{b} + '!'"));
			evaluator.clearVariables();

			evaluator.putVariable("a", "Hello");
			evaluator.putVariable("b", "World");
			assertEquals("'Hello World!'", evaluator
					.evaluate("'#{a}' + ' ' + '#{b}' + '!'"));
			evaluator.clearVariables();

			evaluator.putVariable("a", "'Hello'");
			evaluator.putVariable("b", "'World'");
			assertEquals("'Hello World!'", evaluator
					.evaluate("#{a} + ' ' + #{b} + '!'"));
			evaluator.clearVariables();

			evaluator.putVariable("x", "3");
			evaluator.putVariable("y", "5");
			assertEquals("3.0", evaluator.evaluate("#{x}"));
			assertEquals("7.0", evaluator.evaluate("4 + #{x}"));
			assertEquals("30.0", evaluator.evaluate("(4 + #{x} - 1) * #{y}"));
			assertEquals("1.0", evaluator.evaluate("#{x} / 3"));
			evaluator.clearVariables();

			evaluator.putVariable("x", "-3");
			evaluator.putVariable("y", "3");
			assertEquals("3.0", evaluator.evaluate("-#{x}"));
			assertEquals("0.0", evaluator.evaluate("#{x} + #{y}"));
			assertEquals("-1.0", evaluator.evaluate("#{x} / #{y}"));
			evaluator.clearVariables();

			/*
			 * These tests involve invalid expressions.
			 */
			evaluator.putVariable("a", "Hello");
			evaluator.putVariable("b", "World");
			// There are no quotes around the string variables.
			assertException(evaluator, "#{a} + ' ' + #{b} + '!'");
			evaluator.clearVariables();

			evaluator.putVariable("x", "3");
			evaluator.putVariable("y", "-3");
			assertException(evaluator, "4 + #{x");
			assertException(evaluator, "4 + x}");
			assertException(evaluator, "a + #{x}");
			assertException(evaluator, "a + #{y}");
			assertException(evaluator, "a + #{x + y}");
			assertException(evaluator, "a + #{x} + y");
			evaluator.clearVariables();

			/*
			 * These test involve a variable resolver.
			 */
			evaluator.setVariableResolver(new MockVariableResolver());
			assertEquals("1", evaluator.getVariableValue("MockVariable1"));
			assertEquals("2.0", evaluator.evaluate("#{MockVariable2}"));
			assertEquals("'2'", evaluator.evaluate("'#{MockVariable2}'"));
			assertEquals("3.0", evaluator
					.evaluate("#{MockVariable1} + #{MockVariable2}"));
			assertEquals(
					"4.0",
					evaluator
							.evaluate("#{MockVariable1} + #{MockVariable2} + #{MockVariable1}"));
			assertEquals("1.0", evaluator
					.evaluate("(#{MockVariable1} + #{MockVariable2}) " + ""
							+ "/ (#{MockVariable2} + #{MockVariable1})"));

			/*
			 * This test is for bug #2142824. When a variable changes, but the
			 * expression does not, the expression should use the new value in
			 * the variable. This test passes the variable into a function.
			 */
			String expr = "#{var1} + abs(#{var2})";
			evaluator.putVariable("var1", "2");
			evaluator.putVariable("var2", "-3");
			String result = evaluator.evaluate(expr);
			assertEquals("5.0", result);

			evaluator.putVariable("var1", "5");
			/* The bug causes this variable change to be ignored. */
			evaluator.putVariable("var2", "4");
			result = evaluator.evaluate(expr);
			assertEquals("9.0", result);
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}
	
	/**
	 * Test nested functions with variables.
	 */
	public void testNestedFunctionsWithVariables() {
		Evaluator evaluator = new Evaluator();

		try {
			// Test an expression with a nested function and a variable in that
			// function.
			String expr = "#{var1} + abs(sqrt(#{var2}))";
			evaluator.putVariable("var1", "2.0");
			evaluator.putVariable("var2", "9");
			evaluator.putVariable("var3", "-5");
			String result = evaluator.evaluate(expr);
			assertEquals("5.0", result);
			
			evaluator.putVariable("var1", "7");
			evaluator.putVariable("var2", "4");
			evaluator.putVariable("var3", "9");
			result = evaluator.evaluate(expr);
			assertEquals("9.0", result);		
			
			// Test an expression with a complex nested function and a variable in that
			// function.
			expr = "#{var1} + abs(sqrt(#{var2}) - #{var3})";
			evaluator.putVariable("var1", "2.0");
			evaluator.putVariable("var2", "9");
			evaluator.putVariable("var3", "-5");
			result = evaluator.evaluate(expr);
			assertEquals("10.0", result);
			
			evaluator.putVariable("var1", "7");
			evaluator.putVariable("var2", "4");
			evaluator.putVariable("var3", "9");
			result = evaluator.evaluate(expr);
			assertEquals("14.0", result);		
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}	

	/**
	 * Test expressions containing custom functions.
	 */
	public void testEvaluateCustomFunctions() {
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * These tests involve valid expressions.
			 */
			evaluator.putFunction(new MockStringReverseFunction());

			// This example function will reverse the order of the characters
			// in the input string.
			assertEquals("'tset'", evaluator.evaluate("stringReverse('test')"));
			assertEquals("'tset'", evaluator
					.evaluate("stringReverse('te' + 'st')"));
			evaluator.clearFunctions();

			/*
			 * These tests involve invalid expressions.
			 */
			evaluator.putFunction(new MockStringReverseFunction());
			assertException(evaluator, "stringReverse(test)");
			assertException(evaluator, "stringReverse(test");
			evaluator.clearFunctions();
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test expressions containing mathematical functions.
	 */
	public void testEvaluateMathematicalFunctions() {
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * These tests involve valid expressions.
			 */
			assertEquals("1.0", evaluator.evaluate("abs(-1)"));
			assertEquals("2.0", evaluator.evaluate("abs(-1) + 1"));
			assertEquals("0.0", evaluator.evaluate("abs(-1) - 1"));
			assertEquals("17.0", evaluator.evaluate("abs(2) + 3 * 5"));
			assertEquals("11.0", evaluator.evaluate("abs(2) * 3 + 5"));
			assertEquals("25.0", evaluator.evaluate("(abs(2) + 3) * 5"));
			assertEquals("6.0", evaluator.evaluate("abs((-3 * 2))"));
			assertEquals("2.0", evaluator.evaluate("1 + abs(-1)"));
			assertEquals("3.0", evaluator.evaluate("1 + abs(-1) + 1"));
			assertEquals("0.0", evaluator.evaluate("-abs(-1) + 1"));
			assertEquals("1.4706289056333368", evaluator.evaluate("acos(0.1)"));
			assertEquals("0.2013579207903308", evaluator.evaluate("asin(0.2)"));
			assertEquals("1.1263771168937977", evaluator.evaluate("atan(2.1)"));
			assertEquals("0.4636476090008061", evaluator
					.evaluate("atan2(0.1, 0.2)"));
			assertEquals("2.0", evaluator.evaluate("ceil(1.2)"));
			assertEquals("0.0707372016677029", evaluator.evaluate("cos(1.5)"));
			assertEquals("54.598150033144236", evaluator.evaluate("exp(4)"));
			assertEquals("1.0", evaluator.evaluate("floor(1.2)"));
			assertEquals("3.0", evaluator.evaluate("floor(1.2 + 2.4)"));
			assertEquals("-1.0", evaluator.evaluate("IEEEremainder(8, 3)"));
			assertEquals("2.1162555148025524", evaluator.evaluate("log(8.3)"));
			assertEquals("4.3", evaluator.evaluate("max(3.4, 4.3)"));
			assertEquals("3.4", evaluator.evaluate("min(3.4, 4.3)"));
			assertEquals("3.0", evaluator.evaluate("round(min(3.4, 4.3))"));
			assertEquals("3.5", evaluator
					.evaluate("max(min(3.4, 4.3), min(3.5, 4.2))"));
			assertEquals("8.0", evaluator.evaluate("pow(2, 3)"));
			assertEquals("2.0", evaluator.evaluate("rint(2.5)"));
			assertEquals("2.0", evaluator.evaluate("round(2.3)"));
			assertEquals("0.9974949866040544", evaluator.evaluate("sin(1.5)"));
			assertEquals("4.0", evaluator.evaluate("sqrt(16)"));
			assertEquals("0.7833269096274834", evaluator.evaluate("sin(0.9)"));
			assertEquals("286.4788975654116", evaluator
					.evaluate("toDegrees(5)"));
			assertEquals("0.08726646259971647", evaluator
					.evaluate("toRadians(5)"));

			/*
			 * These tests involve invalid expressions.
			 */
			assertException(evaluator, "abs)");
			assertException(evaluator, "abs(");
			assertException(evaluator, "abs()");
			assertException(evaluator, "Abs(-1)");
			assertException(evaluator, "acos()");
			assertException(evaluator, "ceil('1.2')");
			assertException(evaluator, "max(3.4)");
			assertException(evaluator, "round(min(3.4, 4.3)))");

		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test expressions containing string functions.
	 */
	public void testEvaluateStringFunctions() {
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * These tests involve valid expressions.
			 */
			assertEquals("'s'", evaluator.evaluate("charAt('test', 2)"));
			assertEquals("'stop'", evaluator
					.evaluate("charAt('test', 2) + 'top'"));
			assertTrue(Double
					.valueOf(evaluator.evaluate("compareTo('1', '2')"))
					.doubleValue() < 0);
			assertTrue(Double
					.valueOf(evaluator.evaluate("compareTo('1', '1')"))
					.doubleValue() == 0);
			assertTrue(Double
					.valueOf(evaluator.evaluate("compareTo('2', '1')"))
					.doubleValue() > 0);
			assertTrue(Double.valueOf(
					evaluator.evaluate("compareTo('aBc', 'abc')"))
					.doubleValue() < 0);
			assertTrue(Double.valueOf(
					evaluator.evaluate("compareTo('aBc', 'aBc')"))
					.doubleValue() == 0);
			assertTrue(Double.valueOf(
					evaluator.evaluate("compareTo('abc', 'aBc')"))
					.doubleValue() > 0);
			assertTrue(Double.valueOf(
					evaluator.evaluate("compareToIgnoreCase('aBc', 'abc')"))
					.doubleValue() == 0);
			assertEquals("'Hello World!'", evaluator
					.evaluate("concat('Hello ', 'World!')"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("endsWith('test', 't')"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("endsWith('test', 't') < 0"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("endsWith('test', 't') && endsWith('test', 'x')"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_FALSE, evaluator
					.evaluate("equals('abc', 'aBc')"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("equalsIgnoreCase('abc', 'aBc')"));
			assertEquals("3.0", evaluator
					.evaluate("indexOf('abcdef', 'de', 0)"));
			assertEquals("6.0", evaluator
					.evaluate("lastIndexOf('abcabcabc', 'abc', 8)"));
			assertEquals("3.0", evaluator.evaluate("length('abc')"));
			assertEquals("'dig'", evaluator
					.evaluate("replace('dog', 'o', 'i')"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("startsWith('test', 'e', 1)"));
			assertEquals("'cd'", evaluator
					.evaluate("substring('abcdef', 2, 4)"));
			assertEquals("'12'", evaluator
					.evaluate("substring('ab12ef', 2, 4)"));
			assertEquals("'abcdef'", evaluator
					.evaluate("toLowerCase('AbCdEf')"));
			assertEquals("'ABCDEF'", evaluator
					.evaluate("toUpperCase('AbCdEf')"));
			assertEquals("'abc'", evaluator.evaluate("trim('abc ')"));
			assertEquals("'abcd'", evaluator.evaluate("trim('abc ') + 'd'"));
			assertEquals("'abc def'", evaluator
					.evaluate("trim('abc ' + 'def ')"));
			assertEquals("'abc def'", evaluator
					.evaluate("trim(trim('abc ' + 'def '))"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("eval(endsWith('stop', 'p'))"));

			evaluator.putVariable("NAME", "Go");
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("startsWith('#{NAME}', 'G', 0)"));
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("endsWith('#{NAME}', 'o')"));

			// This example shows an unexpected result. The quotes cause the
			// expression to be treated as a string instead of an expression.
			// See the
			assertEquals("'1 + 2'", evaluator.evaluate("eval('1 + 2')"));

			// Try this syntax instead.
			assertEquals("3.0", evaluator.evaluate("eval(1 + 2)"));

			/*
			 * These tests involve invalid expressions.
			 */
			assertException(evaluator, "charAt(2)");
			assertException(evaluator, "concat(\"Hello \", \"World!\")");
			assertException(evaluator, "'abc '.trim()");

			// String variables require quotes around them when used in many
			// functions.
			assertException(evaluator, "startsWith(#{NAME}, 'G', 0)");
			assertException(evaluator, "endsWith(#{NAME}, 'o')");
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test expressions containing nested function calls.
	 */
	public void testNestedFunctions() {
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * These tests involve valid expressions.
			 */
			assertEquals("'a b c'", evaluator
					.evaluate("trim( trim(' a b c ') )"));
			assertEquals("'A B C'", evaluator
					.evaluate("toUpperCase(trim( trim(' a b c ') ))"));
			assertEquals("1.0", evaluator.evaluate("abs(abs(-1) * -1)"));
			assertEquals("0.6657737500283538", evaluator
					.evaluate("atan2(atan2(1, 1), 1)"));

			/*
			 * These tests involve invalid expressions.
			 */
			// atan2 can not take a string as the first argument in the nested
			// call.
			assertException(evaluator, "atan2(atan2('1', 1), 1)");

			// Create a new evaluator with nested function processing turned
			// off.
			evaluator = new Evaluator(EvaluationConstants.SINGLE_QUOTE, true,
					true, true, false);

			// This expression which worked earlier, no longer is valid, because
			// it contains a nested function call.
			assertException(evaluator, "trim( trim(' a b c ') )");
			
			// Make sure a function call that is not nested still works.
			assertEquals("'a b c'", evaluator.evaluate("trim(' a b c ')"));
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * Test expressions containing complex scenerios.
	 */
	public void testEvaluateComplexExpressions() {
		Evaluator evaluator = new Evaluator();

		try {
			/*
			 * These tests involve valid expressions.
			 */

			// This expression takes a numeric result from a string function
			// and adds it to a number.
			assertEquals("10.0", evaluator
					.evaluate("lastIndexOf('abcabcabc', 'abc', 8) + 4"));

			// This expression takes a mathematical result and uses it in a
			// Boolean operation.
			assertEquals(EvaluationConstants.BOOLEAN_STRING_TRUE, evaluator
					.evaluate("4 > (2 + 1)"));

			// This example ensure that a string can contain open and closed
			// braces.
			assertEquals("'{Hello World}'", evaluator
					.evaluate("'{' + 'Hello World' + '}'"));

			/*
			 * These tests involve invalid expressions.
			 */

			// Empty expression is not allowed.
			assertException(evaluator, "");

			// Trying to add a numer and a string together.
			assertException(evaluator, "5 + 'ABC'");

			// Trying to add a string and a number together.
			assertException(evaluator, "'ABC' + 5");

			// This string contains the start of a variable.
			assertException(evaluator, "'  #{  '");

			// The variable, zzz, does not exist.
			assertException(evaluator, "'#{zzz}'");
		} catch (Exception e) {
			throw new AssertionError(e);
		}
	}

	/**
	 * This method test Boolean expressions.
	 */
	public void testIsValidName() {
		final Evaluator evaluator = new Evaluator();

		// These are valid names.
		try {
			evaluator.isValidName("myFunction");
			evaluator.isValidName("my_function");
			evaluator.isValidName("my5Function");
		} catch (Exception e) {
			fail(e.toString());
		}

		// These are invalid names.
		assertInvalidName(evaluator, "0myFunction");
		assertInvalidName(evaluator, "1myFunction");
		assertInvalidName(evaluator, "2myFunction");
		assertInvalidName(evaluator, "3myFunction");
		assertInvalidName(evaluator, "4myFunction");
		assertInvalidName(evaluator, "5myFunction");
		assertInvalidName(evaluator, "6myFunction");
		assertInvalidName(evaluator, "7myFunction");
		assertInvalidName(evaluator, "8myFunction");
		assertInvalidName(evaluator, "9myFunction");

		assertInvalidName(evaluator, "my'Function");
		assertInvalidName(evaluator, "my\"Function");
		assertInvalidName(evaluator, "my{Function");
		assertInvalidName(evaluator, "my}Function");
		assertInvalidName(evaluator, "my#function");

		assertInvalidName(evaluator, "my(function");
		assertInvalidName(evaluator, "my)function");
		assertInvalidName(evaluator, "my+function");
		assertInvalidName(evaluator, "my-function");
		assertInvalidName(evaluator, "my*function");
		assertInvalidName(evaluator, "my/function");

		assertInvalidName(evaluator, "my!function");
	}

	private void assertInvalidName(final Evaluator evaluator, final String name) {
		try {
			evaluator.isValidName(name);

			fail();
		} catch (Exception e) {
			// We are expecting an exception.
		}
	}

	/**
	 * Convienence method for assert that an evaluation exception has occurrd.
	 * 
	 * @param evaluator
	 * @param expression
	 */
	private void assertException(Evaluator evaluator, String expression) {
		try {
			evaluator.evaluate(expression);
			throw new AssertionError(
					"The expression should have thrown an exception.");
		} catch (EvaluationException ee) {
			// If an exception is thrown, then we have been successful.
		}
	}
}
