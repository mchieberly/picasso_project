package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Absolute;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the absolute analyzer function.
 * 
 * @author Sara Sprenkle
 * 
 */
public class AbsAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the absolute token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Absolute(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
