package picasso.parser;

import java.util.Stack;

import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Cos;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the cos function.
 * 
 * @author Malachi Eberly
 * 
 */
public class CosAnalyzer extends UnaryFunctionAnalyzer {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Need to remove the cos token
        
		return new Cos(SemanticAnalyzer.getInstance().generateExpressionTree(
				tokens));
	}

}
