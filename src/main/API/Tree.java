
import java.util.LinkedList;
import java.util.Stack;

class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
}

public class Tree {
    // 前序遍历  根据上文提到的遍历思路：根结点 ---> 左子树 ---> 右子树，很容易写出递归版本
    public void preOrderTraverse1(TreeNode root) {
        if (root != null) {
            System.out.print(root.val+"  ");
            preOrderTraverse1(root.left);
            preOrderTraverse1(root.right);
        }
    }

    // 现在讨论非递归的版本：
    public void preOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                System.out.print(pNode.val+"  ");
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                pNode = node.right;
            }
        }
    }

    // 中序遍历  左子树 ---> 根结点 ---> 右子树，很容易写出递归版本：
    public void inOrderTraverse1(TreeNode root) {
        if (root != null) {
            inOrderTraverse1(root.left);
            System.out.print(root.val+"  ");
            inOrderTraverse1(root.right);
        }
    }

    // 现在讨论非递归的版本：
    public void inOrderTraverse2(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode pNode = root;
        while (pNode != null || !stack.isEmpty()) {
            if (pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
            } else { //pNode == null && !stack.isEmpty()
                TreeNode node = stack.pop();
                System.out.print(node.val+"  ");
                pNode = node.right;
            }
        }
    }

    // 后序遍历  左子树 ---> 右子树 ---> 根结点，很容易写出递归版本：
    public void postOrderTraverse1(TreeNode root) {
        if (root != null) {
            postOrderTraverse1(root.left);
            postOrderTraverse1(root.right);
            System.out.print(root.val+"  ");
        }
    }

    // 非递归后序遍历
    public static void postorderTraversal(TreeNode root) {
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        TreeNode node = root;
        TreeNode lastVisit = root;
        while (node != null || !treeNodeStack.isEmpty()) {
            while (node != null) {
                treeNodeStack.push(node);
                node = node.left;
            }
            //查看当前栈顶元素
            node = treeNodeStack.peek();
            //如果其右子树也为空，或者右子树已经访问
            //则可以直接输出当前节点的值
            if (node.right == null || node.right == lastVisit) {
                System.out.print(node.val + " ");
                treeNodeStack.pop();
                lastVisit = node;
                node = null;
            } else {
                //否则，继续遍历右子树
                node = node.right;
            }
        }
    }

    // 层次遍历就是广度优先
    public void levelTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val+"  ");
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    // 其实深度遍历就是上面的前序、中序和后序。但是为了保证与广度优先遍历相照应

    public void depthOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.val+"  ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }

}
