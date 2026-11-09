package implementation.tree.binarytree;

import java.util.ArrayList;
import java.util.List;

import static implementation.tree.binarytree.BinaryTree.*;

/*
    实际演示
 */
public class BinaryTreeDemo {
    static void main(String[] args) {

        // 初始化二叉树
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);

        // 构造结点之间的引用
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        // 插入操作：在 n1 和 n2 之间，插入 P
        TreeNode P = new TreeNode(0);
        n1.left = P;
        P.left = n2;

        // 删除操作：删除结点 P
        n1.left = n2;

        // 【遍历】
        // 进行前序遍历 —— 1 2 4 5 3 6
        List<Integer> resOfPreorder = preorderTraversal(n1,new ArrayList<Integer>());
        System.out.println(resOfPreorder);

        // 进行中序遍历 —— 4 2 5 1 3 6
        List<Integer> resOfInorder = inorderTraversal(n1,new ArrayList<>());
        System.out.println(resOfInorder);

        // 进行后序遍历 —— 4 5 2 6 3 1
        List<Integer> resOfPostorder = postorderTraversal(n1,new ArrayList<>());
        System.out.println(resOfPostorder);

        // 进行层序遍历 —— 1 2 3 4 5 6
        List<Integer> resOflevelOrder = levelOrderTraversal(n1);
        System.out.println(resOflevelOrder);
    }
}
