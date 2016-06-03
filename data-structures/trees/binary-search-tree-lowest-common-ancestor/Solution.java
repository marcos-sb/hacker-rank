
 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

static Node lca(Node root,int v1,int v2) {
    if(root == null) return null;
    if(root.data == v1 || root.data == v2) return root;

    Node lcal = lca(root.left,v1,v2);
    Node lcar = lca(root.right,v1,v2);
    if(lcal != null && lcar != null) return root;
    if(lcal != null) return lcal;
    if(lcar != null) return lcar;

    //both null
    return null;
}
