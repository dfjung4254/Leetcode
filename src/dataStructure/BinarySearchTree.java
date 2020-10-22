package dataStructure;

public class BinarySearchTree {

    Node rootNode;

    public BinarySearchTree(Node rootNode) {
        this.rootNode = rootNode;
    }

    public void insert(int value) {

        /* non null */
        Node leafNode = search(value);

        if (leafNode.value == value) {
            /* already exist! */
            return;
        }

        if (value > leafNode.value) {
            leafNode.rightChild = new Node(value, leafNode);
        } else {
            leafNode.leftChild = new Node(value ,leafNode);
        }

    }

    public void delete(int value) {

        Node leafNode = search(value);

        /* have 0, 1, 2 children */
        if(leafNode.value != value){
            /* there no value to delete */
            return;
        }

        if(leafNode.leftChild == null && leafNode.rightChild == null){
            /* just delete */
        }else if(leafNode.leftChild != null && leafNode.rightChild == null){

        }else if(leafNode.leftChild == null && leafNode.rightChild != null){

        }else{

        }

    }

    public Node search(int value) {
        return searchRecursive(value, rootNode);
    }

    private Node searchRecursive(int value, Node pNode) {

        System.out.print(pNode.value + " -> ");
        if (pNode.value == value) {
            return pNode;
        } else if (pNode.value < value) {
            /* go right */
            if (pNode.rightChild == null) return pNode;
            return searchRecursive(value, pNode.rightChild);
        } else {
            if (pNode.leftChild == null) return pNode;
            return searchRecursive(value, pNode.leftChild);
        }

    }

}

class Node {

    int value;
    Node parent;
    Node leftChild;
    Node rightChild;

    public Node(int value, Node parent) {
        this.value = value;
        this.parent = parent;
    }

}
