import java.util.LinkedList;
import java.util.Queue;

class Node1 {
    Node1 left, right;
    int data;

    Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BST {

    public void levelOrder(Node1 root) {
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node1 current = queue.remove();
            System.out.print(current.data + " ");
            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);
        }

    }
}
