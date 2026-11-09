package implementation.tree.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.Integer;
import java.util.Queue;

/*
    二叉树的相关操作
 */
public class BinaryTree {

    /*
        二叉树的遍历
     */

    // 1.前序遍历 值->左->右
    public static List<Integer>  preorderTraversal(TreeNode root,List<Integer> res) {
        if(root == null) return res;
        res.add(root.val);
        preorderTraversal(root.left,res);
        preorderTraversal(root.right,res);
        return res;
    }
    // 2.中序遍历 左->值->右
    public static List<Integer> inorderTraversal(TreeNode root,List<Integer> res ) {
        if(root == null) return res;
        inorderTraversal(root.left,res);
        res.add(root.val);
        inorderTraversal(root.right,res);
        return res;
    }

    // 3.后序遍历 左->右->值
    public static List<Integer> postorderTraversal(TreeNode root,List<Integer> res ) {
        if(root == null) return res;
        postorderTraversal(root.left,res);
        postorderTraversal(root.right,res);
        res.add(root.val);
        return res;
    }

    // 4.层序遍历 自上而下，逐层遍历
    public static List<Integer> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return res;
    }
}
