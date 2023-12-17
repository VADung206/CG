/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/
public static int[] a = new int[1000005];
public static int sz = 0;
        void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);
        a[sz++] = root.data;
        inorder(root.right);
        }
        boolean checkBST(Node root) {
        inorder(root);
        for (int i = 1; i < sz; ++i){
        if (a[i] <= a[i-1]) return false;
        }
        return true;
        }