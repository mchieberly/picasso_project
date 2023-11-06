package picasso.parser.language.expressions;

import picasso.parser.language.ExpressionTreeNode;

/**
 * Represents a plus operation.
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 *
 */
public class Addition extends ExpressionTreeNode {

	ExpressionTreeNode left;
	ExpressionTreeNode right;

	/**
	 * 
	 * @param param
	 */
	public Addition(ExpressionTreeNode param1, ExpressionTreeNode param2) {
		this.left = param1;
		this.right = param2;
	}

	/**
	 * Returns the string representation of the function in the format "<ClassName>:
	 * <parameter>"
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String classname = this.getClass().getName();
		return classname.substring(classname.lastIndexOf(".")) + "(" + left + "," + right + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Addition)) {
			return false;
		}

		// Make sure the objects are the same type

		if (o.getClass() != this.getClass()) {
			return false;
		}

		Addition a = (Addition) o;

		// check if their parameters are equal
		if (!this.left.equals(a.left)) {
			return false;
		}
		return true;
	}

	@Override
	public RGBColor evaluate(double x, double y) {
		RGBColor result1 = left.evaluate(x, y);
		RGBColor result2 = right.evaluate(x, y);
		double red = result1.getRed() + result2.getRed();
		double green = result1.getGreen() + result2.getGreen();
		double blue = result1.getBlue() + result2.getBlue();

		return new RGBColor(red, green, blue);	}

}
