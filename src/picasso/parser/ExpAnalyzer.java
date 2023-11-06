package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Exponential;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the exponential function.
 * 
 * @author Sara Sprenkle
 * @author Julia Raskin
 * 
 */
public class ExpAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the floor token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Exponential(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}
}