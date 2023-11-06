/**
 * 
 */
package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.*;

/**
 * Tests of the evaluation of x
 * 
 * @author Sara Sprenkle
 * 
 */
public class EvaluatorTests {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	@Test
	public void testConstantEvaluation() {
		ExpressionTreeNode e = new RGBColor(1, -1, 1);
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(1, -1, 1), e.evaluate(i, i));
		}
	}

	@Test
	public void testXEvaluation() {
		X x = new X();
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), x.evaluate(i, i));
		}
	}

	@Test
	public void testFloorEvaluation() {
		Floor myTree = new Floor(new X());

		// some straightforward tests
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-1, -1, -1), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };

		for (double testVal : tests) {
			double floorOfTestVal = Math.floor(testVal);
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(floorOfTestVal, floorOfTestVal, floorOfTestVal),
					myTree.evaluate(testVal, testVal));
		}
	}

	// TODO: More tests of evaluation
	@Test
	public void testAbsEvaluation() {
		Absolute myTree = new Absolute(new X());
		assertEquals(new RGBColor(.4, .4, .4), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(.999, .999, .999), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(.7, .7, .7), myTree.evaluate(-.7, -1));

		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(1, 8));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(0, 8));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(-1, 8));

		double[] tests = { -.7, -.00001, .000001, .5 };
		for (double testVal : tests) {
			double absOfTestVal = Math.abs(testVal);
			assertEquals(new RGBColor(absOfTestVal, absOfTestVal, absOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(absOfTestVal, absOfTestVal, absOfTestVal), myTree.evaluate(testVal, testVal));
		}

	}

	@Test
	public void testCeilEvaluation() {
		Ceiling myTree = new Ceiling(new X());
		// some straightforward tests
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(1, 1, 1), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(0, 0, 0), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, -i));
			assertEquals(new RGBColor(i, i, i), myTree.evaluate(i, i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };
		for (double testVal : tests) {
			double ceilOfTestVal = Math.ceil(testVal);
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(ceilOfTestVal, ceilOfTestVal, ceilOfTestVal), myTree.evaluate(testVal, testVal));
		}
	}

	@Test
	public void testExpEvaluation() {
		Exponential myTree = new Exponential(new X());
		assertEquals(new RGBColor(Math.exp(.4), Math.exp(.4), Math.exp(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.exp(.999), Math.exp(.999), Math.exp(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.exp(-.7), Math.exp(-.7), Math.exp(-.7)), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.exp(i), Math.exp(i), Math.exp(i)), myTree.evaluate(i, -i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };
		for (double testVal : tests) {
			double expOfTestVal = Math.exp(testVal);
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(expOfTestVal, expOfTestVal, expOfTestVal), myTree.evaluate(testVal, testVal));
		}
	}

	@Test
	public void testSinEvaluation() {
		Sin myTree = new Sin(new X());
		assertEquals(new RGBColor(Math.sin(.4), Math.sin(.4), Math.sin(.4)), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(Math.sin(.999), Math.sin(.999), Math.sin(.999)), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(Math.sin(-.7), Math.sin(-.7), Math.sin(-.7)), myTree.evaluate(-.7, -1));

		// test the ints; remember that y's value doesn't matter
		for (int i = -1; i <= 1; i++) {
			assertEquals(new RGBColor(Math.sin(i), Math.sin(i), Math.sin(i)), myTree.evaluate(i, -i));
		}

		double[] tests = { -.7, -.00001, .000001, .5 };
		for (double testVal : tests) {
			double sinOfTestVal = Math.sin(testVal);
			assertEquals(new RGBColor(sinOfTestVal, sinOfTestVal, sinOfTestVal), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(sinOfTestVal, sinOfTestVal, sinOfTestVal), myTree.evaluate(testVal, testVal));
		}
	}

	@Test
	public void testAdditionEvaluation() {
		Addition myTree = new Addition(new X(), new Y());
		assertEquals(new RGBColor(.4+-1, .4+-1, .4+-1), myTree.evaluate(.4, -1));
		assertEquals(new RGBColor(.999+-1, .999+-1, .999+-1), myTree.evaluate(.999, -1));
		assertEquals(new RGBColor(-.7+-1, -.7+-1, -.7+-1), myTree.evaluate(-.7, -1));
		
		double[] tests = { -.7, -.00001, .000001, .5 };
		for (double testVal : tests) {
			assertEquals(new RGBColor(testVal+-1, testVal+-1, testVal+-1), myTree.evaluate(testVal, -1));
			assertEquals(new RGBColor(testVal+ testVal, testVal+ testVal, testVal+ testVal), myTree.evaluate(testVal, testVal));
		}
	}
}
