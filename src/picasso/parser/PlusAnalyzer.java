package picasso.parser;

import java.util.Stack;


import picasso.parser.language.ExpressionTreeNode;
import picasso.parser.language.expressions.Addition;
import picasso.parser.tokens.Token;

/**
 * Handles parsing the plus or "addition function".
 * 
 * @author Robert C. Duvall
 * @author Sara Sprenkle
 * 
 */
public class PlusAnalyzer implements SemanticAnalyzerInterface {

	@Override
	public ExpressionTreeNode generateExpressionTree(Stack<Token> tokens) {
		tokens.pop(); // Remove the plus token
		// the parameters are the next tokens on the stack.
		// But, they need to be processed
		// TODO: Need to finish.
//		Token token1 = tokens.pop();
		
//		Stack<Token> tokens1 = null;
//		tokens1.add(token1);
//		System.out.println(tokens);
		
		ExpressionTreeNode tokens1 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		ExpressionTreeNode tokens2 = SemanticAnalyzer.getInstance().generateExpressionTree(tokens);
		
		return new Addition(tokens2, tokens1);
//		return null;
	}

}
