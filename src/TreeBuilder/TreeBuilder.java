package TreeBuilder;
import java.util.ArrayList;
import java.util.List;

public class TreeBuilder {

    public static void main(String[] args){
        TreeNode root = build("[[5,2,10,1,3,8,13,null,null,null,4,null,null,11,15]]");
        System.out.println(root.key);
    }

    /**
     * @Author: Jianghong Ying
     * @Date: Apr.1st, 2019
     * @Email:YJianghong@gmail.com
     *
     * convert a String representing Binary Tree level order traversal
     * in LaiCode manner into a tree
     * @param string
     * @return TreeNode root
     */
    public static TreeNode build(String string){
        try {
            List<Integer> list = stringToList(string);
            return build(list);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author: Jianghong Ying
     * @Date: Apr.1st, 2019
     * @Email: YJianghong@gmail.com
     *
     * convert a string of integers representing Binary Tree
     * level order traversal in Laicode style into a list of
     * Integers
     *
     * @param string
     * @return list
     */
    public static List<Integer> stringToList(String string) throws Exception {
        if (string == null) {
            throw new Exception("string is null");
        }
        String[] numbers = string.split("[\\[\\],]");
        List<Integer> solution = new ArrayList<>();
        int j = 0;
        for (int i=0;i<numbers.length;i++) {
            if (numbers[i].length() == 0) {
                continue;
            }
            try {
                solution.add(j,Integer.parseInt(numbers[i]));
            } catch (Exception e){
                solution.add(j,null);
            }
            j++;
        }
        return solution;
    }
    /**
     * @Author: Jianghong Ying
     * @Date: Apr.1st, 2019
     * @Email: YJianghong@gmail.com
     *
     * Build tree according to list of Integers
     *
     * @param list: a list of Integers representing tree traversal in
     *              level order, i.e. LaiCode style, with null representing
     *              null TreeNode
     * @return TreeNode root: the root of new built tree
     * @throws Exception: throw when list is null
     */
    public static TreeNode build(List<Integer> list) throws Exception {
        if (list == null) {
            throw new Exception("List is null");
        } else if (list.isEmpty()) {
            return null;
        } else {
            List<TreeNode> tree = new ArrayList<>();
            for (int i=0;i<list.size();i++) {
                Integer treeValue = list.get(i);
                if (treeValue == null) {
                    tree.add(i,null);
                    continue;
                }
                TreeNode child = new TreeNode(treeValue);
                tree.add(i,child);

                // link child back to suitable parent node
                if (i > 0) {
                    TreeNode parent = tree.get((i-1)/2);
                    if ((i-1) % 2 == 0) {
                        parent.left = child;
                    } else {
                        parent.right = child;
                    }
                }
            }
            return tree.get(0);
        }

    }
}
