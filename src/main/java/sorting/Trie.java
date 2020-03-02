package sorting;

import java.util.ArrayList;

/**
 * Trie
 */
public class Trie {
    private static ArrayList<String> result = new ArrayList<>();

    private Node root;

    public Trie() {
        root = null;
    }

    public void insert(String key, int index) {
        if (root == null) {
            root = new Node();
        }

        Node curNode = root;

        for (int i = 0; i < key.length(); i++) {
            char charKey = key.charAt(i);

            if (curNode.getChild(charKey) == null) {
                curNode.addChild(charKey);
            }

            curNode = curNode.getChild(charKey);
        }
        // System.out.println(key + " : " + index);
        curNode.addIndex(index);
    }

    public void traverse(String[] array) {
        traverse(root, array);
    }

    private void traverse(Node node, String[] array) {
        if (node == null) {
            return;
        }

        if (node.getIndices().size() > 0) {
            for (int index : node.getIndices()) {
                // System.out.println(nextIndex + " : " + index);
                result.add(array[index]);
            }
        }

        for (char index = 'a'; index <= 'z'; index++) {
            traverse(node.getChild(index), array);
        }
    }

    public String[] getResult() {
        return result.toArray(new String[result.size()]);
    }

}