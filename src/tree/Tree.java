package tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private Node root;

    private void searchLessElements(Node currentNode, int key, List<Integer> result) {
        if (currentNode != null) {
            searchLessElements(currentNode.left, key, result);

            if (currentNode.key < key) {
                result.add(currentNode.key);
                searchLessElements(currentNode.right, key, result);
            }
        }
    }

    public List<Integer> searchLessElements(int key) {
        List<Integer> result = new ArrayList<>();
        searchLessElements(root, key, result);
        return result;
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

    public void add(int key) {
        root = add(root, key);
    }

    private void print(Node currentNode) {
        if (currentNode != null) {
            print(currentNode.left);
            System.out.print(" " + currentNode.key);
            print(currentNode.right);
        }
    }

    public void print() {
        System.out.print("Дерево:");
        print(root);
        System.out.println();
    }
}