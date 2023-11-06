package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Ceiling;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the ceiling function.
 * 
 * @author Malachi Eberly
 * 
 */
public class CeilAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the ceiling token
		// the parameter is the next token on the stack.
		// But, it needs to be processed
		return new Ceiling(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
