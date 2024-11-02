import java.util.concurrent.atomic.*;
import java.util.*;

//aval class node ra tarif mikonim
class Node {

    public Node left, right;
    public int data;

    Node( int data )
    {
        this.data = data;
        this.left = this.right = null;
    }

}

public class countnodes {

    public static void main(String[] args) {
        // az karbar vurudi migirim
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for ( int i = 0 ; i < n ; i++ )
        {
            arr[i] = sc.nextInt();
        }

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();


        //node root az class node ra initialize mikonim
        Node root = null;
        for (int key: arr) {
            root = addition(root, key);
        }
        AtomicInteger answer = new AtomicInteger(0);
        count(root, num1, num2, answer);
        //javab ra print mikonim
        System.out.println(answer);
    }


    public static boolean count(Node root, int num1, int num2, AtomicInteger answer) {
        if (root == null)
        {

            return true;
        }
        //booleanhaye left va right ra tarif mikonim
        boolean left = count(root.left, num1, num2, answer);

        boolean right = count(root.right, num1, num2, answer);



        if (left && right && root.data <= num2 && root.data >= num1 )
        {
            answer.incrementAndGet();

            return true;
        }


        return false;

    }

    public static Node addition (Node root, int k)
    {
        if (root == null)
        {
            return new Node(k);
        }
        if (k > root.data) {
            root.right = addition(root.right, k);
        }
        if (k < root.data)
        {
            root.left = addition(root.left, k);
        }


        return root;

    }
}