package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the Exponential function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * @author Julia Raskin
 * 
 */
public class Exponential extends UnaryFunction {

	/**
	 * Create a Exponential expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to Exponential
	 */
	public Exponential(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the Exponential of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the Exponential of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.exp(result.getRed());
		double green = Math.exp(result.getGreen());
		double blue = Math.exp(result.getBlue());

		return new RGBColor(red, green, blue);
	}
}
