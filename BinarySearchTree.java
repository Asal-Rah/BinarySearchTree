import java.util.*;

class Node {
    Node left, right;
    int key;

    Node(int key)
    {
        this.key = key;
    }
}

public class BinarySearchTree {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();

        int orders[] = new int[length];
        //array orders ra az karbar migirim
        for (int i = 0; i < length; i++)
        {

            orders[i] = sc.nextInt();

        }
        // root az class node ra tarif mikonim
        Node root = tree(orders, 0, orders.length - 1);

        print(root);
    }

    public static void print(Node root)
    {
        if (root == null)
        {

            return;

        }

        print(root.left);
        //value ra print mikonim
        System.out.print(root.key + " ");

        print(root.right);
    }

    public static Node tree( int[] arr, int first , int last )
    {
        if ( first > last )
        {
            return null;

        }
        else
        {
            Node node = new Node(arr[last]);
            int n;
            for ( n = last ; n >= first ; n = n -1 ) {
                if (arr[n] < node.key) {
                    break;
                }
            }

            node.right = tree(arr,n + 1 , last - 1);
            node.left = tree(arr, first, n );


            return node;
        }
    }

}

