package tree;

public class Node {
    final int key;
    Node left;
    Node right;

    Node(int key) {
        this.key = key;
        left = null;
        right = null;
    }
}
