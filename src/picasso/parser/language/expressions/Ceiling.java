package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents the ceiling function in the Picasso language.
 * 
 * @author Robert C. Duvall
 * @author Malachi Eberly
 * 
 */
public class Ceiling extends UnaryFunction {

	/**
	 * Create a ceiling expression that takes as a parameter the given expression
	 * 
	 * @param param the expression to ceiling
	 */
	public Ceiling(ExpressionTreeNode param) {
		super(param);
	}

	/**
	 * Evaluates this expression at the given x,y point by evaluating the ceiling of
	 * the function's parameter.
	 * 
	 * @return the color from evaluating the ceiling of the expression's parameter
	 */
	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result = param.evaluate(x, y);
		double red = Math.ceil(result.getRed());
		double green = Math.ceil(result.getGreen());
		double blue = Math.ceil(result.getBlue());

		return new RGBColor(red, green, blue);
	}

}
