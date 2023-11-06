/**
 * 
 */
package picasso.parser.tokens.operations;

import picasso.parser.language.CharConstants;
import picasso.parser.tokens.chars.CharToken;

/**
 * Token for Addition.
 * 
 */
public class PlusToken extends CharToken implements OperationInterface {

	public PlusToken() {
		super(CharConstants.PLUS);
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
