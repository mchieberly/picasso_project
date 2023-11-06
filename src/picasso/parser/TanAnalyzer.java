package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Tan;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the sin function.
 * 
 * @author Malachi Eberly
 * 
 */
public class TanAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the tan token
        
		return new Tan(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
