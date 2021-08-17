package common;

public class TreeUtil {
    public static TreeNode getTree() {
        TreeNode n1 = new TreeNode(-1);
        TreeNode n2 = new TreeNode(-2);
        TreeNode n3 = new TreeNode(-3);
        TreeNode n4 = new TreeNode(-4);
        TreeNode n5 = new TreeNode(-5);
        TreeNode n6 = new TreeNode(-6);
        TreeNode n7 = new TreeNode(-7);
        TreeNode n8 = new TreeNode(-8);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n5.right = n7;
        n6.left = n8;
        return n1;
    }
}
