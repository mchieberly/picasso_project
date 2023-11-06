package picasso.parser;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Division;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the slash or "division operation".
 * 
 * @author Robert C. Duvall
 * @author Malachi Eberly
 * 
 */
public class DivAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the token

		ExpressionTreeNode node1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode node2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new Division(node2, node1);
	}

}
