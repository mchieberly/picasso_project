/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Token for Division.
 * 
 */
public class DivToken extends CharToken implements OperationInterface {

	public DivToken() {
		super(CharConstants.SLASH);
	}

	/**
	 * @see picasso.parser.tokens.Token#isConstant()
	 */
	@Override
	public boolean isConstant() {
		return false;
	}

	/**
	 * @see picasso.parser.tokens.Token#isFunction()
	 */
	@Override
	public boolean isFunction() {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		return obj.getClass().equals(this.getClass());
	}

}
