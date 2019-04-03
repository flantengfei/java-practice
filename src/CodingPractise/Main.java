package CodingPractise;

import java.util.*;
import BTreePrinter.*;
import TreeBuilder.*;

public class Main {
	public static void main(String[] args) {
		TreeNode root = TreeBuilder.build("[1,2,3,null,null,4]");
		BTreePrinter.printTree(root);
		//System.out.println(Solution.isBalanced(root));
	}
}

