import utils.tree.TreeNode;

public class Sro26IsSubStructure {

    public static void main(String[] args) {
        Sro26IsSubStructure obj = new Sro26IsSubStructure();
        TreeNode A = new TreeNode(new int[]{1,0,1,-4,-3});
        TreeNode B = new TreeNode(new int[]{1,-4});
        System.out.println(obj.isSubStructure(A, B));
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;
        return isSameRootSubTree(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean isSameRootSubTree(TreeNode a, TreeNode b){
        if (a.val != b.val) return false;
        boolean leftRes = (b.left == null) || (a.left!= null && isSameRootSubTree(a.left, b.left));
        if (!leftRes) return false;
        return (b.right == null) || (a.right != null && isSameRootSubTree(a.right, b.right));
    }
}
