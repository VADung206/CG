/* Class node is defined as :
class Node
    int val;    //Value
    int ht;        //Height
    Node left;    //Left child
    Node right;    //Right child

*/

static Node insert(Node root,int val) {
        if (root == null) {
        root = new Node();
        root.val = val;
        return root;
        }
        if      (val > root.val)    root.right = insert(root.right, val);
        else if (val < root.val)    root.left  = insert(root.left, val);
        else                        return root;


        root.ht = Math.max(getHeight(root.left), getHeight(root.right)) + 1;


        if (getBF(root) > 1) {

        if (getBF(root.left) >= 0) {
        return rightRotate(root);
        } else {

        root.left = leftRotate(root.left);
        return rightRotate(root);
        }


        } else if (getBF(root) < -1) {

        if (getBF(root.right) <= 0) {
        return leftRotate(root);
        } else {

        root.right = rightRotate(root.right);
        return leftRotate(root);
        }
        }

        return root;
        }

static Node rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;

        x.ht = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.ht = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
        }

static Node leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;

        x.ht = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        y.ht = Math.max(getHeight(y.left), getHeight(y.right)) + 1;

        return y;
        }


static int getBF(Node x) {
        if (x == null) return 0;
        return getHeight(x.left) - getHeight(x.right);
        }

static int getHeight(Node x) {
        if (x == null) return -1;
        return x.ht;
        }
