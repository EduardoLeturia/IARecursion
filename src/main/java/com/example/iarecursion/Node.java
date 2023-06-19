package com.example.iarecursion;

//https://www.baeldung.com/java-binary-tree
public class Node {
    int value;
    int level;
    Node parent;
    Node left;
    Node right;

   public Node(int value, int level, Node parent) {
        this.value = value;
        this.level = level;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }



    public int getLevels() {
        int leftLevels = 0;
        int rightLevels = 0;

        if (left != null) {
            leftLevels = left.getLevels();
        }

        if (right != null) {
            rightLevels = right.getLevels();
        }

        return Math.max(leftLevels, rightLevels) + 1;
    }
}

