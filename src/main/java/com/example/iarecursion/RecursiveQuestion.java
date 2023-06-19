package com.example.iarecursion;

import javafx.scene.Node;

import java.util.ArrayList;

public class RecursionQuestion {
    static Node root;
    static Node rootPerfect;
    static ArrayList<String> answersToPrint = new ArrayList<>();

    public RecursionQuestion(int n) {
        root = mystery(n, 0, null);
        rootPerfect = copyAndModifyRoot(root);
        answersToPrint.add("Answers:");
        answersToPrint.add("F(" + n + ")");

        printAllLine();
        printLine(1);

        answersToPrint.add("");
        int levels = root.getLevels();

        int result = calculateF(n);
        answersToPrint.add("Result: " + result);

    }

    private static void printAllLine() {
        for (int i = 1; i < root.getLevels(); i++) {
            printLine(i);
            answersToPrint.add("");
        }
    }

    private static void printLine(int line) {
        ArrayList<String> toPrint = getTraceTableLine(rootPerfect, 0, line);
        int counter = 0;
        String myLineString = "";
        for (String s : toPrint) {
            myLineString += s;
            if (counter < toPrint.size() - 1) {
                myLineString += " + ";
                counter++;
            }
        }
        toPrint.clear();
    }


    private static Node mystery(int n, int level, Node parent) {
        if (n == 0) {
            return new Node(0, level, parent);
        } else if (n == 1) {
            return new Node(1, level, parent);
        }

        Node node = new Node(n, level, parent);
        node.setLeft(mystery(n - 1, level + 1, node));
        node.setRight(mystery(n - 2, level + 1, node));

        return node;
    }

    private static ArrayList<String> getTraceTableLine(Node node, int level, int line) {
        ArrayList<String> toPrint = new ArrayList<>();
        if (node == null) {
            return null;
        }

        if (level == line) {
            if (node.getParent().getValue() == 1 || node.getParent().getValue() == 0) {
                toPrint.add(String.valueOf(node.getValue()));
            } else {
                toPrint.add("F(" + node.getValue() + ")");
            }
        }

        toPrint.addAll(getTraceTableLine(node.getLeft(), level + 1, line));
        toPrint.addAll(getTraceTableLine(node.getRight(), level + 1, line));


        return toPrint;
    }

    private static int calculateF(int n) {
        if (n <= 1) {
            return n;
        }
        return calculateF(n - 1) + calculateF(n - 2);
    }

    public static Node copyAndModifyRoot(Node n) {
        if (n == null) {
            return null;
        }

        Node copiedRoot = new Node(n.getValue(), n.getLevel(), n.getParent());

        if (copiedRoot.getValue() == 1 || copiedRoot.getValue() == 0) {
            int levelsToGo = root.getLevels() - n.getLevel();
            Node currentNode = copiedRoot;
            for (int i = 1; i <= levelsToGo; i++) {
                currentNode.setRight(new Node(copiedRoot.getValue(), n.getLevel() + 1, n));
                currentNode = currentNode.getRight();
            }
        } else {
            copiedRoot.setLeft(copyAndModifyRoot(n.getLeft()));
            copiedRoot.setRight(copyAndModifyRoot(n.getRight()));
        }
        return copiedRoot;
    }
    
}