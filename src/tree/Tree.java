package tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    public void add(int key) {
        root = add(root, key);
    }

    private Node add(Node current, int key) {
        if (current == null) {
            return new Node(key);
        }

        if (key < current.key) {
            current.left = add(current.left, key);
        } else if (key > current.key) {
            current.right = add(current.right, key);
        } else {
            return current;
        }
        return current;
    }

    public void printElements() {
        if (root == null) {
            System.out.println("Дерево пусто");
        } else {
            System.out.print("Элементы дерева:");
            printElements(root);
            System.out.println();
        }
    }

    private void printElements(Node currentNode) {
        if (currentNode != null) {
            printElements(currentNode.left);
            System.out.print(" " + currentNode.key);
            printElements(currentNode.right);
        }
    }

    public List<Integer> searchLessElements(int key) {
        List<Integer> result = new ArrayList<>();
        searchLessElements(root, key, result);
        return result;
    }

    private void searchLessElements(Node currentNode, int key, List<Integer> result) {
        if (currentNode != null) {
            searchLessElements(currentNode.left, key, result);

            if (currentNode.key < key) {
                result.add(currentNode.key);
                searchLessElements(currentNode.right, key, result);
            }
        }
    }

    public void printTreeView() {
        printTreeView(root, 0);
    }

    private void printTreeView(Node node, int depth) {
        if (node != null) {
            printTreeView(node.right, depth + 1);

            for (int i = 0; i < depth; i++) {
                System.out.print("   ");
            }
            System.out.println(node.key);
            printTreeView(node.left, depth + 1);
        }
    }
}