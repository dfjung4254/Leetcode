package dataStructure;

public class DataStructureMain {

    public static void main(String[] args){

        BinarySearchTree bst = new BinarySearchTree(new Node(10, null));


        bst.insert(6);
        bst.insert(13);
        bst.insert(3);
        bst.insert(7);
        bst.insert(8);
        bst.insert(15);

        bst.search(14);
        System.out.println();
        bst.insert(14);
        System.out.println();
        bst.search(14);
        System.out.println();
        bst.insert(11);
        System.out.println();
        bst.insert(9);
        System.out.println();
        bst.search(11);
        System.out.println();
        bst.search(9);

    }

}
