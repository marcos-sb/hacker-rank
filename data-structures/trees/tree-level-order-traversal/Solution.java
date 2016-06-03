/*

 class Node
    int data;
    Node left;
    Node right;
*/
void LevelOrder(Node root) {
    if(root != null) {
        Node current;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            current = q.poll();
            System.out.print(current.data + " ");
            if(current.left != null) q.offer(current.left);
            if(current.right != null) q.offer(current.right);
        }
    }
}
